package com.proyecto.control.escolar.controlescolar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
