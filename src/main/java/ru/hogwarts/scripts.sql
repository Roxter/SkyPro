DELETE FROM student;
DELETE FROM faculty;

INSERT INTO faculty (name, color) VALUES
('Gryffindor', 'Red'),
('Slytherin', 'Green'),
('Hufflepuff', 'Yellow'),
('Ravenclaw', 'Blue');

INSERT INTO student (name, age, faculty_id) VALUES
('Harry Potter', 12, 1),
('Hermione Granger', 12, 1),
('Ron Weasley', 12, 1),
('Neville Longbottom', 12, 1),
('Ginny Weasley', 11, 1),

('Draco Malfoy', 12, 2),
('Gregory Goyle', 13, 2),
('Vincent Crabbe', 13, 2),

('Cedric Diggory', 16, 3),
('Hannah Abbott', 12, 3),
('Justin Finch-Fletchley', 12, 3),

('Cho Chang', 14, 4),
('Luna Lovegood', 11, 4),
('Padma Patil', 12, 4),

('Cassandra Vablatsky', 15, NULL);


SELECT * FROM student WHERE age BETWEEN 10 AND 20;

SELECT name FROM student;

SELECT * FROM student WHERE name ILIKE '%o%';

SELECT * FROM student WHERE age < id;

SELECT * FROM student ORDER BY age;