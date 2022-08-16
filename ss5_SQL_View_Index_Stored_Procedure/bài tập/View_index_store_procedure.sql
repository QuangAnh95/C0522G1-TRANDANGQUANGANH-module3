drop database if exists products;
create database products;
use products;

create table products(
id int primary key auto_increment,
product_code int not null,
product_name varchar(30) not null,
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(50));

insert into products(product_code, product_name, product_price, product_amount, product_description, product_status  )
values
( 100, 'chocopie', 15000, 10, 'bánh sôcôla', 'còn hàng'  ),
( 200, 'vinamilk', 20000, 12, 'sữa tươi', 'còn hàng'  ),
( 300, 'chuppa chuck', 10000, 0, 'kẹo mút hương trái cây', 'hết hàng'),
( 400, 'one one', 12000, 9, 'bánh gạo', 'còn hàng'  ),
( 500, 'hảo hảo', 30000, 0, 'mì gói', 'hết_hàng'  ),
( 600, 'ohshi', 7000, 10, 'phồng tôm', 'còn hàng'  );

select *
from products;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index i_product_code on products (product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index i_product_name_price on products (product_name, product_code);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select *
from products
where product_code= 005;

-- So sánh câu truy vấn trước và sau khi tạo index
explain select *
from products
where product_code = 30000;

select *
from products
where product_code = 30000;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view w_view_product as 
select product_code, product_name, product_price, product_status
from products;

-- Tiến hành sửa đổi view
select * 
from w_view_product ;
update w_view_product set  product_status = 'hết hàng' where product_code= 004;

-- Tiến hành xoá view
drop view w_view_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure sp_get_product()
begin 
select * from products;
end //
delimiter ;
call sp_get_product();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure sp_set_product(in id int, product_code int, product_name varchar(30), product_price double, product_amount int, product_description varchar(50),product_status varchar(50) )
begin
insert into 
products( id , product_code, product_name, product_price, product_amount, product_description,product_status)
values
(id , product_code, product_name, product_price, product_amount, product_description,product_status);
end //
delimiter ;

call  sp_set_product (7, 700, 'cococola', 40000, 20, 'nước ngot', 'còn hàng');

select *
from products

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure sp_update_product (in p_id int, in p_product_name varchar(30), in p_product_description varchar(50))
begin
update products set
product_name = p_product_name,
product_description = p_product_description 
where id = p_id;
end //
delimiter ; 
call sp_update_product (1, 'goute', 'bánh mè');

select *
from products;

-- Tạo store procedure xoá sản phẩm theo id

delimiter //
create procedure sp_delete_product (in p_id int)
begin
delete from products
where id = p_id;
end //
delimiter ;
call sp_delete_product(4);

select *
from products