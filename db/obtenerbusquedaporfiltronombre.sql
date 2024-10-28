--drop procedure obtenerbusquedaporfiltronombre;
create procedure obtenerbusquedaporfiltronombre @nombre varchar(8)
as
	SET NOCOUNT ON;
	
	select id, matricula, secuencia, year,nombre, apellidos, telefono, email
	from alumnos 
	where nombre like '%'+@nombre+'%' or apellidos like '%'+@nombre+'%'