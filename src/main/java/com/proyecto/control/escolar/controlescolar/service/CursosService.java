package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;
import com.proyecto.control.escolar.controlescolar.model.CursosModel;

public interface CursosService {
	void guardar(CursosModel curso);
	void eliminar(Long id);
	List<CursosModel> obtenerTodo ();
	void actualizar(Long id, CursosModel curso) throws Exception;
	Optional<CursosModel> obtenerById(Long id)  throws Exception;
	List<AlumnoModel> obtenerCursosPorAlumno (Long idCurso);
}
