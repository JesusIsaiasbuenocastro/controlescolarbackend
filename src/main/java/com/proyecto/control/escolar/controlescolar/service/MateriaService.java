package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.control.escolar.controlescolar.model.MateriaModel;

public interface MateriaService {
	void guardar(MateriaModel materia);
	void actualizar(Long id, MateriaModel materia) throws Exception;
	Optional<MateriaModel> obtenerById(Long id) throws Exception;
	List<MateriaModel> obtener ();
	void eliminar(Long id);
}
