-- câu 1: tạo database
-- tên bảng, thuộc tính, database tất cả đều phải theo quy tắc snake_case
create database demo_a0721i1;
-- sử dụng database demo... để thực hiện truy vấn
use demo_a0721i1;
-- Tạo table sinh viên có thuộc tính: mã sinh viên, tên sv, ngay sinh
create table sinh_vien(
ma_sinh_vien int,
ten_sinh_vien varchar(70),
ngay_sinh date,
primary key(ma_sinh_vien)
);
-- Thêm dữ liệu
insert into sinh_vien values(1, "Nguyen Thanh Dong","1996-02-23");
-- Truy vấn
select * from sinh_vien;
insert into sinh_vien(ma_sinh_vien,ten_sinh_vien) values(2,"abc");

-- Yêu cầu 5: Thay đổi cấu trúc của bảng
-- first nếu muốn thêm cột ở trước hoặc after để thêm vào sau 1 cột
alter table sinh_vien add mo_ta text after ngay_sinh;

-- Yêu cầu 6: cập nhập thông tin của 1 anh tên Nguyen Thanh Dong -> Ngày sinh

-- update và delete khi sử dụng sẽ xãy ra lỗi về bảo mật, yêu cầu sử dụng lệnh set sql_safe_update
set SQL_SAFE_UPDATES = 0;

update sinh_vien set ngay_sinh = "1996-01-01" 
where ten_sinh_vien = "Nguyen Thanh Dong";
set SQL_SAFE_UPDATES = 1;
