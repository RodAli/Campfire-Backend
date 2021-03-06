package database;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UpdateDatabaseThread extends AsyncTask<Void, Void, Void>{
    // INFORMATION TO CONNECT TO THE DATABASE
    private final String url = "jdbc:postgresql://campfiredb.crno8vrpqmdl.ca-central-1.rds.amazonaws.com:5432/campfiredb?sslmode=require";
    private final String username = "camper";
    private final String password = "fireplace123";

    private Connection connection;
    private String query;
    private List<String> arguments;

    public UpdateDatabaseThread(String query, List<String> arguments){
        if (query == null){
            throw new IllegalArgumentException();
        }
        this.query = query;
        this.arguments = arguments;
    }


    @Override
    public Void doInBackground(Void... params) {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pstatement = this.connection.prepareStatement("SET search_path TO campfire");
            pstatement.execute();
            PreparedStatement statement = connection.prepareStatement(this.query);
            if (this.arguments != null) {
                for (int i = 0; i < this.arguments.size(); i++) {
                    statement.setString(i + 1, this.arguments.get(i));
                }
            }
            statement.execute();
            this.connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


