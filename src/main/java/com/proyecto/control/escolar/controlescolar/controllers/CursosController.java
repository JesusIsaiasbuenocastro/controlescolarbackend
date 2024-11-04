package com.proyecto.control.escolar.controlescolar.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.proyecto.control.escolar.controlescolar.components.cursos.ResponseCurso;
import com.proyecto.control.escolar.controlescolar.components.cursos.ResponseCursos;
import com.proyecto.control.escolar.controlescolar.components.cursos.ResponseCursosAlumnos;
import com.proyecto.control.escolar.controlescolar.components.cursos.CursosPorAlumno;
import com.proyecto.control.escolar.controlescolar.model.AlumnoModel;
import com.proyecto.control.escolar.controlescolar.model.CursosModel;
import com.proyecto.control.escolar.controlescolar.service.CursosService;

import jakarta.validation.Valid;
 

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
	
	@Autowired
	ResponseCurso responseCurso;
	
	@Autowired
	ResponseCursosAlumnos responseCursosAlumnos;
	
	@GetMapping("/cursos")
	public ResponseEntity<ResponseCursos> obtenerTodo() {
		HttpStatus httpStatus;
		responseCursos = new ResponseCursos();
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
	
	@PostMapping("/cursos")
	public ResponseEntity<Response> guardar(@Valid @RequestBody CursosModel cursoModel) {
		HttpStatus httpStatus;
		try {
			cursosService.guardar(cursoModel);
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
	
	@DeleteMapping("/cursos/{id}")
	public  ResponseEntity<Response> eliminar(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			cursosService.eliminar(id);
			response.setCodRetorno("0");
			response.setMensaje("Registro eliminado exitosamente");
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
		}
		return new ResponseEntity<>(response,httpStatus);
	}
	
	@PutMapping("/cursos/{id}")
	public  ResponseEntity<Response> actualizar(@PathVariable Long id ,@RequestBody CursosModel curso) {
		HttpStatus httpStatus;
		try {
			cursosService.actualizar(id, curso);
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
	
	@GetMapping("/cursos/{id}")
	public ResponseEntity<ResponseCurso> obtenerPorId(@PathVariable Long id) {
		HttpStatus httpStatus;
		responseCurso = new ResponseCurso();
		try {
			CursosModel cursoModel = cursosService.obtenerById(id).get();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (cursoModel != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseCurso.setCurso(cursoModel);
			responseCurso.setResponse(response);
			httpStatus = HttpStatus.OK;
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
			responseCurso.setResponse(response);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(responseCurso,httpStatus);
	}

	@GetMapping("/cursos/alumnos")
	public ResponseEntity<ResponseCursosAlumnos> obteneralumnosporcurso() {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		responseCursosAlumnos = new ResponseCursosAlumnos();
		List<CursosPorAlumno> listaCursos = new ArrayList<CursosPorAlumno>();
		
		try {
			List<CursosModel> cursos = cursosService.obtenerTodo();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (cursos.size() > 0 ) {
				
				cursos.forEach(item -> {
						CursosPorAlumno cursosPorAlumnos = new CursosPorAlumno() ;
						cursosPorAlumnos.setCursos(item);

						List<AlumnoModel> alumnosPorCurso = cursosService.obtenerCursosPorAlumno(item.getId());
						//Validar que si existan grupos mandar el mensaje correspondiente 
						
						if (alumnosPorCurso.size() > 0 ) {
							cursosPorAlumnos.setAlumnos(alumnosPorCurso);
						}else {
							cursosPorAlumnos.setAlumnos( new ArrayList<AlumnoModel>());
						}
						listaCursos.add(cursosPorAlumnos);
								
					}
				);
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
				responseCursosAlumnos.setCursosAlumnos(listaCursos);
				responseCursosAlumnos.setResponse(response);
				httpStatus = HttpStatus.OK;	
				
				
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No hay cursos disponibles");
			}
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseCursosAlumnos.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseCursosAlumnos,httpStatus);
	}
}
