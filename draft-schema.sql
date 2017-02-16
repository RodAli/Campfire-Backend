-- the primary key doesn't have to be the student number
CREATE TABLE Students (
	student_id INTEGER PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL

);

CREATE TABLE Classes (
	class_name TEXT NOT NULL,
	student_id INTEGER,
	FOREIGN KEY (student_id) REFERENCES Students(student_id)

);

CREATE TABLE Interests (
	FOREIGN KEY(id) REFERENCES customers(id),
	student_id INTEGER,
	interest TEXT NOT NULL,
	FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

CREATE TABLE Schedule {
	


};