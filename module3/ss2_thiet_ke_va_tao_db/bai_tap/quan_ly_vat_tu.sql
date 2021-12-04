create database quanlyvattu;
use quanlyvattu;

create table NHACC(
MaNCC int primary key auto_increment,
TenNCC varchar(60),
DiaChi varchar(069),
SDT int
);

create table DONDH(
SoDH int primary key auto_increment,
NgayDH date
);

create table VATTU(
MaVTU int primary key auto_increment,
TenVTU varchar(60)
);

create table PHIEUXUAT(
SoPX int primary key auto_increment,
NgayXuat date
);

create table PHIEUNHAP(
SoPN int primary key auto_increment,
NgayNhap date
);

create table CHITIETPHIEUXUAT(
SoPX int,
MaVTU int,
GDXUat int,
SLXuat int,
foreign key(SoPX) references PHIEUXUAT(SoPX),
foreign key(MaVTU) references VATTU(MaVTU)
);

create table CHITIETPHIEUNHAP(
SoPN int,
MaVTU int,
DGNhap int,
SLNhap int,
foreign key(SoPN) references PHIEUNHAP(SoPN),
foreign key(MaVTU) references VATTU(MaVTU)
);

create table CHITIETDONDATHANG(
SoDH int,
MaVTU int,
NgayDH int,
foreign key(MaVTU) references VATTU(MaVTU)
);

create table CUNGCAP(
SoDH int,
MaNCC int,
foreign key(SoDH) references DONDH(SoDH),
foreign key(MaNCC) references NHACC(MaNCC)
);
