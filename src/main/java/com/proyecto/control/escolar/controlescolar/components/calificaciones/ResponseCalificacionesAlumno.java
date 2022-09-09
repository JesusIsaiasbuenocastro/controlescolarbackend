package com.proyecto.control.escolar.controlescolar.components.calificaciones;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.CalificacionesModel;

import lombok.Data;

@Component
@Data
public class ResponseCalificacionesAlumno {
	
	Response response;
	CalificacionesModel calificacionesModel;
}
