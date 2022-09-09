package com.proyecto.control.escolar.controlescolar.components.alumnos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;

import lombok.Data;

@Component
@Data
public class ResponseAlumnos {
	
	Response response;
	List<AlumnoModel> listaAlumnos;
}
