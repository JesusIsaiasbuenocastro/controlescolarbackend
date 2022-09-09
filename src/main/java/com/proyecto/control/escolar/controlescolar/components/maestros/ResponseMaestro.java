package com.proyecto.control.escolar.controlescolar.components.maestros;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.MaestroModel;

import lombok.Data;

@Component
@Data
public class ResponseMaestro {
	Response response;
	MaestroModel maestro;
}
