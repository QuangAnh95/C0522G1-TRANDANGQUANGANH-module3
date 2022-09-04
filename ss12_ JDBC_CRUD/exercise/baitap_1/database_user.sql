drop database if exists quan_ly_user;
create database quan_ly_user;
use quan_ly_user;
create table users(
id int(3) auto_increment primary key,
`name` varchar(120) ,
email varchar(220),
country varchar(120));
insert into users(`name`,email,country)
values ("Huỳnh Văn Nam","namhuynh191193@gmail.com","Việt Nam"),
	   ("Quang Anh ","anh95@gmail.com","Việt Nam"),
       ("Đức Phúc","Phuc93@gmail.com","Việt Nam"),
	   ("Trương Tấn","ronadol@gmail.com","Việt Nam");
       
       DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;
