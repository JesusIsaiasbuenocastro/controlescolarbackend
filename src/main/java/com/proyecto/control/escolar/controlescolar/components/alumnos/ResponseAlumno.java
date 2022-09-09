package com.proyecto.control.escolar.controlescolar.components.alumnos;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;

import lombok.Data;

@Data
@Component
public class ResponseAlumno {
	Response response;
	AlumnoModel alumno;
}
