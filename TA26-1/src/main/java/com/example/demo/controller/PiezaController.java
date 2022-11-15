package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl PiezaServiceImpl;
	
	//listar todos los Piezas
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return PiezaServiceImpl.listarPiezas();
	}
	
	//guardar un Pieza
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza Pieza) {//los datos del Pieza llegan en formato JSON desde el Request Body
		return PiezaServiceImpl.guardarPieza(Pieza);
	}
	
	//muestro un Pieza según el ID indicada
	@GetMapping("/piezas/{id}") 
	public Pieza PiezaXID(@PathVariable(name="id") Long id){ // el id del Pieza llega desde la variable del path
		Pieza Pieza_xid = new Pieza();//creo una instancia de la clase Pieza
		
		Pieza_xid=PiezaServiceImpl.PiezaXID(id);//busco el Pieza según el ID y le asigno los datos a la instancia de la clase Pieza
		
		System.out.println("Pieza XID: "+Pieza_xid);
		
		return Pieza_xid;//devuelvo el Pieza en formato JSON
	}
	
	//Actualizo los datos de un Pieza según el ID indicada
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")Long id,@RequestBody Pieza Pieza) {
		
		Pieza Pieza_seleccionado= new Pieza();
		Pieza Pieza_actualizado= new Pieza();
		
		Pieza_seleccionado= PiezaServiceImpl.PiezaXID(id);
		
		Pieza_seleccionado.setNombre(Pieza.getNombre());
		Pieza_seleccionado.setSuministra(Pieza.getSuministra());
		
		Pieza_actualizado = PiezaServiceImpl.actualizarPieza(Pieza_seleccionado);
		
		System.out.println("El Pieza actualizado es: "+ Pieza_actualizado);
		
		return Pieza_actualizado;
	}
	
	//borro el Pieza indicado por el ID que llega en la variable del path
	@DeleteMapping("/piezas/{id}")
	public void eleiminarPieza(@PathVariable(name="id")Long id) {
		PiezaServiceImpl.eliminarPieza(id);
	}
}
