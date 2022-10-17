package com.proyecto.control.escolar.controlescolar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="alumnos")
@NamedStoredProcedureQuery(name = "obteneralumnos",
procedureName = "obteneralumnos",
resultClasses = AlumnoModel.class)
@NamedStoredProcedureQuery(name = "obtenernummatricula",
procedureName = "obtenernummatricula",
resultClasses = String.class)
public class AlumnoModel {
	@Id
	public Long matricula;
	
	@NotNull
	public String secuencia;
	@NotNull
	public String year;
	@NotNull
	@NotBlank
	public String apellidos;
	@NotNull
	@NotBlank
	public String nombre;
	@NotNull
	public Long telefono;
	@NotNull
	@NotBlank
	@Email
	public String email;
	@NotNull
	@NotBlank
	public String grupo;
}
