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
  instructor varchar(255) NOT NULL,
  PRIMARY KEY (code)
  -- since we're dealing with just CS courses, code is a key
);

DROP TABLE IF EXISTS course;
CREATE TABLE taking (
  code varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  FOREIGN KEY (code) REFERENCES course(code),
  FOREIGN KEY (email) REFERENCES student(email),
  PRIMARY KEY (code, email)
);