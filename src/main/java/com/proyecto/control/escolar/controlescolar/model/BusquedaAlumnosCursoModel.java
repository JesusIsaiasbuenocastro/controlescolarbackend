package com.proyecto.control.escolar.controlescolar.model;

import com.proyecto.control.escolar.controlescolar.components.cursos.ResponseCursosPorAlumno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.ParameterMode;
import lombok.Data;

@Data
@Entity
@Table(name="alumnos_cursos")
@NamedStoredProcedureQuery(name = "obteneralumnosporcurso",
procedureName = "obteneralumnosporcurso",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "nombre")
  },
resultClasses = AlumnoModel.class )
public class BusquedaAlumnosCursoModel {
	@Id
	public Long idCurso;
	
	public int id_alumno;
}
