package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="suministra")
public class Suministra {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="proveedor")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name="pieza")
	private Pieza pieza;
	
	//constructores

	public Suministra() {
	}


	public Suministra(Long id, int precio, Proveedor proveedor, Pieza pieza) {
		this.id = id;
		this.precio = precio;
		this.proveedor = proveedor;
		this.pieza = pieza;
	}
	

	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Pieza getPieza() {
		return pieza;
	}


	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

}
