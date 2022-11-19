package com.proyecto.control.escolar.controlescolar.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;
import com.proyecto.control.escolar.controlescolar.model.BusquedaFiltroModel;
import com.proyecto.control.escolar.controlescolar.model.MatriculaModel;
import com.proyecto.control.escolar.controlescolar.repository.AlumnoRepository;
import com.proyecto.control.escolar.controlescolar.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void guardar(AlumnoModel alumno) {
		alumnoRepository.save(alumno);
		
	}

	@Override
	public void actualizar(Long id, AlumnoModel alumnoParam) throws Exception {
		alumnoRepository.findById(id).map(
				alumno -> {
					alumno.setApellidos(alumnoParam.getApellidos());
					alumno.setEmail(alumnoParam.getEmail());
					alumno.setGrupo(alumnoParam.getGrupo());
					alumno.setNombre(alumnoParam.getNombre());
					alumno.setTelefono(alumnoParam.getTelefono());
					
					return alumnoRepository.save(alumno);
				}).orElseThrow(() -> new Exception("El registro no existe"));
		
	}

	@Override
	public Optional<AlumnoModel> obtenerById(Long id) throws Exception {
		return Optional.ofNullable(alumnoRepository.findById(id).orElseThrow(() -> new Exception("El registro no existe")));
	}

	@Override
	public List<AlumnoModel> obtener() {
		return alumnoRepository.findAll();
	}

	@Override
	public void eliminar(Long id) {
		alumnoRepository.deleteById(id);
		
	}

	@Override
	public List<AlumnoModel> obtenerLista() {
		
		 StoredProcedureQuery obtenerRegistrosAlumnos =
	              em.createNamedStoredProcedureQuery("obteneralumnos");
	        return obtenerRegistrosAlumnos.getResultList();
	}

	@Override
	public MatriculaModel obtenerMatricula() {
		StoredProcedureQuery obtenerMatricula =
	              em.createNamedStoredProcedureQuery("obtenernummatricula");
		obtenerMatricula.execute();
		return (MatriculaModel) obtenerMatricula.getResultList().get(0);
	}

	@Override
	public List<AlumnoModel> obtenerlistafiltro(BusquedaFiltroModel requestModel) {
		StoredProcedureQuery q = em.createStoredProcedureQuery("obtenerbusquedaporfiltro", AlumnoModel.class);
		q.registerStoredProcedureParameter("matricula", String.class, ParameterMode.IN);
		q.registerStoredProcedureParameter("grupo", String.class, ParameterMode.IN);
		q.setParameter("matricula", requestModel.getMatricula());
		q.setParameter("grupo", requestModel.getGrupo());//passing null value to Param2

		List<AlumnoModel> alumnosFiltro =  q.getResultList();
		
		return alumnosFiltro;
	}
	

}
