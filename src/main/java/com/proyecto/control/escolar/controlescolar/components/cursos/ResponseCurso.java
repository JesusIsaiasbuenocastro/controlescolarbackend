package com.proyecto.control.escolar.controlescolar.components.cursos;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.CursosModel;

import lombok.Data;

@Data
@Component
public class ResponseCurso {
	Response response;
	CursosModel curso;
}
