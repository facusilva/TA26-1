package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

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
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl ProveedorServiceImpl;
	
	//listar todos los Proveedors
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedors(){
		return ProveedorServiceImpl.listarProveedors();
	}
	
	//guardar un Proveedor
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor Proveedor) {//los datos del Proveedor llegan en formato JSON desde el Request Body
		return ProveedorServiceImpl.guardarProveedor(Proveedor);
	}
	
	//muestro un Proveedor según el ID indicada
	@GetMapping("/proveedores/{id}") 
	public Proveedor ProveedorXID(@PathVariable(name="id") String id){ // el id del Proveedor llega desde la variable del path
		Proveedor Proveedor_xid = new Proveedor();//creo una instancia de la clase Proveedor
		
		Proveedor_xid=ProveedorServiceImpl.findById(id);//busco el Proveedor según el ID y le asigno los datos a la instancia de la clase Proveedor
		
		System.out.println("Proveedor XID: "+Proveedor_xid);
		
		return Proveedor_xid;//devuelvo el Proveedor en formato JSON
	}
	
	//Actualizo los datos de un Proveedor según el ID indicada
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")String id,@RequestBody Proveedor Proveedor) {
		
		Proveedor Proveedor_seleccionado= new Proveedor();
		Proveedor Proveedor_actualizado= new Proveedor();
		
		Proveedor_seleccionado= ProveedorServiceImpl.findById(id);
		
		Proveedor_seleccionado.setNombre(Proveedor.getNombre());
		Proveedor_seleccionado.setSuministra(Proveedor.getSuministra());
		
		Proveedor_actualizado = ProveedorServiceImpl.actualizarProveedor(Proveedor_seleccionado);
		
		System.out.println("El Proveedor actualizado es: "+ Proveedor_actualizado);
		
		return Proveedor_actualizado;
	}
	
	//borro el Proveedor indicado por el ID que llega en la variable del path
	@DeleteMapping("/proveedores/{id}")
	public void eleiminarProveedor(@PathVariable(name="id")Long id) {
		ProveedorServiceImpl.eliminarProveedor(id);
	}
}
