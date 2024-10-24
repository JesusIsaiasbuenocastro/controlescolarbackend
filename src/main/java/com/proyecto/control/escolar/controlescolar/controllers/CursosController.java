package com.proyecto.control.escolar.controlescolar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.components.cursos.ResponseCursos;
import com.proyecto.control.escolar.controlescolar.model.CursosModel;
import com.proyecto.control.escolar.controlescolar.service.CursosService;
 

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CursosController {
	
	@Autowired
	CursosService cursosService;

	@Autowired
	Response response;
	
	@Autowired
	ResponseCursos responseCursos;
	
	@GetMapping("/cursos")
	public ResponseEntity<ResponseCursos> obtenerTodo() {
		HttpStatus httpStatus;
		try {
			List<CursosModel> cursos = cursosService.obtenerTodo();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (cursos.size() > 0 ) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseCursos.setListaCursos(cursos);
			responseCursos.setResponse(response);
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseCursos.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseCursos,httpStatus);
	}
}
