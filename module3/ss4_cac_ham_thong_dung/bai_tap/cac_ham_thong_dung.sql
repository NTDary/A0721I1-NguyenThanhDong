-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select SubId, SubName, max(Credit), Status from `subject`;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select sb.* , max(mark.Mark) as MaxMark from `subject` as sb inner join mark
on sb.SubId = mark.SubId;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select sv.*, avg(mark.Mark) as avg_mark from student as sv inner join mark 
on sv.StudentId = mark.StudentId
group by sv.StudentId, sv.StudentName order by avg_mark desc;
