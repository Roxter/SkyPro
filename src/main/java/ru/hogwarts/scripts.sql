DELETE FROM student;
DELETE FROM faculty;

INSERT INTO faculty (id, name, color) VALUES
(nextval('faculty_seq'), 'Gryffindor', 'Red'),
(nextval('faculty_seq'), 'Slytherin', 'Green'),
(nextval('faculty_seq'), 'Hufflepuff', 'Yellow'),
(nextval('faculty_seq'), 'Ravenclaw', 'Blue');

INSERT INTO student (id, name, age, faculty_id) VALUES
(nextval('student_seq'), 'Harry Potter', 22, 1),
(nextval('student_seq'), 'Hermione Granger', 22, 1),
(nextval('student_seq'), 'Ron Weasley', 22, 1),
(nextval('student_seq'), 'Neville Longbottom', 22, 1),
(nextval('student_seq'), 'Ginny Weasley', 21, 1),
(nextval('student_seq'), 'Draco Malfoy', 22, 2),
(nextval('student_seq'), 'Gregory Goyle', 23, 2),
(nextval('student_seq'), 'Vincent Crabbe', 23, 2),
(nextval('student_seq'), 'Cedric Diggory', 26, 3),
(nextval('student_seq'), 'Hannah Abbott', 22, 3),
(nextval('student_seq'), 'Justin Finch-Fletchley', 22, 3),
(nextval('student_seq'), 'Cho Chang', 24, 4),
(nextval('student_seq'), 'Luna Lovegood', 21, 4),
(nextval('student_seq'), 'Padma Patil', 22, 4),
(nextval('student_seq'), 'Cassandra Vablatsky', 20, 2),
(nextval('student_seq'), 'Alexander Pushkin', 22, 3),
(nextval('student_seq'), 'Andrey Sidorov', 25, 1),
(nextval('student_seq'), 'Anna Shtern', 21, 4);

SELECT setval('faculty_seq', (SELECT MAX(id) FROM faculty));
SELECT setval('student_seq', (SELECT MAX(id) FROM student));

TRUNCATE TABLE student, faculty RESTART IDENTITY CASCADE;

ALTER SEQUENCE student_seq RESTART WITH 1;
ALTER SEQUENCE faculty_seq RESTART WITH 1;

SELECT pg_get_serial_sequence('student', 'id');

SELECT * FROM student WHERE age BETWEEN 10 AND 20;

SELECT name FROM student;

SELECT * FROM student WHERE name ILIKE '%o%';

SELECT * FROM student WHERE age < id;

SELECT * FROM student ORDER BY age;