package com.proyecto.control.escolar.controlescolar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.components.maestros.ResponseMaestro;
import com.proyecto.control.escolar.controlescolar.components.maestros.ResponseMaestros;
import com.proyecto.control.escolar.controlescolar.model.MaestroModel; 
import com.proyecto.control.escolar.controlescolar.service.MaestroService;

@RestController
@RequestMapping("/api")
public class MaestrosController {
	
	@Autowired
	MaestroService maestroService;
	
	@Autowired 
	Response response;
	
	@Autowired
	ResponseMaestros responseMaestros;
	
	@Autowired
	ResponseMaestro responseMaestro;
	
	@PostMapping("/maestros")
	public  ResponseEntity<Response> guardar(@Valid @RequestBody MaestroModel maestro ) {
		try {
			maestroService.guardar(maestro);
			response.setCodRetorno("0");
			response.setMensaje("Registrado exitosamente");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/maestros")
	public ResponseEntity<ResponseMaestros> obtenerTodo() {
		HttpStatus httpStatus;
		try {
			List<MaestroModel> maestros = maestroService.obtener();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (maestros.size() > 0 ) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseMaestros.setListaMaestros(maestros);
			responseMaestros.setResponse(response);
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseMaestros.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseMaestros,httpStatus);
	}
	@GetMapping("/maestros/{id}")
	public ResponseEntity<ResponseMaestro> obtenerPorId(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			MaestroModel maestroModel = maestroService.obtenerById(id).get();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (maestroModel != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseMaestro.setMaestro(maestroModel) ;
			responseMaestro.setResponse(response);
			httpStatus = HttpStatus.OK;
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
			responseMaestro.setResponse(response);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(responseMaestro,httpStatus);
	}
	@PutMapping("/maestros/{id}")
	public  ResponseEntity<Response> actualizar(@PathVariable Long id ,@RequestBody MaestroModel maestro ) {
		HttpStatus httpStatus;
		try {
			maestroService.actualizar(id, maestro);
			response.setCodRetorno("0");
			response.setMensaje("Actualizado exitosamente");
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
		}
		return new ResponseEntity<>(response,httpStatus);
	}
	@DeleteMapping("/maestros/{id}")
	public  ResponseEntity<Response> eliminar(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			maestroService.eliminar(id);
			response.setCodRetorno("0");
			response.setMensaje("Registro eliminado exitosamente");
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			response.setCodRetorno("-1");
			response.setMensaje("Ocurrio un error al eliminar el registro");
		}
		return new ResponseEntity<>(response,httpStatus);
	}
}
