package com.proyecto.control.escolar.controlescolar.components.alumnos;

import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@Data
@NamedStoredProcedureQuery(name = "obtenernummatricula",
procedureName = "obtenernummatricula",
resultClasses = String.class)
public class ResponseAlumnoMatricula {
	
	String matricula;
}
