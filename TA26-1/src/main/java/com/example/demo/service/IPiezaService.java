package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {

	//Métodos del CRUD
	public List<Pieza> listarPiezas(); //Listar All
	
	public Pieza guardarPieza(Pieza Pieza); //Guarda un Pieza CREATE
	
	public Pieza PiezaXID(Long id); //Leer datos de un Pieza READ
	
	public Pieza actualizarPieza(Pieza Pieza); //Actualiza datos del Pieza UPDATE
	
	public void eliminarPieza(Long id);//Elimina el Pieza DELETE
}
