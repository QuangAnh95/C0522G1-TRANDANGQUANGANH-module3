drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
cID int primary key,
cName varchar(50),
cAge int);

create table oder(
oID int primary key,
oDate date,
oTotalPrice double,
cID int,
foreign key(cID) references customer(cID));

create table produc(
pID int primary key,
pName varchar(50),
pPrice double);

create table oder_detail(
odQTY int,
oID int,
pID int,
primary key(oID,pID),
foreign key(oID) references oder(oID),
foreign key(pID) references produc(pID));