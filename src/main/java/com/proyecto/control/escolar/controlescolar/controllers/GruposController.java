package com.proyecto.control.escolar.controlescolar.controllers;

import java.util.List;

import jakarta.validation.Valid;

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
import com.proyecto.control.escolar.controlescolar.components.grupos.ResponseGrupo;
import com.proyecto.control.escolar.controlescolar.components.grupos.ResponseGrupos;
import com.proyecto.control.escolar.controlescolar.model.GrupoModel;
import com.proyecto.control.escolar.controlescolar.service.GrupoService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class GruposController {
	
	@Autowired
	Response response ;
	
	@Autowired
	ResponseGrupos responseGrupos;
	
	@Autowired
	ResponseGrupo responseGrupo;
	
	@Autowired
	GrupoService grupoService;
	
	
	@GetMapping("/grupo")
	public ResponseEntity<ResponseGrupos> obtenerTodo() {
		HttpStatus httpStatus;
		try {
			List<GrupoModel> grupos = grupoService.obtener();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (grupos.size() > 0 ) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseGrupos.setListaGrupos(grupos);
			responseGrupos.setResponse(response);
			httpStatus = HttpStatus.OK;			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			responseGrupos.setResponse(response);
			httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseGrupos,httpStatus);
	}
	@GetMapping("/grupo/{id}")
	public ResponseEntity<ResponseGrupo> obtenerPorId(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			GrupoModel grupoModel = grupoService.obtenerById(id).get();
			//Validar que si existan grupos mandar el mensaje correspondiente 
			if (grupoModel != null) {
				response.setCodRetorno("0");
				response.setMensaje("Consulta exitosa");
			}else {
				response.setCodRetorno("1");
				response.setMensaje("No existen registros");
			}
			responseGrupo.setGrupoModel(grupoModel);
			responseGrupo.setRespose(response);
			httpStatus = HttpStatus.OK;
			
			
		} catch (Exception e) {
			response.setCodRetorno("-1");
			response.setMensaje(e.getMessage());
			responseGrupo.setRespose(response);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(responseGrupo,httpStatus);
	}
	@PostMapping("/grupo")
	public ResponseEntity<Response> guardar(@Valid @RequestBody GrupoModel grupoModel) {
		HttpStatus httpStatus;
		try {
			//validar que no exista otro registro con el mismo nombre 
			List<GrupoModel> grupos = grupoService.obtener();
			
			for(GrupoModel grupo : grupos) {
				if(grupo.getDescripcion().equals(grupoModel.getDescripcion())) {
					throw new Exception ("El nombre del grupo ya existe");
				}
			}
			
			grupoService.guardar(grupoModel);
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
	@PutMapping("/grupo/{id}")
	public  ResponseEntity<Response> actualizar(@PathVariable Long id ,@RequestBody GrupoModel grupo ) {
		HttpStatus httpStatus;
		try {
			grupoService.actualizar(id, grupo);
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
	@DeleteMapping("/grupo/{id}")
	public  ResponseEntity<Response> eliminar(@PathVariable Long id) {
		HttpStatus httpStatus;
		try {
			grupoService.eliminar(id);
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
