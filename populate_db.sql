INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
('Solomiya', '2001-01-01', 'Junior', '1100'),
('Olexandr', '2002-02-02', 'Trainee', '350'),
('Emiliya', '1999-03-03', 'Junior', '1100'),
('Olena', '1992-08-08', 'Senior', '7000'),
('Anna', '1995-04-04', 'Middle', '3000'),
('Ivan', '1998-05-05', 'Middle', '3000'),
('Oleh', '2000-06-06', 'Junior', '1100'),
('Artur', '2003-07-07', 'Trainee', '400'),
('Eugen', '1997-09-09', 'Senior', '9000'),
('Viktoriya', '1996-10-10', 'Middle', '3000');

INSERT INTO client (NAME)
VALUES
('Michael Jordan'),
('John Johnson'),
('Sarah Jigsaw'),
('Andrew Ivanovich'),
('Roger Moore');

INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
(1, '2023-01-08', '2023-08-24'),
(2, '2016-05-01', '2022-06-13'),
(1, '2020-03-26', '2022-07-26'),
(2, '2019-04-13', '2021-09-20'),
(3, '2017-08-30', '2020-01-09'),
(4, '2020-12-10', '2022-02-24'),
(5, '2018-01-01', '2023-10-10'),
(1, '2013-11-11', '2017-12-12'),
(1, '2022-07-01', '2023-05-05'),
(5, '2023-08-01', '2023-09-02');

INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES
(1, 9),
(1, 7),
(2, 6),
(2, 9),
(2, 3),
(3, 10),
(3, 7),
(3, 1),
(4, 9),
(4, 7),
(4, 5),
(4, 6),
(5, 9),
(5, 1),
(5, 2),
(5, 4),
(5, 6),
(6, 9),
(7, 4),
(7, 1),
(7, 2),
(7, 3),
(7, 5),
(8, 9),
(8, 1),
(8, 2),
(8, 3),
(9, 5),
(10, 1),
(10, 8),
(10, 4),
(10, 5);