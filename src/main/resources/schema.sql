create table parent (
    Id int PRIMARY KEY,
    Name VARCHAR(50)
    );

create table child (
    Id INT PRIMARY KEY,
    Name VARCHAR(50),
    FATHER_ID INT,
    MOTHER_ID INT,
    FOREIGN KEY (FATHER_ID) REFERENCES parent(Id),
    FOREIGN KEY (MOTHER_ID) REFERENCES parent(Id)
    );

insert into parent (Id, Name) values
(1, 'John'),
(2, 'Paul'),
(3, 'Mary'),
(4, 'Lucy'),
(5, 'Mark');

insert into child (Id, Name, FATHER_ID, MOTHER_ID) values
(1, 'John', 1, 3),
(2, 'Paul', 1, 3),
(3, 'Lucy', 2, 4),
(4, 'Claire', 1, 4),
(5, 'Simon', NULL, 4);
