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

insert into customer(cID,cName,cAge)
values
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into oder(oID,cID,oDate,oTotalPrice)
values
(1,1,'3/21/2006',null),
(2,2,'3/23/2006',null),
(3,1,'3/16/2006',null);

insert into produc(pID,pName,pPrice)
values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),


