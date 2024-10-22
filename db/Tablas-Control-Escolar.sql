

create table maestros(
	id INT NOT NULL IDENTITY(1,1) ,
	nombre varchar(45),
	apellidos varchar(45),
	telefono VARCHAR(10),
	email varchar(55),
	PRIMARY KEY(id)
); 
create table grupos (
	id int not null IDENTITY(1,1) ,
	descripcion varchar(4),
	primary key (id)
	
);

create table materias(
	id INT NOT NULL IDENTITY(1,1), 
	nombre varchar(45),
	id_maestro int,
	limite int,
	PRIMARY KEY(id),
	FOREIGN KEY (id_maestro) REFERENCES maestros(id)
);
 
create table alumnos(
	matricula INT NOT NULL, 
	secuencia int not null,
 	year int not null,
	nombre varchar(45) not null,
	apellidos varchar(45)not null,
	telefono VARCHAR(10),
	email varchar(55),
	grupo int not null,
	fechaAlta datetime default CURRENT_TIMESTAMP,
	PRIMARY KEY(matricula),
	FOREIGN KEY (grupo) REFERENCES grupos(id)
);

create table calificaciones (
	matricula int not null,
	materia int not null,
	calificacion int not null,
	primary key(matricula),
	FOREIGN KEY (matricula) REFERENCES alumnos(matricula),
	FOREIGN KEY (materia) REFERENCES materias(id)
);
