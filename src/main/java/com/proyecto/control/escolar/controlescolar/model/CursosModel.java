package com.proyecto.control.escolar.controlescolar.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="cursos")
@Data
public class CursosModel {

	@Id
	public Long id;
	
	@NotNull
	@NotBlank
	public String nombre;
	@NotNull
	@NotBlank
	public String nombre_maestro;
	@NotNull
	public Date fecha_inicio;
	@NotNull
	public Date fecha_fin;
	@NotNull
	@NotBlank
	public double costo;
}
