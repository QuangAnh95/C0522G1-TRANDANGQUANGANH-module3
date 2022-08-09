drop database if exists suat_nhap;
create database suat_nhap;
use suat_nhap;
create table phieu_xuat(
so_phieu_xuat int primary key,
ngay_xuat date not null
);

create table vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(50) not null
);

create table phieu_nhap(
so_phieu_nhap int primary key,
ngay_nhap date not null
);

create table nha_cung_cap(
ma_nha_cung_cap int primary key,
ten_nha_cung_cap varchar(50) not null,
dia_chi varchar(50) not null,
so_dien_thoai varchar(10) not null) ;

create table sdt_ncc(
sdt varchar(10) primary key,
ma_nha_cung_cap int,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table don_dat_hang(
so_dat_hang int primary key,
ngay_dat_hang date not null,
ma_nha_cung_cap int,
foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table chi_tiet_phieu_xuat(
don_gia_xuat int not null, 
so_luong_xuat int not null,
so_phieu_suat int,
ma_vat_tu int,
primary key(so_phieu_suat,ma_vat_tu),
foreign key(so_phieu_suat) references phieu_xuat(so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_phieu_nhap(
don_gia_nhap int not null,
so_luong_nhap int not null,
so_phieu_nhap int,
ma_vat_tu int,
primary key (so_phieu_nhap,ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table cung_cap(
ma_vat_tu int,
so_don_hang int,
primary key(ma_vat_tu,so_don_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_don_hang) references don_dat_hang(so_dat_hang)
);

