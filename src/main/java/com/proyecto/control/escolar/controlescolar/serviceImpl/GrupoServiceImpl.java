package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.GrupoModel;
import com.proyecto.control.escolar.controlescolar.repository.GrupoRepository;
import com.proyecto.control.escolar.controlescolar.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService{
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Override
	public void guardar(GrupoModel grupo) {
		grupoRepository.save(grupo);
	}

	@Override
	public void actualizar(Long id, GrupoModel grupoParam) throws Exception {
		grupoRepository.findById(id).map(
				grupo -> {
					grupo.setDescripcion(grupoParam.getDescripcion());
					return grupoRepository.save(grupo);
				}).orElseThrow(() -> new Exception("El registro no existe en el catalogo"));
		
	}

	@Override
	public Optional<GrupoModel> obtenerById(Long id) throws Exception  {
		return Optional.ofNullable(grupoRepository.findById(id).orElseThrow(() -> new Exception("El registro no existe en el catalogo")));
	}

	@Override
	public List<GrupoModel> obtener() {
		return grupoRepository.findAll();
	}

	@Override
	public void eliminar(Long id) {
		grupoRepository.deleteById(id);		
	}
	
}
