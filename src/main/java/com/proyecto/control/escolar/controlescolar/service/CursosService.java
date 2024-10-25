package com.proyecto.control.escolar.controlescolar.service;

import java.util.List;
import com.proyecto.control.escolar.controlescolar.model.CursosModel;

public interface CursosService {
	void guardar(CursosModel curso);
	List<CursosModel> obtenerTodo ();
}
