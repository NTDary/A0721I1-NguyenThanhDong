-- Insert loai_dich_vu -- 
INSERT INTO service_type(service_type_name)
VALUES ('Villa'),
       ('House'),
       ('Room');

-- Insert kieu_thue --        
INSERT INTO rent_type(rent_type_name)
VALUES ('year'),
       ('month'),
       ('day'),
       ('hour');
       
 -- Insert dich_vu -- 
INSERT INTO service (service_name,service_area,service_cost,service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors,rent_type_id,service_type_id)
VALUES ('Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
       ('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2),
       ('Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3),
       ('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
       ('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2),
       ('Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);
       
-- Insert vi_tri
INSERT INTO position (position_name)
VALUES ('Quản lý'),
       ('Nhân Viên');
       

-- Insert trinh_do
INSERT INTO education_degree (education_degree_name)
VALUES ('Trung Cấp'),
       ('Cao Đẳng'),
       ('Đại Học'),
       ('Sau Đại Học');
       
-- Insert bo_phan -- 
INSERT INTO division (division_name)
VALUES ('Sale-Marketing'),
       ('Hành chính'),
       ('Phục vụ'),
       ('Quản lý');

-- Insert nhan_vien --    
INSERT INTO employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)
VALUES ('Nguyễn Văn An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
       ('Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
       ('Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
       ('Võ Công Toản','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
       ('Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
       ('Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
       ('Nguyễn Hữu Hà','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
       ('Nguyễn Hà Đông','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
       ('Tòng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
       ('Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
       
-- Insert loai_khach -- 
INSERT INTO customer_type (customer_type_name)
VALUES ('Diamond'),
       ('Platinium'),
       ('Gold'),
       ('Silver'),
       ('Member');

-- Insert khach_hang -- 
INSERT INTO customer (customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id)
VALUES ('Nguyễn Thị Hào','1970-11-07',0,643431213,0945423362,'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
('Phạm Xuân Diệu','1992-08-08',1,865342123,0954333333,'xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
('Trương Đình Nghệ','1990-02-27',1,488645199,0373213122,'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
('Dương Văn Quan','1981-07-08',1,543432111,0490039241,'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
('Hoàng Trần Nhi Nhi','1995-12-09',0,795453345,0312345678,'nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Laig',4),
('Tôn Nữ Mộc Châu','2005-12-06',0,732434215,0988888844,'tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
('Nguyễn Mỹ Kim','1984-04-08',0,856453123,0912345698,'kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
('Nguyễn Thị Hào','1999-04-08',0,965656433,0763212345,'haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
('Trần Đại Danh','1994-07-01',1,432341235,0643343433,'danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
('Nguyễn Tâm Đắc','1989-07-01',1,344343432,0987654321,'dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

 -- Insert dich_vu_di_kem -- 
INSERT INTO attach_service (attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
VALUES ('Karaoke',10000,'giờ','tiện nghi, hiện tại'),
       ('Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
       ('Thuê xe đạp',20000,'chiếc','tốt'),
       ('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');
       
-- Insert hop_dong-- 
INSERT INTO contract (contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
VALUES ('2020-12-08','2020-12-08',0,0,3,1,3),
       ('2020-07-14','2020-07-21',200000,0,7,3,1),
       ('2021-03-15','2021-03-17',50000,0,3,4,2),
       ('2021-01-14','2021-01-18',100000,0,7,5,5),
       ('2021-07-14','2021-07-15',0,0,7,2,6),
       ('2021-06-01','2021-06-03',0,0,7,7,6),
       ('2021-09-02','2021-09-05',100000,0,7,4,4),
       ('2021-06-17','2021-06-18',150000,0,3,4,1),
       ('2020-11-19','2020-11-19',0,0,3,4,3),
       ('2021-04-12','2021-04-14',0,0,10,3,5),
       ('2021-04-25','2021-04-25',0,0,2,2,1),
       ('2021-05-25','2021-05-27',0,0,7,10,1);
       
-- Insert hop_dong_chi_tiet -- 
INSERT INTO contract_detail (contract_id,attach_service_id,quantity)
VALUES (2,4,5),
       (2,5,8),
       (2,6,15),
       (3,1,1),
       (3,2,11),
       (1,3,1),
       (1,2,2),
       (12,2,2);
       
-- Insert role -- 
INSERT INTO `role` (role_name)
VALUES ('admin'),
       ('member');

-- Insert role -- 
INSERT INTO `user` (username,password)
VALUES ('admin','123'),
       ('member','123');
	
ALTER TABLE user AUTO_INCREMENT = 1;
set SQL_SAFE_UPDATES = 0;
