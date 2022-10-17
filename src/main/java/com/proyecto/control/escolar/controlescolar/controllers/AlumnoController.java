package com.proyecto.control.escolar.controlescolar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.control.escolar.controlescolar.components.Response;
import com.proyecto.control.escolar.controlescolar.components.alumnos.ResponseAlumno;
import com.proyecto.control.escolar.controlescolar.components.alumnos.ResponseAlumnoMatricula;
import com.proyecto.control.escolar.controlescolar.components.alumnos.ResponseAlumnos;
import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;
import com.proyecto.control.escolar.controlescolar.service.AlumnoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlumnoController {
	
	@Autowired
	ResponseAlumnos responseAlumnos;
	
	@Autowired
	ResponseAlumno responseAlumno;
	
	@Autowired
	Response response;
	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	ResponseAlumnoMatricula responseAlumnoMatricula;
	
	@GetMapping("/alumno")
	public ResponseEntity<ResponseAlumnos> obtenerTodo() {
		HttpStatus httpStatus;
		try {
			List<AlumnoModel> alumnos = alumnoService.obtener();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (alumnos.size() > 0 ) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseAlumnos.setListaAlumnos(alumnos);
			responseAlumnos.setResponse(response);
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseAlumnos.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseAlumnos,httpStatus);
	}
	@GetMapping("/alumno/obtenerlista")
	public ResponseEntity<ResponseAlumnos> obtenerlista() {
		HttpStatus httpStatus;
		try {
			List<AlumnoModel> alumnos = alumnoService.obtenerLista();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (alumnos.size() > 0 ) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseAlumnos.setListaAlumnos(alumnos);
			responseAlumnos.setResponse(response);
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseAlumnos.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseAlumnos,httpStatus);
	}
	@GetMapping("/alumno/obtenernummatricula")
	public ResponseEntity<ResponseAlumnoMatricula> obtenermatricula() {
		HttpStatus httpStatus;
		try {
			String matricula = alumnoService.obtenerMatricula();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (matricula != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseAlumnoMatricula.setMatricula(matricula );
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseAlumnoMatricula,httpStatus);
	}
	@GetMapping("/alumno/{id}")
	public ResponseEntity<ResponseAlumno> obtenerPorId(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			AlumnoModel alumnoModel = alumnoService.obtenerById(id).get();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (alumnoModel != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseAlumno.setAlumno(alumnoModel);
			responseAlumno.setResponse(response);
			httpStatus = HttpStatus.OK;
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
			responseAlumno.setResponse(response);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(responseAlumno,httpStatus);
	}
	@PostMapping("/alumno")
	public ResponseEntity<Response> guardar(@Valid @RequestBody AlumnoModel alumnoModel) {
		HttpStatus httpStatus;
		try {
			alumnoService.guardar(alumnoModel);
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
	@PutMapping("/alumno/{id}")
	public  ResponseEntity<Response> actualizar(@PathVariable Long id ,@RequestBody AlumnoModel alumno) {
		HttpStatus httpStatus;
		try {
			alumnoService.actualizar(id, alumno);
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
	@DeleteMapping("/alumno/{id}")
	public  ResponseEntity<Response> eliminar(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			alumnoService.eliminar(id);
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
