package com.proyecto.control.escolar.controlescolar.components.materia;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.MateriaModel;

import lombok.Data;

@Data
@Component
public class ResponseMaterias {
	
	public Response response;
	public List<MateriaModel> listaMaterias;
	
}
