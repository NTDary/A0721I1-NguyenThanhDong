use furama;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien where substring_index(ho_ten,' ',-1)
regexp "^[HKT]" and char_length(15);

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where ((dia_chi like '%Đà Nẵng') or (dia_chi like '%Quảng Trị')) and (ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0) between 18 and 50);
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select ho_ten, count(*) as so_lan_dat_phong
from khach_hang as kh inner join hop_dong as hd
on kh.ma_khach_hang = hd.ma_khach_hang
where kh.ma_loai_khach = 1
group by kh.ma_khach_hang
order by so_lan_dat_phong asc;
use furama;
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng.
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, sum(dv.chi_phi_thue + COALESCE((dvdk.gia * hdct.so_luong), 0)) as tong_tien
from khach_hang as kh 
left join loai_khach as lk on kh.ma_loai_khach = lk.ma_loai_khach 
left join hop_dong as hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu as dv on hd.ma_dich_vu = dv.ma_dich_vu 
left join hop_dong_chi_tiet as hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
left join dich_vu_di_kem as dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
from dich_vu as dv inner join loai_dich_vu as ldv
on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where not exists (select ma_hop_dong from hop_dong where (ngay_lam_hop_dong between '2021-01-01' and '2021-03-31') and (hop_dong.ma_dich_vu = dv.ma_dich_vu))
group by ma_dich_vu;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue
-- , ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu as dv inner join loai_dich_vu as ldv
on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where exists(select ma_hop_dong from hop_dong where ((year(ngay_lam_hop_dong) = '2020')) and hop_dong.ma_dich_vu = dv.ma_dich_vu)
and not exists(select ma_hop_dong from hop_dong where ((year(ngay_lam_hop_dong) = '2021')) and hop_dong.ma_dich_vu = dv.ma_dich_vu);

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- cách 1
select ho_ten from khach_hang
group by ho_ten;
-- cách 2
select distinct ho_ten from khach_hang;
-- cách 3
select distinct ho_ten from khach_hang union select distinct ho_ten from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) so_luong_dich_vu_di_kem
from hop_dong as hd left join hop_dong_chi_tiet as hdct
on hd.ma_hop_dong = hdct.ma_hop_dong
group by hd.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi,dvdk.trang_thai from dich_vu_di_kem as dvdk
inner join hop_dong_chi_tiet as hdct
on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
inner join hop_dong as hd
on hdct.ma_hop_dong = hd.ma_hop_dong
inner join khach_hang as kh
on kh.ma_khach_hang = hd.ma_khach_hang
inner join loai_khach as lkhach
on kh.ma_loai_khach = lkhach.ma_loai_khach
where (lkhach.ten_loai_khach = 'Diamond') and ((dia_chi like '%Vinh') or (dia_chi like '%Quảng Ngãi'));

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem)
-- , tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select hd.ma_hop_dong, nv.ho_ten as ho_ten_nhan_vien, kh.ho_ten as ho_ten_khach_hang,kh.so_dien_thoai as sdt_khach_hang,dv.ma_dich_vu,dv.ten_dich_vu,sum(hdct.so_luong) as so_luong_dich_vu_di_kem, hd.tien_dat_coc
from hop_dong as hd
inner join nhan_vien as nv on hd.ma_nhan_vien = nv.ma_nhan_vien
inner join khach_hang as kh on hd.ma_khach_hang = kh.ma_khach_hang
inner join dich_vu as dv on hd.ma_dich_vu = dv.ma_dich_vu
inner join hop_dong_chi_tiet as hdct on hdct.ma_hop_dong = hd.ma_hop_dong
where not exists (select ma_hop_dong from hop_dong where ngay_lam_hop_dong between '2020-01-01' and '2020-06-31')
and exists (select ma_hop_dong from hop_dong where ngay_lam_hop_dong between '2020-09-01' and '2020-12-31')
group by hd.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

create temporary table temp
select hdct.ma_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from hop_dong_chi_tiet as hdct inner join dich_vu_di_kem as dvdk
on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem;

create temporary table temp1
select max(temp.so_luong_dich_vu_di_kem) as so_luong_dich_vu_di_kem from temp;

select temp.ma_dich_vu_di_kem, temp.ten_dich_vu_di_kem, temp.so_luong_dich_vu_di_kem
from temp inner join temp1 on temp.so_luong_dich_vu_di_kem = temp1.so_luong_dich_vu_di_kem;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong as hd inner join dich_vu as dv
on hd.ma_dich_vu = dv.ma_dich_vu inner join loai_dich_vu as ldv
on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu inner join hop_dong_chi_tiet as hdct
on hd.ma_hop_dong = hdct.ma_hop_dong inner join dich_vu_di_kem as dvdk
on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by (dvdk.ten_dich_vu_di_kem) having so_lan_su_dung = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan
-- ,so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi, count(hd.ma_nhan_vien) as so_lan
from nhan_vien as nv inner join bo_phan as bp
on nv.ma_bo_phan = bp.ma_bo_phan inner join trinh_do as td
on nv.ma_trinh_do = td.ma_trinh_do inner join hop_dong as hd
on nv.ma_nhan_vien = hd.ma_nhan_vien
where hd.ngay_lam_hop_dong between '2020-01-01' and '2021-12-31'
group by nv.ma_nhan_vien having (so_lan < 3);

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien as nv
where not exists (select ma_nhan_vien from hop_dong as hd where hd.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31' and hd.ma_nhan_vien = nv.ma_nhan_vien );
SET SQL_SAFE_UPDATES = 1;
select * from nhan_vien;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond
-- , chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

-- TAO BANG temp_tong_tien
create temporary table temp_tong_tien
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, sum(dv.chi_phi_thue + COALESCE((dvdk.gia * hdct.so_luong), 0)) as tong_tien
from khach_hang as kh 
left join loai_khach as lk on kh.ma_loai_khach = lk.ma_loai_khach 
left join hop_dong as hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu as dv on hd.ma_dich_vu = dv.ma_dich_vu 
left join hop_dong_chi_tiet as hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
left join dich_vu_di_kem as dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong;
select * from temp_tong_tien;

UPDATE khach_hang, (select t.ma_khach_hang as id, sum(tong_tien) as tong_tien1 from temp_tong_tien as t
	where year(t.ngay_lam_hop_dong) = 2021
    group by t.ma_khach_hang having tong_tien1 > 10000000
) as temp17
   SET khach_hang.ma_loai_khach = (select lk.ma_loai_khach from loai_khach as lk where lk.ten_loai_khach = 'Diamond')
   where khach_hang.ma_loai_khach = (select lk.ma_loai_khach from loai_khach as lk where lk.ten_loai_khach = 'Platinum')
   and temp17.id = khach_hang.ma_khach_hang;
   
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
delete khach_hang,hop_dong,hop_dong_chi_tiet from khach_hang
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where not exists (select hop_dong.ma_hop_dong where year(hop_dong.ngay_lam_hop_dong) > 2021 and hop_dong.ma_khach_hang = khach_hang.ma_khach_hang);
select * from khach_hang;
sssss