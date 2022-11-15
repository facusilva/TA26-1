package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="proveedores")
public class Proveedor {

	//atributos de la entidad
	@Id
	private String id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="proveedor")
	private List<Suministra> suministra;

	
	//constructores
	
	public Proveedor() {
		
	}
	
	public Proveedor(String id, String nombre, List<Suministra> suministra) {
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	
	//getters y setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	public List<Suministra> getSuministra() {
		return suministra;
	}


	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	
	
	
	
	
}
