package com.proyecto.control.escolar.controlescolar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
@Table(name="alumnos")
@NamedStoredProcedureQuery(name = "obtenernummatricula",
procedureName = "obtenernummatricula",
resultClasses = MatriculaModel.class )
public class MatriculaModel {
	@Id
	public Long matricula;
	
	public String secuencia;
	public int year;
}
