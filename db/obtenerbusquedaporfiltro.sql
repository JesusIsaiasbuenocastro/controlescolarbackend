
create procedure obtenerbusquedaporfiltro @matricula varchar(8), @grupo int 
as
	SET NOCOUNT ON;
	
	declare @query varchar(1000);
	declare @query2 varchar(100);
	
	set @query2 = ' and ' 
	
	--validar que no esten vacios los parametros
	if @matricula != '' or @grupo != -1 
		set @query = 'select matricula, secuencia, year,nombre, apellidos, telefono, email, g.descripcion  as grupo
		from alumnos a
		inner join grupos g on a.grupo =  g.id where '
	
		if @matricula != ''
			set @query = @query + ' a.matricula = ' + @matricula
		
		if @matricula  != '' and @grupo != -1
			set @query = @query + @query2
			
		if @grupo != -1
			set @query = @query + ' g.id = ' + convert (varchar(2),@grupo)
			
		exec (@query)
	
	
	