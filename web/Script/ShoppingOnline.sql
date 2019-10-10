use master
GO
Create Database ShoppingOnline
Go
Use ShoppingOnline
GO
--Drop Table Categories
GO
Create Table Categories
(
	CategoryID int identity(1,1) Primary Key,
	CategoryName varchar(200)
)
Go
--Drop Table Products
GO
Create Table Products
(
	ProductID int identity(1,1) Primary Key,
	ProductName varchar(200),
	Price numeric(10,0),
	ImgSrc varchar(200),
	Summary varchar(2000),
	Description text,
	Status bit,
	CategoryID int foreign key references Categories(CategoryID)
)

GO

Create Table Users
(
	UserID int identity(1,1) Primary Key,
	UserName varchar(200),
	Password varchar(200) 
)
GO
Select * from Categories
--Delete Categories
GO
Insert Into Categories(CategoryName)
Values('May mac')
Insert Into Categories(CategoryName)
Values('Dien tu dien lanh')
Insert Into Categories(CategoryName)
Values('Gia dung')
Insert Into Categories(CategoryName)
Values('Thuc pham')
Go

--Delete Products
GO
Select * from Products
GO
Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID)
Values('Ti vi 32 inches',8000000,'tivi32_1.jpg','Ti vi sac net','',1,2)
Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID)
Values('tu lanh 150 lit',8000000,'tulanh150_1.jpg','Tiet kiem dien nang','',1,2)
Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID)
Values('Quan bo 1',8000000,'quanbo_1.jpg','Chat luong tot','',1,1)
Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID)
Values('Ti vi 32 inches 2',8000000,'tivi32_2.jpg','Ti vi sac net','',1,2)
Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID)
Values('tu lanh 150 lit',8000000,'tulanh150_2.jpg','Tiet kiem dien nang','',1,2)
Insert Into Products(ProductName,Price,ImgSrc,Summary,Description,Status,CategoryID)
Values('Quan bo 2',8000000,'quanbo_2.jpg','Chat luong tot','',1,1)

GO

Insert Into Users(UserName,Password)
Values('user01','123')
--
Select * from Users

Go


