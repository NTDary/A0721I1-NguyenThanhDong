create database quan_ly_don_hang;
use quan_ly_don_hang;

create table hang(
ma_hang int primary key auto_increment,
ten_hang varchar(100),
don_vi_tinh varchar(50),
mo_ta varchar(100)
);

create table dv_khach(
ma_dv int primary key auto_increment,
ten_dv varchar(100),
dia_chi varchar(100),
dien_thoai int(12)
);

create table nguoi_giao(
ma_ng int primary key auto_increment,
ho_ten_ng varchar(100)
);

create table noi_giao(
ma_so_ddg int primary key auto_increment,
ten_noi_giao varchar(100)
);

create table nguoi_dat(
ma_so_nd int primary key auto_increment,
ho_ten_nd varchar(100)
);

create table nguoi_nhan(
ma_so_nn int primary key auto_increment,
ho_ten_nn varchar(100)
);

create table dat(
so_dh int primary key auto_increment,
ngay_dat date,
so_luong int,
ma_hang int,
ma_so_nd int,
foreign key(ma_so_nd) references nguoi_dat(ma_so_nd),
foreign key(ma_hang) references hang(ma_hang)
);

create table giao(
so_pg int primary key auto_increment,
ma_hang int,
ma_so_nn int,
ma_so_ddg int,
ngay_giao date,
so_luong int,
don_gia int,
ma_ng int,

foreign key(ma_hang) references hang(ma_hang),
foreign key(ma_so_nn) references nguoi_nhan(ma_so_nn),
foreign key(ma_so_ddg) references noi_giao(ma_so_ddg),
foreign key(ma_ng) references nguoi_giao(ma_ng)
);

create table don_vi_khach_thuoc_nguoi_dat(
ma_so_nd int,
ma_dv int,
foreign key(ma_so_nd) references nguoi_dat(ma_so_nd),
foreign key(ma_dv) references dv_khach(ma_dv)
);

create table don_vi_khach_thuoc_nguoi_nhan(
ma_so_nn int,
ma_dv int,
foreign key(ma_so_nn) references nguoi_nhan(ma_so_nn),
foreign key(ma_dv) references dv_khach(ma_dv)
);