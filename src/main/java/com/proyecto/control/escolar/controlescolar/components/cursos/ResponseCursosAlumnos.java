package com.proyecto.control.escolar.controlescolar.components.cursos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;

import lombok.Data;

@Data
@Component
public class ResponseCursosAlumnos {
	Response response;
	List<CursosPorAlumno> cursosAlumnos;
}
