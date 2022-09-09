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
import com.proyecto.control.escolar.controlescolar.components.materia.ResponseMateria;
import com.proyecto.control.escolar.controlescolar.components.materia.ResponseMaterias;
import com.proyecto.control.escolar.controlescolar.model.MateriaModel;
import com.proyecto.control.escolar.controlescolar.service.MateriaService;

@RestController
@RequestMapping("/api")
public class MateriasController {

	@Autowired
	MateriaService materiaService;
	
	@Autowired
	Response response ;
	
	@Autowired
	ResponseMateria responseMateria;
	
	@Autowired
	ResponseMaterias responseMatarias;
	
	@PostMapping("/materias")
	public  ResponseEntity<Response> guardar(@Valid @RequestBody MateriaModel materia ) {
		HttpStatus httpStatus;
		try {
			//validar que no exista otro registro con el mismo nombre 
			List<MateriaModel> materias = materiaService.obtener();
			
			for(MateriaModel materiaModel : materias) {
				if(materiaModel.getNombre().trim().equals(materia.getNombre().trim())) {
					throw new Exception ("La materia ya existe");
				}
			}
			
			materiaService.guardar(materia);
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
	@PutMapping("/materia/{id}")
	public  ResponseEntity<Response> actualizar(@PathVariable Long id ,@RequestBody MateriaModel materia ) {
		HttpStatus httpStatus;
		try {
			materiaService.actualizar(id, materia);
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
	@GetMapping("/materias")
	public ResponseEntity<ResponseMaterias> obtenerTodos() {
		List<MateriaModel> materias = materiaService.obtener();
		
		//Validar que si existan materias mandar el mensaje correspondiente 
		if (materias.size() > 0 ) {
			response.setCodRetorno("0");
			response.setMensaje("Consulta exitosa");
		}else {
			response.setCodRetorno("1");
			response.setMensaje("No existen registros");
		}
		responseMatarias.setListaMaterias(materias);
		responseMatarias.setResponse(response);
		return new ResponseEntity<>(responseMatarias,HttpStatus.OK);
	}
	@GetMapping("/materia/{id}")
	public ResponseEntity<ResponseMateria> actualizar(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			MateriaModel materiaModel = materiaService.obtenerById(id).get();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (materiaModel != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseMateria.setMateria(materiaModel);
			responseMateria.setResponse(response);
			httpStatus = HttpStatus.OK;
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
			responseMateria.setResponse(response);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(responseMateria,httpStatus);
	}
	
	@DeleteMapping("/materia/{id}")
	public ResponseEntity<Response> eliminar(@PathVariable Long id) {
		materiaService.eliminar(id);
		response.setCodRetorno("0");
		response.setMensaje("Registro eliminado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
}
