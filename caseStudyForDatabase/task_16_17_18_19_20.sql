use case_study;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;


update nhan_vien set is_delete = 1 where ma_nhan_vien in (
select temp.ma_nhan_vien
from (
select ma_nhan_vien
from nhan_vien 
where ma_nhan_vien not in(
select ma_nhan_vien
from hop_dong
where year(ngay_lam_hop_dong) between '2019' and '2021') )as temp);
 
 select * from nhan_vien
where is_delete = 1;
 
 -- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
 -- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 
 -- là lớn hơn 10.000.000 VNĐ.

 
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;

update khach_hang set is_delete = 1 where ma_khach_hang in(
select temp.ma_khach_hang
from(select ma_khach_hang
from khach_hang
where ma_khach_hang not in (
select ma_khach_hang
from hop_dong
where (year(ngay_lam_hop_dong) < '2021')
)) as temp);

select *
from khach_hang
where is_delete = 1;

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem set gia=gia*2 where ma_dich_vu_di_kem in(
select *
from (
select dvdk.ma_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong hd on dvdk.ma_hop_dong = hd.ma_hop_dong
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma-dich_vu_di_kem
where year(hd.ngay_lam_hop_dong) = 2020
group by ma_dich_vu_di_kem
having sum(hdct.so_luong) >= 10) as temp) ;

select *
from dich_vu_di_Kem;



 -- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
 -- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
 
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien 
union all
select ma_khach_hang , ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;
 
 
 
 