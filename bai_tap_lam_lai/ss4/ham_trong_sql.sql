USE QuanLySinhVien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select *
from Subject s
where s.Credit = (
select max(Credit)
from Subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select SubName, Mark 
from Mark m
join Subject s on m.SubId = s.SubId
where m.Mark = (
select max(Mark)
from Mark );

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select * , avg(Mark) as diem_trung_binh
from Student s
left join Mark m on s.StudentId = m.StudentId
group by s.StudentId   

