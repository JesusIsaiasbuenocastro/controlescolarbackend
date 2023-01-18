package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.CalificacionesModel;
import com.proyecto.control.escolar.controlescolar.model.MatriculaModel;
import com.proyecto.control.escolar.controlescolar.repository.CalificacionesRepository;
import com.proyecto.control.escolar.controlescolar.service.CalificacionesService;

@Service
public class CalificacionesServiceImpl implements CalificacionesService{
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	CalificacionesRepository calificacionesRepository;
	
	@Override
	public void guardar(CalificacionesModel calificacion) {
		calificacionesRepository.save(calificacion);
		
	}

	@Override
	public void actualizar(Long id, CalificacionesModel calificacionParam) throws Exception {
		calificacionesRepository.findById(id).map(
				calificacion -> {
					calificacion.setCalificacion(calificacionParam.getCalificacion());
					calificacion.setMateria(calificacionParam.getMateria());
					return calificacionesRepository.save(calificacion);
				}).orElseThrow(() -> new Exception("El registro no existe registro"));
		
		
	}

	@Override
	public Optional<CalificacionesModel> obtenerById(Long id) throws Exception {
		return Optional.ofNullable(calificacionesRepository.findById(id).orElseThrow(() -> new Exception("El registro no existe registro")));
	}

	@Override
	public List<CalificacionesModel> obtener() {
		return calificacionesRepository.findAll();
	}

	@Override
	public void eliminar(Long id) {
		calificacionesRepository.deleteById(id);
		
	}

	@Override
	public List<CalificacionesModel> obtenerTodo() {
		StoredProcedureQuery obtenerCalificaciones =
	              em.createNamedStoredProcedureQuery("obtenercalificaciones");
		obtenerCalificaciones.execute();
		return (List<CalificacionesModel>) obtenerCalificaciones.getResultList();
	}
	
}
