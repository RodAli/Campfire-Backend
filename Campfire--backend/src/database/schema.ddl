DROP SCHEMA IF EXISTS campfire CASCADE;
CREATE SCHEMA campfire;
SET search_path TO campfire;

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
	name varchar(20) NOT NULL,
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
	max_size integer NOT NULL,
);

-- Stores the groups formed in each assignment
CREATE TABLE assignmentgroup (
	group_id integer PRIMARY KEY,
	assignment_id integer REFERENCES assignment
);

-- Stores the students that are part of each group
CREATE TABLE membership (
	email varchar(20),
	group_id varchar(20)
);