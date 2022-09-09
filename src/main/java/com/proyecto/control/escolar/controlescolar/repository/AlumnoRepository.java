package com.proyecto.control.escolar.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;

public interface AlumnoRepository extends JpaRepository<AlumnoModel, Long> {

}
