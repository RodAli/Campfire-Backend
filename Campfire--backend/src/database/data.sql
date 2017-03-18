-- Remove the previous data from the database
TRUNCATE TABLE student CASCADE;
TRUNCATE TABLE course CASCADE;
TRUNCATE TABLE taking CASCADE;
TRUNCATE TABLE assignment CASCADE;
TRUNCATE TABLE assignmentgroup CASCADE;
TRUNCATE TABLE membership CASCADE;

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

INSERT INTO assignmentgroup (2000, 1000);
INSERT INTO assignmentgroup (2001, 1000);

INSERT INTO membership ('rod@mail.com', 2000);
INSERT INTO membership ('jonathan@mail.com', 2000);
INSERT INTO membership ('adam@mail.com', 2001);
INSERT INTO membership ('vlad@mail.com', 2001);