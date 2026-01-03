DELETE FROM student;
DELETE FROM faculty;

INSERT INTO faculty (id, name, color) VALUES
(nextval('faculty_seq'), 'Gryffindor', 'Red'),
(nextval('faculty_seq'), 'Slytherin', 'Green'),
(nextval('faculty_seq'), 'Hufflepuff', 'Yellow'),
(nextval('faculty_seq'), 'Ravenclaw', 'Blue');

INSERT INTO student (id, name, age, faculty_id) VALUES
(nextval('student_seq'), 'Harry Potter', 12, 1),
(nextval('student_seq'), 'Hermione Granger', 12, 1),
(nextval('student_seq'), 'Ron Weasley', 12, 1),
(nextval('student_seq'), 'Neville Longbottom', 12, 1),
(nextval('student_seq'), 'Ginny Weasley', 11, 1),
(nextval('student_seq'), 'Draco Malfoy', 12, 2),
(nextval('student_seq'), 'Gregory Goyle', 13, 2),
(nextval('student_seq'), 'Vincent Crabbe', 13, 2),
(nextval('student_seq'), 'Cedric Diggory', 16, 3),
(nextval('student_seq'), 'Hannah Abbott', 12, 3),
(nextval('student_seq'), 'Justin Finch-Fletchley', 12, 3),
(nextval('student_seq'), 'Cho Chang', 14, 4),
(nextval('student_seq'), 'Luna Lovegood', 11, 4),
(nextval('student_seq'), 'Padma Patil', 12, 4),
(nextval('student_seq'), 'Cassandra Vablatsky', 15, NULL);

SELECT setval('faculty_seq', (SELECT MAX(id) FROM faculty));
SELECT setval('student_seq', (SELECT MAX(id) FROM student));

TRUNCATE TABLE student, faculty RESTART IDENTITY CASCADE;

SELECT * FROM student WHERE age BETWEEN 10 AND 20;

SELECT name FROM student;

SELECT * FROM student WHERE name ILIKE '%o%';

SELECT * FROM student WHERE age < id;

SELECT * FROM student ORDER BY age;