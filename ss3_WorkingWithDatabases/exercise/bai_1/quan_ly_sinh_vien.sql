drop database if exists quan_ly_sinh_vien;
create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

CREATE TABLE class
(
    class_ID   INT         AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    `status`    BIT
);
CREATE TABLE student
(
    student_ID   INT         AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone       VARCHAR(20),
    `status`      BIT,
    class_ID    INT         NOT NULL,
    FOREIGN KEY (class_ID) REFERENCES class (class_ID)
);
CREATE TABLE `subject`
(
    sub_ID   INT        AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    `status`  BIT                  DEFAULT 1
);

CREATE TABLE mark
(
    mark_ID   INT AUTO_INCREMENT PRIMARY KEY,
    sub_ID     INT NOT NULL,
    student_ID INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( mark BETWEEN 0 AND 100),
    exam_times TINYINT default 1,
    UNIQUE (sub_ID, student_ID),
    FOREIGN KEY (sub_ID) REFERENCES Subject (sub_ID),
    FOREIGN KEY (student_ID) REFERENCES student (student_ID)
);

INSERT INTO class
VALUES 
(1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);

INSERT INTO student(student_name, address, phone, `status`, class_ID)
VALUES 
('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai phong',null, 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO mark ( sub_ID,student_ID,mark,exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1); 
-- hiển thị tên sinh viên bắt đầu bằng chữ H
select student_name
from student s
where s.student_name regexp '^H';
-- hiển thị lớp học bắt đầu từ tháng 12
select start_date
from class c
where month(c.start_date) = 12;
-- hiển thị credit trong khoảng từ 3-5
select  credit
from `subject` s
where s.credit in(3,4,5);
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET SQL_SAFE_UPDATES = 0;
update student
set   class_ID =2
where student_name = 'Hung'; 
select * from student;

select student.student_name, `subject`.sub_name, mark.mark
from student 
join mark on student.student_ID = mark.student_ID
join `subject` on mark.sub_ID = `subject`.sub_ID
group by mark.mark_ID
order by mark desc, student_name;





