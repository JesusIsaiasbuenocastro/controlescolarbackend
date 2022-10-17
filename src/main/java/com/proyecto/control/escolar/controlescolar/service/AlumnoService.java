package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.control.escolar.controlescolar.components.alumnos.ResponseAlumnoMatricula;
import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;

public interface AlumnoService {
	void guardar(AlumnoModel alumno);
	void actualizar(Long id, AlumnoModel alumno) throws Exception;
	Optional<AlumnoModel> obtenerById(Long id)  throws Exception;
	List<AlumnoModel> obtener ();
	List<AlumnoModel> obtenerLista ();
	String obtenerMatricula ();
	void eliminar(Long id);
}
