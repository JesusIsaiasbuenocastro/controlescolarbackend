package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.CursosModel;
import com.proyecto.control.escolar.controlescolar.repository.CursosRepository;
import com.proyecto.control.escolar.controlescolar.service.CursosService;

@Service
public class CursoServiceImpl implements CursosService {
	
	@Autowired
	CursosRepository cursosRepository;

	@Override
	public List<CursosModel> obtenerTodo() {
		return cursosRepository.findAll();
	}

}
