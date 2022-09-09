package com.proyecto.control.escolar.controlescolar.components.maestros;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.model.MaestroModel;

import lombok.Data;

@Component
@Data
public class ResponseMaestros {
	Response response;
	List<MaestroModel> listaMaestros;
}
