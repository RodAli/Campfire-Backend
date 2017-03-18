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