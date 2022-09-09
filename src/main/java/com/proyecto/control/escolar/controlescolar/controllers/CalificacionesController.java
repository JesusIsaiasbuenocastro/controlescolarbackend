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
import com.proyecto.control.escolar.controlescolar.components.calificaciones.ResponseCalificaciones;
import com.proyecto.control.escolar.controlescolar.components.calificaciones.ResponseCalificacionesAlumno;
import com.proyecto.control.escolar.controlescolar.model.CalificacionesModel;
import com.proyecto.control.escolar.controlescolar.service.CalificacionesService;

@RestController
@RequestMapping("/api")
public class CalificacionesController {
	
	@Autowired
	CalificacionesService calificacionesService;
	
	@Autowired
	ResponseCalificaciones responseCalificaciones;
	
	@Autowired
	ResponseCalificacionesAlumno responseCalificacionesAlumno;
	
	@Autowired
	Response response;
	
	@GetMapping("/calificaciones")
	public ResponseEntity<ResponseCalificaciones> obtenerTodo() {
		HttpStatus httpStatus;
		try {
			List<CalificacionesModel> calificaciones = calificacionesService.obtener();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (calificaciones.size() > 0 ) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseCalificaciones.setListaCalificaciones(calificaciones);
			responseCalificaciones.setResponse(response);
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseCalificaciones.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseCalificaciones,httpStatus);
	}
	@GetMapping("/calificaciones/{matricula}")
	public ResponseEntity<ResponseCalificacionesAlumno> obtenerPorId(@PathVariable Long matricula) {
		HttpStatus httpStatus;
		try {
			CalificacionesModel calificacionesModel = calificacionesService.obtenerById(matricula).get();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (calificacionesModel != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseCalificacionesAlumno.setCalificacionesModel(calificacionesModel);
			responseCalificacionesAlumno.setResponse(response);
			httpStatus = HttpStatus.OK;
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
			responseCalificacionesAlumno.setResponse(response);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(responseCalificacionesAlumno,httpStatus);
	}
	@PostMapping("/calificaciones")
	public ResponseEntity<Response> guardar(@Valid @RequestBody CalificacionesModel calificacionesModel) {
		HttpStatus httpStatus;
		try {
			calificacionesService.guardar(calificacionesModel);
			response.setCodRetorno("0");
			response.setMensaje("Registrado exitosamente");
			httpStatus = HttpStatus.OK;
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje("Ocurrió un error - "+ e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(response, httpStatus);
	}
	@PutMapping("/calificaciones/{matricula}")
	public  ResponseEntity<Response> actualizar(@PathVariable Long matricula ,@RequestBody CalificacionesModel calificacion) {
		HttpStatus httpStatus;
		try {
			calificacionesService.actualizar(matricula, calificacion);
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
	@DeleteMapping("/calificaciones/{matricula}")
	public  ResponseEntity<Response> eliminar(@PathVariable Long matricula) {
		HttpStatus httpStatus;
		try {
			calificacionesService.eliminar(matricula);
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
