package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.SetNextNamingRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;
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

	@Override
	public void guardar(CursosModel curso) {
		cursosRepository.save(curso);
		
	}

	@Override
	public void eliminar(Long id) {
		cursosRepository.deleteById(id);
		
	}

	@Override
	public void actualizar(Long id, CursosModel curso) throws Exception {
		cursosRepository.findById(id).map(
				cursoModel -> {
					cursoModel.setNombre(curso.nombre);
					cursoModel.setNombre_maestro(curso.nombre_maestro);
					cursoModel.setFecha_inicio(curso.fecha_inicio);
					cursoModel.setFecha_fin(curso.fecha_fin);
					cursoModel.setCosto(curso.costo);					
					return cursosRepository.save(cursoModel);
				}).orElseThrow(() -> new Exception("El registro no existe"));
	}

	@Override
	public Optional<CursosModel> obtenerById(Long id) throws Exception {
		return Optional.ofNullable(cursosRepository.findById(id).orElseThrow(() -> new Exception("El registro no existe")));
	}

}
