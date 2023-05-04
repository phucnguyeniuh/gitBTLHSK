CREATE DATABASE QuanLyBanXeMay;
GO

USE QuanLyBanXeMay;
GO

CREATE TABLE KhachHang (
  MaKhachHang VARCHAR(10) PRIMARY KEY,
  TenKhachHang NVARCHAR(50),
  DiaChi NVARCHAR(50),
  SoDienThoai NVARCHAR(20),
  Email NVARCHAR(50)
);

CREATE TABLE NhanVien (
  MaNhanVien VARCHAR(10) PRIMARY KEY,
  TenNhanVien NVARCHAR(50),
  DiaChi NVARCHAR(50),
  SoDienThoai NVARCHAR(20),
  ChucVu nvarchar(20),
  PhongBan nvarchar (20),
  TrinhDo nvarchar (20),
  NamKN int,
  Email NVARCHAR(50),
  MatKhau VARCHAR(50)
);

CREATE TABLE XeMay (
  MaXe VARCHAR(10) PRIMARY KEY not null,
  TenXe NVARCHAR(50),
  LoaiXe NVARCHAR(10),
  SoMay nvarchar (20),
  SoKhung nvarchar (20),
  MauXe nvarchar (20),
  SoLuong int,
  DonGia money,
  NuocSX nvarchar (20),
  MaNCC nvarchar (10)
);

CREATE TABLE HoaDon (
  MaHoaDon VARCHAR(10) PRIMARY KEY,
  MaKhachHang VARCHAR(10),
  MaNhanVien VARCHAR(10),
  NgayBan DATE,
  TongTien FLOAT,
  FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

CREATE TABLE ChiTietHoaDon (
  MaDonDatHang VARCHAR(10) PRIMARY KEY,
  MaKhachHang VARCHAR(10),
  MaNhanVien VARCHAR(10),
  NgayDat DATE,
  TrangThai NVARCHAR(50),
  FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);
CREATE TABLE TaiKhoan (
    id char (10) PRIMARY KEY,
    tenTaiKhoan VARCHAR(50) ,
    matKhau VARCHAR(50) 
);

Create Table NhaCungCap(
	MaNCC nvarchar (10) not null,
	TenNCC nvarchar (40),
	DiaChiNCC nvarchar (50),
	SDT nvarchar (10),
	Email nvarchar (50),
)

--Thêm thông tin cho các bảng
--Bang KhachHang
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, DiaChi, SoDienThoai, Email)
VALUES ('KH001', N'Nguyễn Văn A', N'123 Đường A', '0987654321', 'nguyenvana@gmail.com');

INSERT INTO KhachHang (MaKhachHang, TenKhachHang, DiaChi, SoDienThoai, Email)
VALUES ('KH002', N'Trần Thị B', N'456 Đường B', '0123456789', 'tranthib@gmail.com');
insert into KhachHang values ('KH003', N'Nguyễn Văn Cường', N'20 Nguyễn Thái Sơn, Gò Vấp', '0123456252', 'cuongnguyen@gmail.com')
insert into KhachHang values ('KH004', N'Lê Văn Ca', N'44 Phạm Ngũ Lão, Gò Vấp', '0531356252', 'cale111@gmail.com')
insert into KhachHang values ('KH005', N'Nguyễn Thị Nguyệt', N'20 Nguyễn Thái Sơn, q12', '0123732252', 'thinguyet@gmail.com')
insert into KhachHang values ('KH006', N'Nguyễn Thị Na', N'Lê Duẫn, q2', '0633732252', 'nanguyen@gmail.com')
insert into KhachHang values ('KH007', N'Tran Van Tung', N'20 Nguyễn Thái Sơn, q3', '0633732252', 'TungVan@gmail.com')
insert into KhachHang values ('KH008', N'Nguyễn Thị Nở', N'12 Thạnh Xuân 21, q12', '0736352252', 'thiNo001@gmail.com')
insert into KhachHang values ('KH009', N'Lê Bửu Da', N'151 Nguyễn Oanh, Gò Vấp', '0616762252', 'dadada@gmail.com')
insert into KhachHang values ('KH010', N'Trần Văn Hùng', N'234 Nguyễn Thái Sơn, Gò Vấp', '0663732252', 'Hung991@gmail.com')
insert into KhachHang values ('KH012', N'Nguyễn Thị Nam Thu', N'20 Phan Văn Trị, q2', '0843732252', 'NamThu532@gmail.com')
insert into KhachHang values ('KH013', N'Quách Thị Phương', N'20 Linh Trung, Thủ Đức', '0123222252', 'Phuong32@gmail.com')
insert into KhachHang values ('KH014', N'Võ Yến Nhi', N'20 Nguyễn Huệ, q2', '0843732252', 'NHINHI212@gmail.com')
insert into KhachHang values ('KH015', N'Nguyễn Hùng', N'Châu Đốc, An Giang', '0521732252', 'HungNguyen002532@gmail.com')
insert into KhachHang values ('KH016', N'Nguyễn Tấn Tài', N'Long Xuyên, An Giang', '0123732252', 'TaiNgueyn532@gmail.com')




--Bảng NhanVien
INSERT INTO NhanVien (MaNhanVien, TenNhanVien, DiaChi, SoDienThoai, Email, MatKhau)
VALUES ('NV001', N'Nguyễn Thị C', N'789 Đường C', '0123456789', 'nguyenthic@gmail.com', '123456');

INSERT INTO NhanVien (MaNhanVien, TenNhanVien, DiaChi, SoDienThoai, Email, MatKhau)
VALUES ('NV002', N'Trần Văn D', N'012 Đường D', '0987654321', 'tranvand@gmail.com', 'abcdef');
-- Bảng XeMay
INSERT INTO XeMay (MaXeMay, TenXeMay, HangSanXuat, NamSanXuat, Gia)
VALUES ('XM001', N'Honda Dream', N'Honda', 2020, 25000000);

