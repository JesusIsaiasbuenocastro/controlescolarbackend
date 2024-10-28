create procedure obteneralumnos 
as
	SET NOCOUNT ON;
	select matricula, secuencia, year,nombre, apellidos, telefono, email, g.nombre  as grupo
from alumnos a
inner join curso g on a.id =  g.id
order by a.apellidos asc