USE [master]
GO
/****** Object:  Database [QLOTO]    Script Date: 5/12/2021 11:41:58 AM ******/
CREATE DATABASE [QLOTO]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLOTO', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QLOTO.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLOTO_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QLOTO_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLOTO] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLOTO].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLOTO] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLOTO] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLOTO] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLOTO] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLOTO] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLOTO] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLOTO] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QLOTO] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLOTO] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLOTO] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLOTO] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLOTO] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLOTO] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLOTO] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLOTO] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLOTO] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLOTO] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLOTO] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLOTO] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLOTO] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLOTO] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLOTO] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLOTO] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLOTO] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLOTO] SET  MULTI_USER 
GO
ALTER DATABASE [QLOTO] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLOTO] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLOTO] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLOTO] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QLOTO]
GO
/****** Object:  Table [dbo].[CTHoadon]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHoadon](
	[MaSP] [int] NOT NULL,
	[MaHD] [int] NOT NULL,
	[TenSP] [nvarchar](50) NOT NULL,
	[SL] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CTNhaphang]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTNhaphang](
	[MaNH] [int] NOT NULL,
	[MaSP] [int] NOT NULL,
	[SL] [int] NOT NULL,
	[Gia] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Hoadon]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hoadon](
	[MaHD] [int] NOT NULL,
	[MaKH] [int] NOT NULL,
	[MaNV] [int] NOT NULL,
	[NgayHD] [nvarchar](20) NOT NULL,
	[Tongtien] [float] NOT NULL,
 CONSTRAINT [PK_Hoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Loai]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loai](
	[MaLoai] [int] IDENTITY(1,1) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_Loai] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NCC]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NCC](
	[MaNCC] [int] NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[Diachi] [nvarchar](50) NOT NULL,
	[SDT] [nvarchar](11) NOT NULL,
	[SoFax] [nvarchar](11) NOT NULL,
 CONSTRAINT [PK_NCC] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Nhaphang]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nhaphang](
	[MaNH] [int] NOT NULL,
	[MaNV] [int] NOT NULL,
	[MaNCC] [int] NOT NULL,
	[Ngaynhap] [nvarchar](20) NOT NULL,
	[Tongtien] [float] NULL,
 CONSTRAINT [PK_Nhaphang] PRIMARY KEY CLUSTERED 
(
	[MaNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NSX]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[MaNSX] [int] NOT NULL,
	[TenNSX] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NSX] PRIMARY KEY CLUSTERED 
(
	[MaNSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[QLKhachhang]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QLKhachhang](
	[MAKH] [int] NOT NULL,
	[HOKH] [nvarchar](50) NOT NULL,
	[TENKH] [nvarchar](50) NOT NULL,
	[DIACHI] [nvarchar](50) NOT NULL,
	[SDT] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_QLKhachhang] PRIMARY KEY CLUSTERED 
(
	[MAKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[QLNhanvien]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QLNhanvien](
	[MANV] [int] NOT NULL,
	[HONV] [nvarchar](50) NOT NULL,
	[TENNV] [nvarchar](50) NOT NULL,
	[GIOITINH] [nvarchar](10) NOT NULL,
	[NAMSINH] [date] NOT NULL,
	[QUEQUAN] [nvarchar](20) NOT NULL,
	[DIACHI] [nvarchar](50) NOT NULL,
	[CHUCVU] [nvarchar](10) NOT NULL,
	[MUCLUONG] [int] NOT NULL,
 CONSTRAINT [PK_QLNhanvien_1] PRIMARY KEY CLUSTERED 
(
	[MANV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[QLSanpham]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QLSanpham](
	[MASP] [int] NOT NULL,
	[TENSP] [nvarchar](50) NOT NULL,
	[LOAI] [int] NOT NULL,
	[SL] [int] NOT NULL,
	[GIA] [int] NOT NULL,
	[MANSX] [int] NOT NULL,
 CONSTRAINT [PK_QLSanpham] PRIMARY KEY CLUSTERED 
(
	[MASP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 5/12/2021 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[MaUser] [int] NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[PassUser] [nvarchar](50) NOT NULL,
	[PhanQuyen] [int] NOT NULL,
	[enable] [int] NOT NULL
) ON [PRIMARY]

GO
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (3, 2, N'Xe 3', 2)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (2, 3, N'Xe 2', 10)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (5, 4, N'Xe 5', 10)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (1, 5, N'Xe 1', 10)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (1, 6, N'Xe 1', 2)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (3, 6, N'Xe 3', 2)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (5, 8, N'Xe 5', 2)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (4, 9, N'Xe 4', 3)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (5, 9, N'Xe 5', 3)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (3, 9, N'Xe 3', 3)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (2, 2, N'Xe 2', 2)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (2, 11, N'Xe 2', 6)
INSERT [dbo].[CTHoadon] ([MaSP], [MaHD], [TenSP], [SL]) VALUES (5, 11, N'Xe 5', 6)
INSERT [dbo].[CTNhaphang] ([MaNH], [MaSP], [SL], [Gia]) VALUES (2, 3, 200, 23000)
INSERT [dbo].[CTNhaphang] ([MaNH], [MaSP], [SL], [Gia]) VALUES (2, 4, 200, 20000)
INSERT [dbo].[CTNhaphang] ([MaNH], [MaSP], [SL], [Gia]) VALUES (3, 5, 150, 15000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (2, 2, 2, N'11-05-2021', 146000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (3, 3, 2, N'11-05-2021', 100000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (4, 4, 4, N'11-05-2021', 450000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (5, 5, 5, N'11-05-2021', 200000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (6, 6, 4, N'11-05-2021', 66000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (8, 8, 2, N'11-03-2021', 30000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (9, 9, 3, N'11-03-2021', 489000)
INSERT [dbo].[Hoadon] ([MaHD], [MaKH], [MaNV], [NgayHD], [Tongtien]) VALUES (11, 11, 2, N'12-05-2021', 380000)
SET IDENTITY_INSERT [dbo].[Loai] ON 

INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (4, N'4 chỗ')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (5, N'7 chỗ')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (6, N'16 chỗ')
SET IDENTITY_INSERT [dbo].[Loai] OFF
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Diachi], [SDT], [SoFax]) VALUES (1, N'NCC 1', N'Q.1', N'908123456', N'908123456')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Diachi], [SDT], [SoFax]) VALUES (2, N'NCC 2', N'Q.2', N'0909123456', N'0909123456')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Diachi], [SDT], [SoFax]) VALUES (3, N'NCC 3', N'Q.3', N'0907123456', N'0907123456')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Diachi], [SDT], [SoFax]) VALUES (4, N'NCC 4 ', N'Q.4', N'0906123456', N'0906123456')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Diachi], [SDT], [SoFax]) VALUES (5, N'NCC 5', N'Q.5', N'0905123456', N'0905123456')
INSERT [dbo].[Nhaphang] ([MaNH], [MaNV], [MaNCC], [Ngaynhap], [Tongtien]) VALUES (2, 2, 2, N'10-05-2021', 8600000)
INSERT [dbo].[Nhaphang] ([MaNH], [MaNV], [MaNCC], [Ngaynhap], [Tongtien]) VALUES (3, 3, 3, N'10-05-2021', 2250000)
INSERT [dbo].[NSX] ([MaNSX], [TenNSX]) VALUES (1, N'NSX 1')
INSERT [dbo].[NSX] ([MaNSX], [TenNSX]) VALUES (2, N'NSX 2')
INSERT [dbo].[NSX] ([MaNSX], [TenNSX]) VALUES (3, N'NSX 3')
INSERT [dbo].[NSX] ([MaNSX], [TenNSX]) VALUES (4, N'NSX 4')
INSERT [dbo].[NSX] ([MaNSX], [TenNSX]) VALUES (5, N'NSX 5')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (1, N'Doan Chi', N'Quang', N'Q.8', N'0908123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (2, N'Doan Chi', N'Thien', N'Q.12', N'0384327229')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (3, N'Thai Phuong', N'Nam', N'Q.12', N'0909123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (4, N'Ha Khang', N'Ky', N'Q.12', N'0908123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (5, N'Doan Chi', N'Quang', N'Q.12', N'0908123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (6, N'Phuong', N'Nam', N'Q.9', N'0908123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (7, N'Luong', N'Kiet', N'Q.1', N'0908123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (8, N'Doan Chi', N'Quang', N'Q.1', N'0909123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (9, N'Khang', N'Ky', N'Q.2', N'0909123456')
INSERT [dbo].[QLKhachhang] ([MAKH], [HOKH], [TENKH], [DIACHI], [SDT]) VALUES (11, N'Doan', N'Chi', N'Q.12', N'0908123456')
INSERT [dbo].[QLNhanvien] ([MANV], [HONV], [TENNV], [GIOITINH], [NAMSINH], [QUEQUAN], [DIACHI], [CHUCVU], [MUCLUONG]) VALUES (1, N'Chi', N'Quang', N'Nam', CAST(N'2001-07-12' AS Date), N'HCM', N'Q.1', N'Mananger', 3000)
INSERT [dbo].[QLNhanvien] ([MANV], [HONV], [TENNV], [GIOITINH], [NAMSINH], [QUEQUAN], [DIACHI], [CHUCVU], [MUCLUONG]) VALUES (2, N'Ha Khang', N'Ky', N'Nam', CAST(N'2001-11-07' AS Date), N'TP HCM', N'Q.1', N'Nhân viên', 900)
INSERT [dbo].[QLNhanvien] ([MANV], [HONV], [TENNV], [GIOITINH], [NAMSINH], [QUEQUAN], [DIACHI], [CHUCVU], [MUCLUONG]) VALUES (3, N'Thai Phuong', N'Nam', N'Nam', CAST(N'2001-10-07' AS Date), N'Binh Dinh', N'Q.10', N'Nhân viên', 1100)
INSERT [dbo].[QLNhanvien] ([MANV], [HONV], [TENNV], [GIOITINH], [NAMSINH], [QUEQUAN], [DIACHI], [CHUCVU], [MUCLUONG]) VALUES (4, N'Huynh Luong', N'Kiet', N'Nam', CAST(N'2001-09-07' AS Date), N'TP HCM', N'Q.2', N'Nhân viên', 1200)
INSERT [dbo].[QLNhanvien] ([MANV], [HONV], [TENNV], [GIOITINH], [NAMSINH], [QUEQUAN], [DIACHI], [CHUCVU], [MUCLUONG]) VALUES (5, N'Tran Cong', N'Khoa', N'Nam', CAST(N'2001-08-07' AS Date), N'TP HCM', N'Q.7', N'Nhân viên', 1500)
INSERT [dbo].[QLNhanvien] ([MANV], [HONV], [TENNV], [GIOITINH], [NAMSINH], [QUEQUAN], [DIACHI], [CHUCVU], [MUCLUONG]) VALUES (6, N'Chi', N'Quang', N'Nam', CAST(N'1999-07-12' AS Date), N'TP HCM', N'Q.7', N'Nhân viên', 2000)
INSERT [dbo].[QLSanpham] ([MASP], [TENSP], [LOAI], [SL], [GIA], [MANSX]) VALUES (1, N'Xe 1', 4, 82, 20000, 1)
INSERT [dbo].[QLSanpham] ([MASP], [TENSP], [LOAI], [SL], [GIA], [MANSX]) VALUES (2, N'Xe 2', 5, 120, 10000, 2)
INSERT [dbo].[QLSanpham] ([MASP], [TENSP], [LOAI], [SL], [GIA], [MANSX]) VALUES (3, N'Xe 3', 6, 191, 23000, 3)
INSERT [dbo].[QLSanpham] ([MASP], [TENSP], [LOAI], [SL], [GIA], [MANSX]) VALUES (4, N'Xe 4', 4, 168, 20000, 4)
INSERT [dbo].[QLSanpham] ([MASP], [TENSP], [LOAI], [SL], [GIA], [MANSX]) VALUES (5, N'Xe 5', 5, 120, 15000, 5)
INSERT [dbo].[User] ([MaUser], [Username], [PassUser], [PhanQuyen], [enable]) VALUES (2, N'nhanvien01', N'123456', 0, 1)
INSERT [dbo].[User] ([MaUser], [Username], [PassUser], [PhanQuyen], [enable]) VALUES (3, N'nhanvien02', N'123456', 0, 1)
INSERT [dbo].[User] ([MaUser], [Username], [PassUser], [PhanQuyen], [enable]) VALUES (4, N'nhanvien03', N'123456', 0, 1)
INSERT [dbo].[User] ([MaUser], [Username], [PassUser], [PhanQuyen], [enable]) VALUES (5, N'nhanvien04', N'123456', 0, 1)
INSERT [dbo].[User] ([MaUser], [Username], [PassUser], [PhanQuyen], [enable]) VALUES (1, N'admin', N'123456', 1, 1)
/****** Object:  Index [IX_CTHoadon]    Script Date: 5/12/2021 11:41:58 AM ******/
CREATE NONCLUSTERED INDEX [IX_CTHoadon] ON [dbo].[CTHoadon]
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [username]    Script Date: 5/12/2021 11:41:58 AM ******/
ALTER TABLE [dbo].[User] ADD  CONSTRAINT [username] UNIQUE NONCLUSTERED 
(
	[MaUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [password]    Script Date: 5/12/2021 11:41:58 AM ******/
CREATE NONCLUSTERED INDEX [password] ON [dbo].[User]
(
	[MaUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CTHoadon]  WITH CHECK ADD  CONSTRAINT [FK_CTHoadon_Hoadon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[Hoadon] ([MaHD])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CTHoadon] CHECK CONSTRAINT [FK_CTHoadon_Hoadon]
GO
ALTER TABLE [dbo].[CTHoadon]  WITH CHECK ADD  CONSTRAINT [FK_CTHoadon_QLSanpham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[QLSanpham] ([MASP])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CTHoadon] CHECK CONSTRAINT [FK_CTHoadon_QLSanpham]
GO
ALTER TABLE [dbo].[CTNhaphang]  WITH CHECK ADD  CONSTRAINT [FK_CTNhaphang_Nhaphang] FOREIGN KEY([MaNH])
REFERENCES [dbo].[Nhaphang] ([MaNH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CTNhaphang] CHECK CONSTRAINT [FK_CTNhaphang_Nhaphang]
GO
ALTER TABLE [dbo].[CTNhaphang]  WITH CHECK ADD  CONSTRAINT [FK_CTNhaphang_QLSanpham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[QLSanpham] ([MASP])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CTNhaphang] CHECK CONSTRAINT [FK_CTNhaphang_QLSanpham]
GO
ALTER TABLE [dbo].[Hoadon]  WITH CHECK ADD  CONSTRAINT [FK_Hoadon_QLKhachhang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[QLKhachhang] ([MAKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Hoadon] CHECK CONSTRAINT [FK_Hoadon_QLKhachhang]
GO
ALTER TABLE [dbo].[Hoadon]  WITH CHECK ADD  CONSTRAINT [FK_Hoadon_QLNhanvien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[QLNhanvien] ([MANV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Hoadon] CHECK CONSTRAINT [FK_Hoadon_QLNhanvien]
GO
ALTER TABLE [dbo].[Nhaphang]  WITH CHECK ADD  CONSTRAINT [FK_Nhaphang_NCC] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NCC] ([MaNCC])
GO
ALTER TABLE [dbo].[Nhaphang] CHECK CONSTRAINT [FK_Nhaphang_NCC]
GO
ALTER TABLE [dbo].[Nhaphang]  WITH CHECK ADD  CONSTRAINT [FK_Nhaphang_QLNhanvien] FOREIGN KEY([MaNH])
REFERENCES [dbo].[QLNhanvien] ([MANV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Nhaphang] CHECK CONSTRAINT [FK_Nhaphang_QLNhanvien]
GO
ALTER TABLE [dbo].[QLSanpham]  WITH CHECK ADD  CONSTRAINT [FK_QLSanpham_Loai] FOREIGN KEY([LOAI])
REFERENCES [dbo].[Loai] ([MaLoai])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[QLSanpham] CHECK CONSTRAINT [FK_QLSanpham_Loai]
GO
ALTER TABLE [dbo].[QLSanpham]  WITH CHECK ADD  CONSTRAINT [FK_QLSanpham_NSX] FOREIGN KEY([MANSX])
REFERENCES [dbo].[NSX] ([MaNSX])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[QLSanpham] CHECK CONSTRAINT [FK_QLSanpham_NSX]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_QLNhanvien] FOREIGN KEY([MaUser])
REFERENCES [dbo].[QLNhanvien] ([MANV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_QLNhanvien]
GO
USE [master]
GO
ALTER DATABASE [QLOTO] SET  READ_WRITE 
GO
