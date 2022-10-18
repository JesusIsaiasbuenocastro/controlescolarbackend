package com.proyecto.control.escolar.controlescolar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

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
