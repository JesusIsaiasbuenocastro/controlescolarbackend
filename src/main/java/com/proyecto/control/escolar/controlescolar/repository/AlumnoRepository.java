package com.proyecto.control.escolar.controlescolar.repository;

import java.util.List;

import javax.persistence.NamedStoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;

public interface AlumnoRepository extends JpaRepository<AlumnoModel, Long> {
	/*
	@Transactional
	@Procedure(name = "obteneralumnos")
	List<AlumnoModel> obtenerLista();*/
}
