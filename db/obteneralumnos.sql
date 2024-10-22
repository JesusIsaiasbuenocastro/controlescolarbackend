create procedure obteneralumnos 
as
	SET NOCOUNT ON;
	select matricula, secuencia, year,nombre, apellidos, telefono, email, g.descripcion  as grupo
from alumnos a
inner join grupos g on a.grupo =  g.id
order by a.apellidos asc