package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.control.escolar.controlescolar.model.GrupoModel;

public interface GrupoService {
	void guardar(GrupoModel grupo);
	void actualizar(Long id, GrupoModel grupo) throws Exception;
	Optional<GrupoModel> obtenerById(Long id)  throws Exception;
	List<GrupoModel> obtener ();
	void eliminar(Long id);
}
