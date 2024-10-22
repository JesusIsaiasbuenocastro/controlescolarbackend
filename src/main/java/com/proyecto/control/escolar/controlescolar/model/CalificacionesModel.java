package com.proyecto.control.escolar.controlescolar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name ="calificaciones")
@Data
@NamedStoredProcedureQuery(name = "obtenercalificaciones",
procedureName = "obtenercalificaciones",
resultClasses = CalificacionesModel.class)

public class CalificacionesModel {
	@Id
	public Long matricula;
	@NotNull
	public String materia;
	@NotNull
	public int calificacion;
}
