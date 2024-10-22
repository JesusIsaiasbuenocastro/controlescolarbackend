create procedure obtenernummatricula
as
	
	--declare 
	DECLARE @maximasecuencia varchar(4);
	DECLARE @matricula varchar(8);
	DECLARE @yearActual int;

	SET NOCOUNT ON;
	
	select  @yearActual = year(GETDATE())

	select  @maximasecuencia = RIGHT('000' + Ltrim(Rtrim(max(secuencia +1))),5)
	from alumnos a where year = @yearActual
	
	
	if @maximasecuencia is null
		set @maximasecuencia = RIGHT('000' + Ltrim(Rtrim(max(1))),5);
	
	--Asignar la siquiente matricula
	set @matricula = '2022' + @maximasecuencia
	
	select @matricula as matricula, @maximasecuencia as secuencia,@yearActual as year
