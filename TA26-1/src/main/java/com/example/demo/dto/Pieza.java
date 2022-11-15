package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="piezas")
public class Pieza {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="pieza")
	private List<Suministra> suministra;

	
	//constructores
	
	public Pieza() {
		
	}
	
	public Pieza(Long id, String nombre, List<Suministra> suministra) {
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	
	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public List<Suministra> getSuministra() {
		return suministra;
	}


	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	
	
	
	
	
}
