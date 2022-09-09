package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.control.escolar.controlescolar.model.CalificacionesModel;

public interface CalificacionesService {
	void guardar(CalificacionesModel calificacion);
	void actualizar(Long id, CalificacionesModel calificacion) throws Exception;
	Optional<CalificacionesModel> obtenerById(Long id)  throws Exception;
	List<CalificacionesModel> obtener ();
	void eliminar(Long id);
}
