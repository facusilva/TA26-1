package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service 
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	IProveedorDAO iProveedorDAO;
	
	@Override
	public List<Proveedor> listarProveedors() {
		// TODO Auto-generated method stub
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor Proveedor) {
		// TODO Auto-generated method stub
			return iProveedorDAO.save(Proveedor); //guardo el nuevo Proveedor	
	}

	public Proveedor findById(String id) {
		// TODO Auto-generated method stub
		return iProveedorDAO.findById(id);
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor Proveedor) {
		// TODO Auto-generated method stub
		return iProveedorDAO.save(Proveedor);
	}

	@Override
	public void eliminarProveedor(Long id) {
		iProveedorDAO.deleteById(id);
		
	}

}
