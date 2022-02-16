create database TCOMPLEX;
use TCOMPLEX;

create table quan_ly_mat_bang(
ma_mat_bang varchar(45) primary key,
dien_tich int,
trang_thai varchar(255),
so_tang int,
loai_van_phong varchar(255),
mo_ta varchar(255),
gia_thue double,
ngay_bat_dau datetime,
ngay_ket_thuc datetime
);