INSERT INTO XeMay (MaXeMay, TenXeMay, HangSanXuat, NamSanXuat, Gia)
VALUES ('XM002', N'Yamaha Sirius', N'Yamaha', 2021, 27000000);
--Bảng HoaDon
INSERT INTO HoaDon (MaHoaDon, MaKhachHang, MaNhanVien, NgayBan, TongTien)
VALUES ('HD001', 'KH001', 'NV001', '2023-04-30', 50000000);

INSERT INTO HoaDon (MaHoaDon, MaKhachHang, MaNhanVien, NgayBan, TongTien)
VALUES ('HD002', 'KH002', 'NV002', '2023-05-01', 54000000);

-- Bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaDonDatHang, MaKhachHang, MaNhanVien, NgayDat, TrangThai)
VALUES ('DH001', 'KH001', 'NV001', '2023-04-20', N'Đang chờ xử lý');

INSERT INTO ChiTietHoaDon (MaDonDatHang, MaKhachHang, MaNhanVien, NgayDat, TrangThai)
VALUES ('DH002', 'KH002', 'NV002', '2023-05-02', N'Đang vận chuyển');

--Bang Xe
insert into XeMay values ('50cc001', 'Elegant', '50cc', 'MSE1AH******', '05MHHH******', 'Xanh', 5, 15000000, 'Dai Loan', 'NCC001')
insert into XeMay values ('50cc002', 'Angela', '50cc', 'MSE1AH******', '05MHHH******', 'Hong', 2, 16000000, 'Dai Loan', 'NCC001')
insert into XeMay values ('50cc003', 'Elegant', '50cc', 'MSE1AH******', '05MHHH******', 'Do', 3, 15000000, 'Dai Loan', 'NCC001')
insert into XeMay values ('50cc004', 'Angela', '50cc', 'MSE1AH******', '05MHHH******', 'Xanh', 5, 14000000, 'Dai Loan', 'NCC001')
insert into XeMay values ('150cc001', 'Exciter', '150cc', 'WFE1AH******', '12MHHH******', 'Xanh trang', 10, 45000000, 'NhatBan', 'NCC002')
insert into XeMay values ('150cc002', 'Exciter', '150cc', 'WFE1AH******', '12MHHH******', 'Do', 7, 48000000, 'Nhat Ban', 'NCC002')
insert into XeMay values ('50cc005', 'Cub', '50cc', 'WFE1AH******', '12MHHH******', 'Trang', 2, 12000000, 'Nhat Ban', 'NCC003')
insert into XeMay values ('150cc003', 'Winner', '150cc', 'MSE1AH******', '34MHHH******', 'Xanh', 5, 30000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('150cc004', 'Winner', '150cc', 'MSE1AH******', '34MHHH******', 'Den', 14, 38000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('150cc005', 'AirBlade', '150cc', 'MSE1AH******', '34MHHH******', 'Do', 5, 60000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('150cc006', 'AirBlade', '150cc', 'MSE1AH******', '34MHHH******', 'Do Trang Den', 10, 58000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('150cc007', 'SH', '150cc', 'MSE1AH******', '34MHHH******', 'Do', 10, 90000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('150cc008', 'SH', '150cc', 'MSE1AH******', '34MHHH******', 'Den', 10, 920000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('125cc001', 'AirBlade', '125cc', 'MSE1AH******', '34MHHH******', 'Do', 2, 45000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('125cc002', 'AirBlade', '125cc', 'MSE1AH******', '34MHHH******', 'Trang', 5, 42000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('125cc003', 'SHmode', '125cc', 'MSE1AH******', '34MHHH******', 'Do', 5, 70000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('125cc004', 'SHmode', '125cc', 'MSE1AH******', '34MHHH******', 'Trang', 5, 72000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('125cc005', 'SHmode', '125cc', 'MSE1AH******', '34MHHH******', 'Xam', 5, 70000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('110cc001', 'Wave', '110cc', 'MSE1AH******', '34MHHH******', 'Den', 5, 15000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('110cc002', 'Wave', '110cc', 'MSE1AH******', '34MHHH******', 'Do', 10, 15000000, 'Nhat Ban', 'NCC004')
insert into XeMay values ('110cc002', 'Wave', '110cc', 'MSE1AH******', '34MHHH******', 'Den nham', 2, 17000000, 'Nhat Ban', 'NCC004')

insert into NhaCungCap values ('NCC001', 'Công ty Cổ phần SYM Đà Nẵng', '253 Điện Biên Phủ, Quận Thanh Khê, Đà Nẵng', '0236365226', 'SYMDaNang@gmail.com')
insert into NhaCungCap values ('NCC002', 'Công ty TNHH MTV Honda Bình Việt', '545- 547 Kinh Dương Vương,An Lạc,Bình Tân, HCM', '0862657555', 'HonDaTanBinh@gmail.com')
insert into NhaCungCap values ('NCC003', 'Công ty TNHH MTV Honda Bình Việt', '3-4 Trần Hưng Đạo, TP. Thủ Dầu Một,Bình Dương', '0862958475', 'YamahaBinhDuong@gmail.com')
insert into NhaCungCap values ('NCC004', 'Công ty TNHH MTV Khuất Văn Lương  ', '57 Hà Huy Tập, quận Thanh Khê, TP. Đà Nẵng', '0657437455', 'HonDaDaNang@gmail.com')

--Bang nhan vien
insert into NhanVien values ('NV001', 'Nguyễn Nguyễn','213, Thường Thới Tiền, Đồng Tháp','0241515242','123456', )





