DROP SCHEMA IF EXISTS campfire CASCADE;
CREATE SCHEMA campfire;
SET search_path TO campfire;

-- Remove the previous data from the database
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS taking CASCADE;
DROP TABLE IF EXISTS campfire_group CASCADE;
DROP TABLE IF EXISTS group_membership CASCADE;
DROP TABLE IF EXISTS chats CASCADE;
DROP TABLE IF EXISTS chat_line CASCADE;
DROP TABLE IF EXISTS course_pins CASCADE;
DROP TABLE IF EXISTS group_pins CASCADE;

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
  email varchar(20) REFERENCES student ON UPDATE CASCADE ON DELETE CASCADE,
  code varchar(20) REFERENCES course ON UPDATE CASCADE ON DELETE CASCADE
);

-- Stores the groups formed by students
CREATE TABLE campfire_group (
  group_id integer PRIMARY KEY,
  name varchar(20),
  size integer
);

-- Stores the students that are part of each group
CREATE TABLE group_membership (
  email varchar(20) REFERENCES student ON UPDATE CASCADE ON DELETE CASCADE,
  group_id integer REFERENCES campfire_group ON UPDATE CASCADE ON DELETE CASCADE
);

-- Table that stores what students are part of which chat group
CREATE TABLE chats (
  chat_id integer NOT NULL,
  email varchar(20) NOT NULL REFERENCES student ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY (chat_id, email)
);

