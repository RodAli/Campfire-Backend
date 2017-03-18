DROP SCHEMA IF EXISTS campfire CASCADE;
CREATE SCHEMA campfire;
SET search_path TO campfire;

-- Remove the previous data from the database
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS taking CASCADE;
DROP TABLE IF EXISTS assignment CASCADE;
DROP TABLE IF EXISTS assignmentgroup CASCADE;
DROP TABLE IF EXISTS membership CASCADE;

-- Table to store all the students information
CREATE TABLE student (
  email varchar(20) PRIMARY KEY,
  fname varchar(20) NOT NULL,
  lname varchar(20) NOT NULL,
  pass varchar(20) NOT NULL,
  description text,
  comparable text
);

-- Table to store all the course information
CREATE TABLE course (
  code varchar(20) PRIMARY KEY,
  name text NOT NULL,
  instructor varchar(20) NOT NULL
);

-- Table to let us know what students are in which course
CREATE TABLE taking (
  email varchar(20) REFERENCES student,
  code varchar(20) REFERENCES course
);

-- Stores the assignments that are part of each course
CREATE TABLE assignment (
  assignment_id integer PRIMARY KEY,
  name varchar(20),
  code varchar(20) REFERENCES course,
  max_size integer NOT NULL
);

-- Stores the groups formed in each assignment
CREATE TABLE assignmentgroup (
  group_id integer PRIMARY KEY,
  assignment_id integer REFERENCES assignment
);

-- Stores the students that are part of each group
CREATE TABLE membership (
  email varchar(20) REFERENCES student,
  group_id integer REFERENCES assignmentgroup
);


-- Insert a set amount of starting data into the database
INSERT INTO student VALUES ('rod@mail.com', 'Rod', 'Mazloomi', 'pass1', 'I like math', null);
INSERT INTO student VALUES ('adam@mail.com', 'Adam', 'Capparelli', 'pass2', 'I like programming in C++', null);
INSERT INTO student VALUES ('vlad@mail.com', 'Vlad', 'Chapurny', 'pass3', 'I like working in SQL', null);
INSERT INTO student VALUES ('jonathan@mail.com', 'Jonathan', 'Pelastine', 'pass4', 'I like working on group assignments', null);
INSERT INTO student VALUES ('fullchee@mail.com', 'Fullchee', 'Zhang', 'pass5', 'I like programming in Java!', null);
INSERT INTO student VALUES ('quinn@mail.com', 'Quinn', 'Daneyko', 'pass6', 'I like working in android studio', null);
INSERT INTO student VALUES ('andrew@mail.com', 'Andrew', 'Goupil', 'pass7', 'I like linear algebra', null);

INSERT INTO course VALUES ('CSC108', 'Intro to Programming', 'Diane Horton');
INSERT INTO course VALUES ('CSC148', 'Intro to Computer Science', 'Danny Heap');
INSERT INTO course VALUES ('CSC207', 'Intro to Java and Object Oriented Design', 'Paul Gries');
INSERT INTO course VALUES ('CSC309', 'Web Devolopment and Design', 'Karen Reid');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC108');
INSERT INTO taking VALUES ('adam@mail.com', 'CSC108');
INSERT INTO taking VALUES ('vlad@mail.com', 'CSC108');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC148');
INSERT INTO taking VALUES ('vlad@mail.com', 'CSC148');
INSERT INTO taking VALUES ('andrew@mail.com', 'CSC148');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC207');
INSERT INTO taking VALUES ('jonathan@mail.com', 'CSC207');
INSERT INTO taking VALUES ('fullchee@mail.com', 'CSC207');
INSERT INTO taking VALUES ('quinn@mail.com', 'CSC207');
INSERT INTO taking VALUES ('adam@mail.com', 'CSC207');
INSERT INTO taking VALUES ('vlad@mail.com', 'CSC207');
INSERT INTO taking VALUES ('andrew@mail.com', 'CSC207');


INSERT INTO taking VALUES ('rod@mail.com', 'CSC309');
INSERT INTO taking VALUES ('jonathan@mail.com', 'CSC309');
INSERT INTO taking VALUES ('fullchee@mail.com', 'CSC309');
INSERT INTO taking VALUES ('quinn@mail.com', 'CSC309');

INSERT INTO assignment VALUES (1000, 'A1', 'CSC207', 2);

INSERT INTO assignmentgroup VALUES (2000, 1000);
INSERT INTO assignmentgroup VALUES (2001, 1000);

INSERT INTO membership VALUES ('rod@mail.com', 2000), ('jonathan@mail.com', 2000);
INSERT INTO membership VALUES ('adam@mail.com', 2001), ('vlad@mail.com', 2001);
