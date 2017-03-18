-- TODO: change this name to the given Amazon RDS name when setup
CREATE DATABASE IF NOT EXISTS campfire_db;
USE campfire_db;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  fname varchar(255) NOT NULL,
  lname varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  pass varchar(255) NOT NULL,  -- TODO: encrypt the password
  description varchar(255) NOT NULL,
  comparable varchar(255) NOT NULL,
  PRIMARY KEY (email)
);

DROP TABLE IF EXISTS course;
CREATE TABLE course (
  code varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  instructor varchar(255),
  PRIMARY KEY (code)
);

DROP TABLE IF EXISTS course;
CREATE TABLE taking (
  code varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  FOREIGN KEY (code) REFERENCES course(code),
  FOREIGN KEY (email) REFERENCES student(email),
  PRIMARY KEY (code, email)
);


-- Starter initial data on schema load
INSERT INTO student VALUES 
("Stan", "Marsh", "marsh@mail.utoronto.ca", "password", "My name is Stan Marsh", "TODO: get a proper serialization of this student");

INSERT INTO course VALUES 
("CSC207", "Software Design", "marsh@mail.utoronto.ca", "Lindsey Shorser");

INSERT INTO taking VALUES
("CSC207", "marsh@mail.utoronto.ca");
