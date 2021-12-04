-- Bước 1: Sử dụng câu lệnh Use QuanLySinhVien để sử dụng cơ sở dữ liệu:
USE QuanLySinhVien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select StudentName
from Student
where StudentName like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * 
from Class
where StartDate like '%-12-%';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * 
from Subject
where Credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set SQL_SAFE_UPDATES = 0;
update Student 
set ClassId = 2
where StudentName = 'Hung';
set SQL_SAFE_UPDATES = 0;
select * from Student;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select StudentName, SubName, Mark
from Student as std inner join Mark as m
on std.StudentID = m.StudentID inner join `Subject` as sj
on m.SubID = sj.SubID
order by Mark desc, StudentName asc;
