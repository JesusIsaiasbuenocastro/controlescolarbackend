package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.control.escolar.controlescolar.model.MaestroModel;

public interface MaestroService {
	void guardar(MaestroModel maestro);
	void actualizar(Long id, MaestroModel maestro) throws Exception;
	Optional<MaestroModel> obtenerById(Long id)throws Exception;
	List<MaestroModel> obtener ();
	void eliminar(Long id);
}
