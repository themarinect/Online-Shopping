CREATE PROCEDURE spSeparationPage_Categories(   
	@PageNumber int,   
	@PageSize int  
)   
AS   
 DECLARE @Start int, @End int  
 BEGIN TRANSACTION GetDataSet   
	 SET @Start = (((@PageNumber - 1) * @PageSize) + 1)   
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 SET @End = (@Start + @PageSize - 1)   
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 CREATE TABLE #TemporaryTable (   
		Row int IDENTITY(1,1) PRIMARY KEY,   
		CategoryID int, CategoryName varchar(200)   
	 )   
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 INSERT INTO #TemporaryTable   
	 SELECT CategoryID, CategoryName FROM Categories  
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 SELECT CategoryID, CategoryName    
	 FROM #TemporaryTable   
	 WHERE (Row >= @Start) AND (Row <= @End)   
	 IF @@ERROR <> 0   
	  GOTO ErrorHandler   
	 DROP TABLE #TemporaryTable   
	 COMMIT TRANSACTION GetDataSet   
	 RETURN 0   
ErrorHandler:   
	ROLLBACK TRANSACTION GetDataSet   
	RETURN @@ERROR 
GO

---

Exec dbo.spSeparationPage_Categories 1,4
--
CREATE PROCEDURE spSeparationPage_Products(   
	@PageNumber int,   
	@PageSize int  
)   
AS   
 DECLARE @Start int, @End int  
 BEGIN TRANSACTION GetDataSet   
	 SET @Start = (((@PageNumber - 1) * @PageSize) + 1)   
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 SET @End = (@Start + @PageSize - 1)   
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 CREATE TABLE #TemporaryTable (   
		Row int IDENTITY(1,1) PRIMARY KEY,   
		ProductID int,
		ProductName varchar(200),
		Price numeric(10,0),
		ImgSrc varchar(200),
		Summary varchar(2000),
		Description text,
		Status bit,
		CategoryID int   
	 )   
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 INSERT INTO #TemporaryTable   
	 SELECT * FROM Products  
	 IF @@ERROR <> 0   
		GOTO ErrorHandler   
	 SELECT *   
	 FROM #TemporaryTable   
	 WHERE (Row >= @Start) AND (Row <= @End)   
	 IF @@ERROR <> 0   
	  GOTO ErrorHandler   
	 DROP TABLE #TemporaryTable   
	 COMMIT TRANSACTION GetDataSet   
	 RETURN 0   
ErrorHandler:   
	ROLLBACK TRANSACTION GetDataSet   
	RETURN @@ERROR 
GO


Exec dbo.spSeparationPage_Products 1,4
