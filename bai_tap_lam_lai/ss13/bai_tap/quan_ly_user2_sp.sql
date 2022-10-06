drop database if exists quan_ly_user2_sp;
create database quan_ly_user2_sp;
use  quan_ly_user2_sp;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select * from users ;

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
DELIMITER $$

CREATE PROCEDURE userlist()

BEGIN

  select*
  from users;

    END$$

DELIMITER ;
call userlist()
-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
DELIMITER $$

CREATE PROCEDURE edit_list(id_sp int, name_sp varchar(45), email_sp varchar(50), country_sp varchar(50))

BEGIN
update users
set name = name_sp, email = email_sp, country = country_sp
where id = id_sp ;

    END$$

DELIMITER ;
call edit_list();

select * 
from users;


-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user

DELIMITER $$

CREATE PROCEDURE delete_list(id_sp int)

BEGIN
delete
from users
where id = id_sp;


    END$$

DELIMITER ;
call delete_list();
