package com.proyecto.control.escolar.controlescolar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="alumnos")
@NamedStoredProcedureQuery(name = "obtenerbusquedaporfiltro",
procedureName = "obtenerbusquedaporfiltro",
resultClasses = AlumnoModel.class,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "matricula"),
        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "grupo")
  })
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
