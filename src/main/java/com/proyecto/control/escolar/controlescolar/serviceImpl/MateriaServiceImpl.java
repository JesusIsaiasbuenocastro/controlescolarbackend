package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.MateriaModel;
import com.proyecto.control.escolar.controlescolar.repository.MateriaRepository;
import com.proyecto.control.escolar.controlescolar.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	@Autowired
	MateriaRepository materiaRepository;

	@Override
	public void guardar(MateriaModel materia) {
		materiaRepository.save(materia);
	}

	@Override
	public List<MateriaModel> obtener() {
		List<MateriaModel> materias = (List<MateriaModel>) materiaRepository.findAll();
		return materias;
	}

	@Override
	public Optional<MateriaModel> obtenerById(Long id) throws Exception{
		return Optional.ofNullable(materiaRepository.findById(id).orElseThrow(() -> new Exception("El registro no existe ")));
		
	}

	@Override
	public void actualizar(Long id, MateriaModel materiaParam) throws Exception{
		materiaRepository.findById(id).map(
				materia -> {
					materia.setIdMaestro(materiaParam.getIdMaestro());
					materia.setNombre(materiaParam.getNombre());
					materia.setLimite(materiaParam.getLimite());
					return materiaRepository.save(materia);
		}).orElseThrow(() -> new Exception("El registro no existe"));
		
	}

	@Override
	public void eliminar(Long id) {
		materiaRepository.deleteById(id);
		
	}
}
