package com.proyecto.control.escolar.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.control.escolar.controlescolar.model.MateriaModel;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaModel, Long>{
	
}
