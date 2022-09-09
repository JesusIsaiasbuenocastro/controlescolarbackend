package com.proyecto.control.escolar.controlescolar.components.grupos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.GrupoModel;

import lombok.Data;

@Component
@Data
public class ResponseGrupos {
	
	Response response;
	List<GrupoModel> listaGrupos;
}
