package com.proyecto.control.escolar.controlescolar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
public class AlumnoModel {
	@Id
	public Long matricula;
	
	public String secuencia;
	public int year;
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
