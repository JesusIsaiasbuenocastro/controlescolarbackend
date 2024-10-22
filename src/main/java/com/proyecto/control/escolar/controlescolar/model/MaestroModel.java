package com.proyecto.control.escolar.controlescolar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
