package com.proyecto.control.escolar.controlescolar.components;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Component
@Data
public class Response {
	
	@JsonProperty("codRetorno")
	public String codRetorno;
	@JsonProperty("mensaje")
	public String mensaje;

}
