package database;

import java.util.ArrayList;

import algorithms.Student;

/**
 * Created by Rod on 21/03/2017.
 */

public class DbAdapter {

    private DbAdapter (){}

    public static void addStudent(Student student){

        //TODO Check that the student does not exist

        ArrayList<String> args = new ArrayList<String>();
        args.add(student.getEmail());
        args.add(student.getFname());
        args.add(student.getLname());
        args.add(student.getPass());
        args.add(student.getDescription());
        UpdateDatabaseThread udb;
        if (student.getCriteria() == null){
            udb = new UpdateDatabaseThread("INSERT INTO student VALUES (?, ?, ?, ?, ?, null)", args);
        } else {
            args.add(Serializer.serialize(student.getCriteria()));
            udb = new UpdateDatabaseThread("INSERT INTO student VALUES (?, ?, ?, ?, ?, ?)", args);
        }
        udb.execute();
    }

    public static void getAllStudents(DatabaseThread.Listener listener){
        DatabaseThread db = new DatabaseThread(listener, "SELECT * FROM student", null);
        db.execute();
    }
}
