package com.proyecto.control.escolar.controlescolar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "maestros")
@Data
public class MaestroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	@NotBlank
	public String apellidos;
	@NotNull
	@NotBlank
	public String nombre;
	@NotNull
	public Long telefono;
	@NotNull
	@NotBlank
	@Email
	public String email;
	
}
