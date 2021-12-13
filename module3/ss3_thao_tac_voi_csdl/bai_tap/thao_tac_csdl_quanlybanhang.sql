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

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
use quanlybanhang;
select od.oID, oDate, sum(odQTY * pPrice) as oPrice
from `Order` as od inner join OrderDetail as dt
on od.oID = dt.oID inner join Product as pd
on dt.pID = pd.pID
group by dt.oID;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select cName,cAge,pName,odQTY
from Customer as c inner join `Order` as o
on c.cID = o.cID inner join OrderDetail as od
on o.oID = od.oID inner join Product as pd
on od.pID = pd.pID
group by pd.pName;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select cName
from Customer
where not exists (select * from `Order` where Customer.cID = `Order`.cID);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select od.oID, oDate, sum(odQTY * pPrice) oTotalPrice
from `Order` as od inner join OrderDetail as dt
on od.oID = dt.oID inner join Product as pd
on dt.pID = pd.pID
group by dt.oID;

-- select chay sau inner join