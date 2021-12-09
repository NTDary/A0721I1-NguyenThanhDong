use quanlybanhang;

insert into Customer(cName,cAge)
values
('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);

insert into Product(pName,pPrice)
values
('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);

insert into `Order`(cID,oDate)
values
(1,'2006-03-21'),
(2,'2006-03-23'),
(1,'2006-03-16');

insert into OrderDetail(oID,pID,odQTY)
values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
