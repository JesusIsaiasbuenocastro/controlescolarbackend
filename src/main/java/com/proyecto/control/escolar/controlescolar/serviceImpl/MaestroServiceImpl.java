package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.MaestroModel;
import com.proyecto.control.escolar.controlescolar.repository.MaestroRepository;
import com.proyecto.control.escolar.controlescolar.service.MaestroService;

@Service
public class MaestroServiceImpl implements MaestroService {
	
	@Autowired
	MaestroRepository maestroRepository;
	
	@Override
	public void guardar(MaestroModel maestro) {
		// TODO Auto-generated method stub
		maestroRepository.save(maestro);
	}

	@Override
	public void actualizar(Long id, MaestroModel maestroParam) throws Exception{
		maestroRepository.findById(id).map(
				maestro -> {
					maestro.setApellidos(maestroParam.getApellidos());
					maestro.setEmail(maestroParam.getEmail());
					maestro.setNombre(maestroParam.getNombre());
					maestro.setTelefono(maestroParam.getTelefono());
					return maestroRepository.save(maestro);
					
				});
	}

	@Override
	public Optional<MaestroModel> obtenerById(Long id)throws Exception {
		return Optional.ofNullable(maestroRepository.findById(id).orElseThrow(() -> new Exception("El registro no existe")));
	}

	@Override
	public List<MaestroModel> obtener() {
		return maestroRepository.findAll();
	}

	@Override
	public void eliminar(Long id) {
		maestroRepository.deleteById(id);
		
	}

}
