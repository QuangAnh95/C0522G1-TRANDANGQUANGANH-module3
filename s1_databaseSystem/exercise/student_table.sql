drop database if exists student_manageman;
create database student_manageman;

use  student_manageman;

create table student(
id int primary key not null,
`name` varchar(45) not null,
age int,
country varchar(45)
);

create table class(
id int primary key not null,
`name` varchar(45) not null
);

create table teacher(
id int primary key not null,
`name` varchar(45) not null,
age int,
country varchar(45)
);