-- Table that stores the individual messages sent by each student to the chat groups
CREATE TABLE chat_line (
  chat_id integer NOT NULL,
  email varchar(20) NOT NULL, -- email of the user that is writing this message
  content varchar(200),
  sent_at timestamp not null default CURRENT_TIMESTAMP,
  FOREIGN KEY (chat_id, email) REFERENCES chats(chat_id, email) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Table to store the pins for each course
CREATE TABLE course_pins (
  code varchar(20) PRIMARY KEY REFERENCES course ON UPDATE CASCADE ON DELETE CASCADE,
  pin varchar(20)
);

-- Table to store the pins for each group
CREATE TABLE group_pins (
  group_id integer PRIMARY KEY REFERENCES campfire_group ON UPDATE CASCADE ON DELETE CASCADE,
  PIN varchar(20)
);


-- Insert a set amount of starting data into the database
INSERT INTO student VALUES ('rod@mail.com', 'Rod', 'Mazloomi', 'pass1', 'I like math', null);
INSERT INTO student VALUES ('adam@mail.com', 'Adam', 'Capparelli', 'pass2', 'I like programming in C++', null);
INSERT INTO student VALUES ('vlad@mail.com', 'Vlad', 'Chapurny', 'pass3', 'I like working in SQL', null);
INSERT INTO student VALUES ('jonathan@mail.com', 'Jonathan', 'Pelastine', 'pass4', 'I like working on group assignments', null);
INSERT INTO student VALUES ('fullchee@mail.com', 'Fullchee', 'Zhang', 'pass5', 'I like programming in Java!', null);
INSERT INTO student VALUES ('quinn@mail.com', 'Quinn', 'Daneyko', 'pass6', 'I like working in android studio', null);
INSERT INTO student VALUES ('andrew@mail.com', 'Andrew', 'Goupil', 'pass7', 'I like linear algebra', null);

INSERT INTO course VALUES ('CSC108H1','Intro to Programming','Diane Horton');
INSERT INTO course VALUES ('CSC148H1','Intro to Computer Science','Danny Heap');
INSERT INTO course VALUES ('CSC207H1','Intro to Java and Object Oriented Design','Paul Gries');
INSERT INTO course VALUES ('CSC309H1','Web Devolopment and Design','Karen Reid');
INSERT INTO course VALUES ('CSC209H1','Software Tools and Systems Programming','Karen Reid');
INSERT INTO course VALUES ('CSC302H1','Engineering Large Software Systems','Renee Miller');
INSERT INTO course VALUES ('CSC304H1','Algorithmic Game Theory and Mechanism Design','Tom Fairgrieve');
INSERT INTO course VALUES ('CSC310H1','Information Theory','David Liu');
INSERT INTO course VALUES ('CSC318H1','The Design of Interactive Computational Media','Ilona Posner');
INSERT INTO course VALUES ('CSC320H1','Introduction to Visual Computing','Allan Jepson');
INSERT INTO course VALUES ('CSC324H1','Principles of Programming Languages','Gary Baumgartner');
INSERT INTO course VALUES ('CSC343H1','Introduction to Databases','Diane Horton');
INSERT INTO course VALUES ('CSC367H1','Parallel Programming','Tom Fairgrieve');
INSERT INTO course VALUES ('CSC369H1','Operating systems','Bogdan Simion');
INSERT INTO course VALUES ('CSC373H1','Algorithm Design, Analysis & Complexity','Allan Jepson');
INSERT INTO course VALUES ('CSC384H1','Introduction to Artificial Intelligence','David Liu');
INSERT INTO course VALUES ('CSC401H1','Natural Language Computing','David Liu');
INSERT INTO course VALUES ('CSC404H1','Introduction to Video Game Design','Peter Marbach');
INSERT INTO course VALUES ('CSC410H1','Software Testing and Verification','Greg Wilson');
INSERT INTO course VALUES ('CSC411H1','Machine Learning and Data Mining','Jacqueline Smith');
INSERT INTO course VALUES ('CSC420H1','Introduction to Image Understanding','Anna Bretscher');
INSERT INTO course VALUES ('CSC428H1','Human-Computer Interaction','Velian Pandeliev');
INSERT INTO course VALUES ('CSC443H1','Database System Technology','Diane Horton');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC108H1');
INSERT INTO taking VALUES ('adam@mail.com', 'CSC108H1');
INSERT INTO taking VALUES ('vlad@mail.com', 'CSC108H1');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC148H1');
INSERT INTO taking VALUES ('vlad@mail.com', 'CSC148H1');
INSERT INTO taking VALUES ('andrew@mail.com', 'CSC148H1');
INSERT INTO taking VALUES ('jonathan@mail.com', 'CSC148H1');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC207H1');
INSERT INTO taking VALUES ('jonathan@mail.com', 'CSC207H1');
INSERT INTO taking VALUES ('fullchee@mail.com', 'CSC207H1');
INSERT INTO taking VALUES ('quinn@mail.com', 'CSC207H1');
INSERT INTO taking VALUES ('adam@mail.com', 'CSC207H1');
INSERT INTO taking VALUES ('vlad@mail.com', 'CSC207H1');
INSERT INTO taking VALUES ('andrew@mail.com', 'CSC207H1');

INSERT INTO taking VALUES ('rod@mail.com', 'CSC309H1');
INSERT INTO taking VALUES ('jonathan@mail.com', 'CSC309H1');
INSERT INTO taking VALUES ('fullchee@mail.com', 'CSC309H1');
INSERT INTO taking VALUES ('quinn@mail.com', 'CSC309H1');

INSERT INTO campfire_group VALUES (1000, 'A1', 4);
INSERT INTO campfire_group VALUES (1001, 'A2', 2);

INSERT INTO group_membership VALUES ('rod@mail.com', 1000), ('adam@mail.com', 1000), ('vlad@mail.com', 1000), ('jonathan@mail.com', 1000);
INSERT INTO group_membership VALUES ('jonathan@mail.com', 1001), ('rod@mail.com', 1001);

INSERT INTO chats VALUES (3000, 'rod@mail.com'), (3000, 'adam@mail.com'), (3000, 'vlad@mail.com'), (3000, 'jonathan@mail.com');
INSERT INTO chats VALUES (3001, 'rod@mail.com'), (3001, 'adam@mail.com'), (3001, 'jonathan@mail.com');

INSERT INTO chat_line VALUES (3000, 'rod@mail.com', 'Hey guys hows it going?');
INSERT INTO chat_line VALUES (3000, 'vlad@mail.com', 'Good, im working on assignment 2');
INSERT INTO chat_line VALUES (3000, 'adam@mail.com', 'Oh im going to start assignment 2 soon as well!');

INSERT INTO chat_line VALUES (3001, 'rod@mail.com', 'Hey guys i dont like vlad, lets kick him of the group');
INSERT INTO chat_line VALUES (3001, 'adam@mail.com', 'Yeah i think so aswell');
INSERT INTO chat_line VALUES (3001, 'jonathan@mail.com', 'are you sure you want to do this?');
INSERT INTO chat_line VALUES (3001, 'rod@mail.com', 'yeah lets do this...');

INSERT INTO course_pins VALUES ('CSC108H1','BTQ4FGRU08ULTRS');
INSERT INTO course_pins VALUES ('CSC148H1','FR4MH7X13F0TY2U');
INSERT INTO course_pins VALUES ('CSC207H1','UQ85H2SNGCAZOQC');
INSERT INTO course_pins VALUES ('CSC309H1','6KB8J2JG8SFLGHC');
INSERT INTO course_pins VALUES ('CSC209H1','YOA3VNIH4QANWAB');
INSERT INTO course_pins VALUES ('CSC302H1','C0R9C07FCJROU6C');
INSERT INTO course_pins VALUES ('CSC304H1','SUQOF88ONE1FQ2X');
INSERT INTO course_pins VALUES ('CSC310H1','AXM0A9PCPEW4U79');
INSERT INTO course_pins VALUES ('CSC318H1','AJZBPHHI5SNYPY6');
INSERT INTO course_pins VALUES ('CSC320H1','NNCGIXRCNZG1U3R');
INSERT INTO course_pins VALUES ('CSC324H1','5TOJT24B9AUG0LA');
INSERT INTO course_pins VALUES ('CSC343H1','5TOJT24B9AUG0LA');
INSERT INTO course_pins VALUES ('CSC367H1','B9X28A3TEFQG2R4');
INSERT INTO course_pins VALUES ('CSC369H1','S1F7SU5ILRJPFVJ');
INSERT INTO course_pins VALUES ('CSC373H1','TTHR3KIVEMNJX0O');
INSERT INTO course_pins VALUES ('CSC384H1','VCA17MCM0X5K9CN');
INSERT INTO course_pins VALUES ('CSC401H1','UW72DS4WJ3QJMQ7');
INSERT INTO course_pins VALUES ('CSC404H1','MMQLBJBCM2QW4CX');
INSERT INTO course_pins VALUES ('CSC410H1','16N2LA08O445ZXY');
INSERT INTO course_pins VALUES ('CSC411H1','JXWCHFQ7QDKDTRC');
INSERT INTO course_pins VALUES ('CSC420H1','1DJQ20U59JI8SH4');
INSERT INTO course_pins VALUES ('CSC428H1','0APLFEGDOAUG9PX');
INSERT INTO course_pins VALUES ('CSC443H1','KUWTAPXSTD6N4TA');

INSERT INTO group_pins VALUES (1000, 'XLPUIZAPQ17CSOA');
INSERT INTO group_pins VALUES (1001, 'S9N860EGMLQLYQ0');

-- Add comparable serialized data to all the students

UPDATE student
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAABHNxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob250AARKYXZhcHBwcHh0ABVQcm9ncmFtbWluZyBMYW5ndWFnZXNzcgAlYmFja2VuZC5hbGdvcml0aG1zLkNTQ0NvdXJzZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAARzcQB+AAAAAAACdwQAAAACdAAIQ1NDMTQ4SDF0AAhDU0MxNjVIMXh0ABRQcmV2aW91cyBDU0MgQ291cnNlc3NyACRiYWNrZW5kLmFsZ29yaXRobXMuRWxlY3RpdmVzQ3JpdGVyaWEbGCv6ixPygQIAAUwAAklEcQB+AAN4cQB+AAQAAAADc3EAfgAAAAAAAXcEAAAAAXQACFNPQzEwMVkxeHQACUVsZWN0aXZlc3NyACJiYWNrZW5kLmFsZ29yaXRobXMuSG9iYmllc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAAA3NxAH4AAAAAAAF3BAAAAAF0AAtWaWRlbyBHYW1lc3h0AAdIb2JiaWVzc3IAI2JhY2tlbmQuYWxnb3JpdGhtcy5TY2hlZHVsZUNyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHIAImJhY2tlbmQuYWxnb3JpdGhtcy5IYXNoTWFwQ3JpdGVyaWEAAAAAAAAAAQIAAkkABHByZWZMAAZ2YWx1ZXN0ABNMamF2YS91dGlsL0hhc2hNYXA7eHAAAAADc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAd0AAdUdWVzZGF5c3EAfgAAAAAAA3cEAAAAA3QADTE0OjAwIC0gMTQ6NTl0AA0xNjowMCAtIDE2OjU5dAANMTc6MDAgLSAxNzo1OXh0AAhUaHVyc2RheXNxAH4AAAAAAAN3BAAAAAN0AA0xNDowMCAtIDE0OjU5dAANMTU6MDAgLSAxNTo1OXQADTE2OjAwIC0gMTY6NTl4dAAGRnJpZGF5c3EAfgAAAAAAA3cEAAAAA3QADTE2OjAwIC0gMTY6NTl0AA0xNzowMCAtIDE3OjU5dAANMTU6MDAgLSAxNTo1OXh0AAZTdW5kYXlzcQB+AAAAAAAAdwQAAAAAeHQACFNhdHVyZGF5c3EAfgAAAAAAAHcEAAAAAHh0AAlXZWRuZXNkYXlzcQB+AAAAAAADdwQAAAADdAANMTY6MDAgLSAxNjo1OXQADTE3OjAwIC0gMTc6NTl0AA0xODowMCAtIDE4OjU5eHQABk1vbmRheXNxAH4AAAAAAAN3BAAAAAN0AA0xMjowMCAtIDEyOjU5dAANMTQ6MDAgLSAxNDo1OXQADTE1OjAwIC0gMTU6NTl4eHQADVRpbWUgU2NoZWR1bGV4'
WHERE email = 'rod@mail.com';

UPDATE student
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAAA3NxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob250AARKYXZhcHBwcHh0ABVQcm9ncmFtbWluZyBMYW5ndWFnZXNzcgAlYmFja2VuZC5hbGdvcml0aG1zLkNTQ0NvdXJzZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAAIQ1NDMTQ4SDF4dAAUUHJldmlvdXMgQ1NDIENvdXJzZXNzcgAkYmFja2VuZC5hbGdvcml0aG1zLkVsZWN0aXZlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAABHNxAH4AAAAAAAF3BAAAAAF0AAhFTlYxMDBIMXh0AAlFbGVjdGl2ZXNzcgAiYmFja2VuZC5hbGdvcml0aG1zLkhvYmJpZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAAGU3BvcnRzeHQAB0hvYmJpZXNzcgAjYmFja2VuZC5hbGdvcml0aG1zLlNjaGVkdWxlQ3JpdGVyaWEbGCv6ixPygQIAAUwAAklEcQB+AAN4cgAiYmFja2VuZC5hbGdvcml0aG1zLkhhc2hNYXBDcml0ZXJpYQAAAAAAAAABAgACSQAEcHJlZkwABnZhbHVlc3QAE0xqYXZhL3V0aWwvSGFzaE1hcDt4cAAAAANzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAGdwgAAAAIAAAAB3QACFNhdHVyZGF5c3EAfgAAAAAAAHcEAAAAAHh0AAZTdW5kYXlzcQB+AAAAAAAAdwQAAAAAeHQACFRodXJzZGF5c3EAfgAAAAAAA3cEAAAAA3QADTA5OjAwIC0gMDk6NTl0AA0wODowMCAtIDA4OjU5dAANMDc6MDAgLSAwNzo1OXh0AAdUdWVzZGF5c3EAfgAAAAAAA3cEAAAAA3QADTA4OjAwIC0gMDg6NTl0AA0wNzowMCAtIDA3OjU5dAANMDY6MDAgLSAwNjo1OXh0AAlXZWRuZXNkYXlzcQB+AAAAAAAAdwQAAAAAeHQABkZyaWRheXNxAH4AAAAAAAB3BAAAAAB4dAAGTW9uZGF5c3EAfgAAAAAABXcEAAAABXQADTE2OjAwIC0gMTY6NTl0AA0xODowMCAtIDE4OjU5dAANMjA6MDAgLSAyMDo1OXQADTE3OjAwIC0gMTc6NTl0AA0xOTowMCAtIDE5OjU5eHh0AA1UaW1lIFNjaGVkdWxleA=='
WHERE email = 'adam@mail.com';

UPDATE student 
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAABXNxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob250AARKYXZhdAABQ3BwcHh0ABVQcm9ncmFtbWluZyBMYW5ndWFnZXNzcgAlYmFja2VuZC5hbGdvcml0aG1zLkNTQ0NvdXJzZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAAIQ1NDMTQ4SDF4dAAUUHJldmlvdXMgQ1NDIENvdXJzZXNzcgAkYmFja2VuZC5hbGdvcml0aG1zLkVsZWN0aXZlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAAA3NxAH4AAAAAAAF3BAAAAAF0AAhFTlYxMDBIMXh0AAlFbGVjdGl2ZXNzcgAiYmFja2VuZC5hbGdvcml0aG1zLkhvYmJpZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAARzcQB+AAAAAAABdwQAAAABdAALVmlkZW8gR2FtZXN4dAAHSG9iYmllc3NyACNiYWNrZW5kLmFsZ29yaXRobXMuU2NoZWR1bGVDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hyACJiYWNrZW5kLmFsZ29yaXRobXMuSGFzaE1hcENyaXRlcmlhAAAAAAAAAAECAAJJAARwcmVmTAAGdmFsdWVzdAATTGphdmEvdXRpbC9IYXNoTWFwO3hwAAAAA3NyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAZ3CAAAAAgAAAAHdAAIU2F0dXJkYXlzcQB+AAAAAAAAdwQAAAAAeHQABlN1bmRheXNxAH4AAAAAAAB3BAAAAAB4dAAIVGh1cnNkYXlzcQB+AAAAAAAEdwQAAAAEdAANMTU6MDAgLSAxNTo1OXQADTE3OjAwIC0gMTc6NTl0AA0xODowMCAtIDE4OjU5dAANMTY6MDAgLSAxNjo1OXh0AAdUdWVzZGF5c3EAfgAAAAAABHcEAAAABHQADTA5OjAwIC0gMDk6NTl0AA0wODowMCAtIDA4OjU5dAANMTA6MDAgLSAxMDo1OXQADTExOjAwIC0gMTE6NTl4dAAJV2VkbmVzZGF5c3EAfgAAAAAAA3cEAAAAA3QADTEzOjAwIC0gMTM6NTl0AA0xNDowMCAtIDE0OjU5dAANMTU6MDAgLSAxNTo1OXh0AAZGcmlkYXlzcQB+AAAAAAACdwQAAAACdAANMTU6MDAgLSAxNTo1OXQADTE2OjAwIC0gMTY6NTl4dAAGTW9uZGF5c3EAfgAAAAAAA3cEAAAAA3QADTEyOjAwIC0gMTI6NTl0AA0xMzowMCAtIDEzOjU5dAANMTQ6MDAgLSAxNDo1OXh4dAANVGltZSBTY2hlZHVsZXg='
WHERE email = 'vlad@mail.com';

UPDATE student
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAABXNxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob250AARKYXZhcHBwcHh0ABVQcm9ncmFtbWluZyBMYW5ndWFnZXNzcgAlYmFja2VuZC5hbGdvcml0aG1zLkNTQ0NvdXJzZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAAIQ1NDMTQ4SDF4dAAUUHJldmlvdXMgQ1NDIENvdXJzZXNzcgAkYmFja2VuZC5hbGdvcml0aG1zLkVsZWN0aXZlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAAA3NxAH4AAAAAAAF3BAAAAAF0AAhFTlYxMDBIMXh0AAlFbGVjdGl2ZXNzcgAiYmFja2VuZC5hbGdvcml0aG1zLkhvYmJpZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAALVmlkZW8gR2FtZXN4dAAHSG9iYmllc3NyACNiYWNrZW5kLmFsZ29yaXRobXMuU2NoZWR1bGVDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hyACJiYWNrZW5kLmFsZ29yaXRobXMuSGFzaE1hcENyaXRlcmlhAAAAAAAAAAECAAJJAARwcmVmTAAGdmFsdWVzdAATTGphdmEvdXRpbC9IYXNoTWFwO3hwAAAABHNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAZ3CAAAAAgAAAAHdAAIU2F0dXJkYXlzcQB+AAAAAAAAdwQAAAAAeHQABlN1bmRheXNxAH4AAAAAAAB3BAAAAAB4dAAIVGh1cnNkYXlzcQB+AAAAAAADdwQAAAADdAANMTg6MDAgLSAxODo1OXQADTE3OjAwIC0gMTc6NTl0AA0xNjowMCAtIDE2OjU5eHQAB1R1ZXNkYXlzcQB+AAAAAAAEdwQAAAAEdAANMTA6MDAgLSAxMDo1OXQADTEyOjAwIC0gMTI6NTl0AA0xMzowMCAtIDEzOjU5dAANMTE6MDAgLSAxMTo1OXh0AAlXZWRuZXNkYXlzcQB+AAAAAAADdwQAAAADdAANMTM6MDAgLSAxMzo1OXQADTE0OjAwIC0gMTQ6NTl0AA0xNTowMCAtIDE1OjU5eHQABkZyaWRheXNxAH4AAAAAAAN3BAAAAAN0AA0xMDowMCAtIDEwOjU5dAANMTE6MDAgLSAxMTo1OXQADTEyOjAwIC0gMTI6NTl4dAAGTW9uZGF5c3EAfgAAAAAABHcEAAAABHQADTEwOjAwIC0gMTA6NTl0AA0xMTowMCAtIDExOjU5dAANMTI6MDAgLSAxMjo1OXQADTEzOjAwIC0gMTM6NTl4eHQADVRpbWUgU2NoZWR1bGV4'
WHERE email = 'jonathan@mail.com';

UPDATE student
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAABHNxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob250AARKYXZhcHBwcHh0ABVQcm9ncmFtbWluZyBMYW5ndWFnZXNzcgAlYmFja2VuZC5hbGdvcml0aG1zLkNTQ0NvdXJzZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAAIQ1NDMTQ4SDF4dAAUUHJldmlvdXMgQ1NDIENvdXJzZXNzcgAkYmFja2VuZC5hbGdvcml0aG1zLkVsZWN0aXZlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAAA3NxAH4AAAAAAAF3BAAAAAF0AAhFTlYyMDBIMXh0AAlFbGVjdGl2ZXNzcgAiYmFja2VuZC5hbGdvcml0aG1zLkhvYmJpZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAARzcQB+AAAAAAABdwQAAAABdAAGU3BvcnRzeHQAB0hvYmJpZXNzcgAjYmFja2VuZC5hbGdvcml0aG1zLlNjaGVkdWxlQ3JpdGVyaWEbGCv6ixPygQIAAUwAAklEcQB+AAN4cgAiYmFja2VuZC5hbGdvcml0aG1zLkhhc2hNYXBDcml0ZXJpYQAAAAAAAAABAgACSQAEcHJlZkwABnZhbHVlc3QAE0xqYXZhL3V0aWwvSGFzaE1hcDt4cAAAAAVzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAGdwgAAAAIAAAAB3QACFNhdHVyZGF5c3EAfgAAAAAAAHcEAAAAAHh0AAZTdW5kYXlzcQB+AAAAAAAAdwQAAAAAeHQACFRodXJzZGF5c3EAfgAAAAAAAHcEAAAAAHh0AAdUdWVzZGF5c3EAfgAAAAAAA3cEAAAAA3QADTA4OjAwIC0gMDg6NTl0AA0wOTowMCAtIDA5OjU5dAANMTA6MDAgLSAxMDo1OXh0AAlXZWRuZXNkYXlzcQB+AAAAAAADdwQAAAADdAANMDc6MDAgLSAwNzo1OXQADTA4OjAwIC0gMDg6NTl0AA0xMDowMCAtIDEwOjU5eHQABkZyaWRheXNxAH4AAAAAAAB3BAAAAAB4dAAGTW9uZGF5c3EAfgAAAAAAA3cEAAAAA3QADTE2OjAwIC0gMTY6NTl0AA0xNzowMCAtIDE3OjU5dAANMTg6MDAgLSAxODo1OXh4dAANVGltZSBTY2hlZHVsZXg='
WHERE email = 'fullchee@mail.com';

UPDATE student
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAABXNxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob250AARKYXZhdAABQ3BwcHh0ABVQcm9ncmFtbWluZyBMYW5ndWFnZXNzcgAlYmFja2VuZC5hbGdvcml0aG1zLkNTQ0NvdXJzZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAANzcQB+AAAAAAABdwQAAAABdAAIQ1NDMTA4SDF4dAAUUHJldmlvdXMgQ1NDIENvdXJzZXNzcgAkYmFja2VuZC5hbGdvcml0aG1zLkVsZWN0aXZlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAABHNxAH4AAAAAAAF3BAAAAAF0AAhFTlYyMDBIMXh0AAlFbGVjdGl2ZXNzcgAiYmFja2VuZC5hbGdvcml0aG1zLkhvYmJpZXNDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hxAH4ABAAAAARzcQB+AAAAAAABdwQAAAABdAALVmlkZW8gR2FtZXN4dAAHSG9iYmllc3NyACNiYWNrZW5kLmFsZ29yaXRobXMuU2NoZWR1bGVDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hyACJiYWNrZW5kLmFsZ29yaXRobXMuSGFzaE1hcENyaXRlcmlhAAAAAAAAAAECAAJJAARwcmVmTAAGdmFsdWVzdAATTGphdmEvdXRpbC9IYXNoTWFwO3hwAAAAA3NyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAZ3CAAAAAgAAAAHdAAIU2F0dXJkYXlzcQB+AAAAAAAAdwQAAAAAeHQABlN1bmRheXNxAH4AAAAAAAB3BAAAAAB4dAAIVGh1cnNkYXlzcQB+AAAAAAADdwQAAAADdAANMTA6MDAgLSAxMDo1OXQADTExOjAwIC0gMTE6NTl0AA0xMjowMCAtIDEyOjU5eHQAB1R1ZXNkYXlzcQB+AAAAAAADdwQAAAADdAANMDk6MDAgLSAwOTo1OXQADTEwOjAwIC0gMTA6NTl0AA0xMTowMCAtIDExOjU5eHQACVdlZG5lc2RheXNxAH4AAAAAAAN3BAAAAAN0AA0xMjowMCAtIDEyOjU5dAANMTE6MDAgLSAxMTo1OXQADTEwOjAwIC0gMTA6NTl4dAAGRnJpZGF5c3EAfgAAAAAAA3cEAAAAA3QADTEwOjAwIC0gMTA6NTl0AA0wOTowMCAtIDA5OjU5dAANMTE6MDAgLSAxMTo1OXh0AAZNb25kYXlzcQB+AAAAAAAEdwQAAAAEdAANMTA6MDAgLSAxMDo1OXQADTEzOjAwIC0gMTM6NTl0AA0xMTowMCAtIDExOjU5dAANMTI6MDAgLSAxMjo1OXh4dAANVGltZSBTY2hlZHVsZXg='
WHERE email = 'quinn@mail.com';

UPDATE student
SET comparable = 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFc3IAL2JhY2tlbmQuYWxnb3JpdGhtcy5Qcm9ncmFtbWluZ0xhbmd1YWdlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACBiYWNrZW5kLmFsZ29yaXRobXMuQXJyYXlDcml0ZXJpYRsYK/qLE/KBAgACSQAEcHJlZkwABnZhbHVlc3QAFUxqYXZhL3V0aWwvQXJyYXlMaXN0O3hwAAAABXNxAH4AAAAAAAZ3BAAAAAZ0AAZQeXRob25wdAABQ3QABEhUTUxwdAADU1FMeHQAFVByb2dyYW1taW5nIExhbmd1YWdlc3NyACViYWNrZW5kLmFsZ29yaXRobXMuQ1NDQ291cnNlc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAAA3NxAH4AAAAAAAF3BAAAAAF0AAhDU0MxNDhIMXh0ABRQcmV2aW91cyBDU0MgQ291cnNlc3NyACRiYWNrZW5kLmFsZ29yaXRobXMuRWxlY3RpdmVzQ3JpdGVyaWEbGCv6ixPygQIAAUwAAklEcQB+AAN4cQB+AAQAAAADc3EAfgAAAAAAAXcEAAAAAXQACEVOVjEwMEgxeHQACUVsZWN0aXZlc3NyACJiYWNrZW5kLmFsZ29yaXRobXMuSG9iYmllc0NyaXRlcmlhGxgr+osT8oECAAFMAAJJRHEAfgADeHEAfgAEAAAABHNxAH4AAAAAAAF3BAAAAAF0AAZTcG9ydHN4dAAHSG9iYmllc3NyACNiYWNrZW5kLmFsZ29yaXRobXMuU2NoZWR1bGVDcml0ZXJpYRsYK/qLE/KBAgABTAACSURxAH4AA3hyACJiYWNrZW5kLmFsZ29yaXRobXMuSGFzaE1hcENyaXRlcmlhAAAAAAAAAAECAAJJAARwcmVmTAAGdmFsdWVzdAATTGphdmEvdXRpbC9IYXNoTWFwO3hwAAAAA3NyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAx3CAAAABAAAAAHdAAIVGh1cnNkYXlzcQB+AAAAAAADdwQAAAADdAANMDg6MDAgLSAwODo1OXQADTA5OjAwIC0gMDk6NTl0AA0xMDowMCAtIDEwOjU5eHQAB1R1ZXNkYXlzcQB+AAAAAAADdwQAAAADdAANMDk6MDAgLSAwOTo1OXQADTExOjAwIC0gMTE6NTl0AA0xMjowMCAtIDEyOjU5eHQABkZyaWRheXNxAH4AAAAAAAN3BAAAAAN0AA0wNzowMCAtIDA3OjU5dAANMDU6MDAgLSAwNTo1OXQADTA2OjAwIC0gMDY6NTl4dAAIU2F0dXJkYXlzcQB+AAAAAAAAdwQAAAAAeHQABlN1bmRheXNxAH4AAAAAAAB3BAAAAAB4dAAJV2VkbmVzZGF5c3EAfgAAAAAAA3cEAAAAA3QADTEzOjAwIC0gMTM6NTl0AA0xMTowMCAtIDExOjU5dAANMTI6MDAgLSAxMjo1OXh0AAZNb25kYXlzcQB+AAAAAAAEdwQAAAAEdAANMTE6MDAgLSAxMTo1OXQADTEwOjAwIC0gMTA6NTl0AA0xMjowMCAtIDEyOjU5dAANMTQ6MDAgLSAxNDo1OXh4dAANVGltZSBTY2hlZHVsZXg='
WHERE email = 'andrew@mail.com';