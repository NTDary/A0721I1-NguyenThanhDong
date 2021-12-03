create database demo_a07;
use demo_a07;

create table tai_khoan(
username varchar(30) primary key,
`password` varchar(65) not null
);

create table lop(
ma_lop_hoc int primary key auto_increment,
ten_lop_hoc varchar(65)
);

create table giang_vien(
ma_giang_vien int primary key auto_increment,
ten_giang_vien varchar(65),
ngay_sinh date
);

create table hoc_vien(
ma_hoc_vien int primary key auto_increment,
ten_hoc_vien varchar(65),
ngay_sinh date,
email varchar(100),

-- unique: khong trung lap
username varchar(30) unique,
ma_lop_hoc int,
foreign key(username) references tai_khoan(username),
foreign key(ma_lop_hoc) references lop(ma_lop_hoc)
);

create table giang_vien_day_lop_hoc(
ma_giang_vien int,
ma_lop_hoc int,
primary key(ma_giang_vien,ma_lop_hoc),
foreign key(ma_giang_vien) references giang_vien(ma_giang_vien),
foreign key(ma_lop_hoc) references lop(ma_lop_hoc)
);

create table dia_chi(
ma_dia_chi int primary key auto_increment,
ma_hoc_vien int,
dia_chi varchar(65),
foreign key(ma_hoc_vien) references hoc_vien(ma_hoc_vien)
);

-- Them data lop
insert into lop(
ten_lop_hoc
)
values
("A1"),
("A2"),
("B1");
select * from lop;

-- Them data giang vien
insert into giang_vien(
ten_giang_vien,
ngay_sinh
)
values
("Truong Van Truong","1994-11-22"),
("Dinh Van Nhanh","1994-01-12"),
("Nguyen Thi Thu","1995-05-05"),
("Nguyen Thanh Binh","1989-06-22"),
("Hoai Thu Phuong","1995-11-21"),
("Ngo Ba Tri","1991-10-27"),
("Vo Van Em","1991-07-14");
select * from giang_vien;

-- Them data tai khoan

insert into tai_khoan(
username,
password
)
values
("vananh2212","123456"),
("thibe1201","123456"),
("tanphat1201","123456"),
("kieudiem2206","123456"),
("daoduy2111","123456"),
("thidung2710","123456"),
("vanty1407","123456");
select * from tai_khoan;

-- Them data hoc vien
select * from hoc_vien;
ALTER TABLE hoc_vien AUTO_INCREMENT = 1;
insert into hoc_vien(
ten_hoc_vien,
ngay_sinh,
email,
username,
ma_lop_hoc
)
values
("Nguyen Van Anh","2002-12-22","nguyenvananh2212@gmail.com",(SELECT username FROM tai_khoan WHERE username ='vananh2212'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =2)),
("Nguyen Thi Be","2002-01-12","nguyenthibe1201@gmail.com",(SELECT username FROM tai_khoan WHERE username ='thibe1201'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =2)),
("Huynh Tan Phat","2002-05-05","huynhtanphat0505@gmail.com",(SELECT username FROM tai_khoan WHERE username ='tanphat0505'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =1)),
("Ngo Kieu Diem","2000-06-22","ngokieukiem2206@gmail.com",(SELECT username FROM tai_khoan WHERE username ='kieudiem2206'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =1)),
("Nguyen Dao Duy","2001-11-21","nguyendaoduy2111@gmail.com",(SELECT username FROM tai_khoan WHERE username ='daoduy2111'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =3)),
("Pham Thi Dung","2002-10-27","phamthidung2710@gmail.com",(SELECT username FROM tai_khoan WHERE username ='thidung2710'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =3)),
("Nguyen Van Ty","2000-07-14","nguyenvanty1407@gmail.com",(SELECT username FROM tai_khoan WHERE username ='vanty1407'),(SELECT ma_lop_hoc FROM lop WHERE ma_lop_hoc =1));

-- Them Data Dia Chi
insert into dia_chi(
ma_hoc_vien,
dia_chi
)
values
("1","11 Nui Thanh, Da Nang"),
("2","21 Phan Dang Luu, Da Nang"),
("3","120 Nguyen Van Linh, Da Nang"),
("4","53 Dao Duy Tu, Da Nang"),
("5","111 To Huu, Da Nang"),
("6","215 Tieu La, Da Nang"),
("7","32 Trung Nu Vuong, Da Nang");
select * from dia_chi;

-- Them Data giang  vien day lop hoc
insert into giang_vien_day_lop_hoc(
ma_giang_vien,
ma_lop_hoc
)
values
("1",1),
("2",1),
("3",1),
("4",2),
("5",2),
("6",3),
("7",3);
select * from giang_vien_day_lop_hoc;

-- Delete 1 dong
set SQL_SAFE_UPDATES = 0;
delete from hoc_vien
where ten_hoc_vien = "Dung";
set SQL_SAFE_UPDATES = 1;

-- Delete toan bo value trong table
set SQL_SAFE_UPDATES = 0;
delete from hoc_vien;
set SQL_SAFE_UPDATES = 1;


-- Update hoc_vien
set SQL_SAFE_UPDATES = 0;
update tai_khoan set username = "tanphat0505"
where username ="tanphat1201";
update hoc_vien set username = "tanphat0505"
where ma_hoc_vien = 3;
set SQL_SAFE_UPDATES = 1;

-- Update dia chi
UPDATE dia_chi
   SET ma_hoc_vien =(SELECT ma_hoc_vien FROM hoc_vien WHERE dia_chi.ma_hoc_vien=hoc_vien.ma_hoc_vien);
select * from dia_chi;
