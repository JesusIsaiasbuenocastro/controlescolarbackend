package com.proyecto.control.escolar.controlescolar.components.grupos;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.GrupoModel;

import lombok.Data;

@Component
@Data
public class ResponseGrupo {
	Response respose;
	GrupoModel grupoModel;
}
