package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

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
public class SuministraController {

	@Autowired
	SuministraServiceImpl SuministraServiceImpl;
	
	//listar todos los Suministras
	@GetMapping("/suministran")
	public List<Suministra> listarSuministras(){
		return SuministraServiceImpl.listarSuministras();
	}
	
	//guardar un Suministra
	@PostMapping("/suministran")
	public Suministra salvarSuministra(@RequestBody Suministra Suministra) {//los datos del Suministra llegan en formato JSON desde el Request Body
		return SuministraServiceImpl.guardarSuministra(Suministra);
	}
	
	//muestro un Suministra según el ID indicada
	@GetMapping("/suministran/{id}") 
	public Suministra SuministraXID(@PathVariable(name="id") Long id){ // el id del Suministra llega desde la variable del path
		Suministra Suministra_xid = new Suministra();//creo una instancia de la clase Suministra
		
		Suministra_xid=SuministraServiceImpl.SuministraXID(id);//busco el Suministra según el ID y le asigno los datos a la instancia de la clase Suministra
		
		System.out.println("Suministra XID: "+Suministra_xid);
		
		return Suministra_xid;//devuelvo el Suministra en formato JSON
	}
	
	//Actualizo los datos de un Suministra según el ID indicada
	@PutMapping("/suministran/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")Long id,@RequestBody Suministra Suministra) {
		
		Suministra Suministra_seleccionado= new Suministra();
		Suministra Suministra_actualizado= new Suministra();
		
		Suministra_seleccionado= SuministraServiceImpl.SuministraXID(id);
		
		Suministra_seleccionado.setPrecio(Suministra.getPrecio());
		Suministra_seleccionado.setPieza(Suministra.getPieza());
		Suministra_seleccionado.setProveedor(Suministra.getProveedor());
		
		Suministra_actualizado = SuministraServiceImpl.actualizarSuministra(Suministra_seleccionado);
		
		System.out.println("El Suministra actualizado es: "+ Suministra_actualizado);
		
		return Suministra_actualizado;
	}
	
	//borro el Suministra indicado por el ID que llega en la variable del path
	@DeleteMapping("/suministran/{id}")
	public void eleiminarSuministra(@PathVariable(name="id")Long id) {
		SuministraServiceImpl.eliminarSuministra(id);
	}
}
