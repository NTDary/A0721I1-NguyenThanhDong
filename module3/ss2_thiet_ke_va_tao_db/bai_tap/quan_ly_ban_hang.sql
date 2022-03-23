create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
cID int primary key auto_increment,
cName varchar(60),
cAge int
);

create table `Order`(
oID int primary key auto_increment,
cID int,
oDate date,
oTotalPrice int,
foreign key(cID) references Customer(cID)
);

create table Product(
pID int primary key auto_increment,
pName varchar(60),
pPrice int
);

create table OrderDetail(
oID int,
pID int,
primary key(oID,pID),
odQTY int default 1 check(odQTY >= 1),
foreign key(oID) references `Order`(oID),
foreign key(pID) references Product(pID)
);

-- drop database quanlybanhang;
