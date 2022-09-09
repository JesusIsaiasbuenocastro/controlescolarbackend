package com.proyecto.control.escolar.controlescolar.components.materia;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.MateriaModel;

import lombok.Data;

@Data
@Component
public class ResponseMateria {
	
	Response response;
	MateriaModel materia;
	
}
