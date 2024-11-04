package com.proyecto.control.escolar.controlescolar.components.cursos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;
import com.proyecto.control.escolar.controlescolar.model.CursosModel;

import lombok.Data;

@Data
@Component
public class CursosPorAlumno {
	CursosModel cursos;
	List<AlumnoModel> alumnos;
}
