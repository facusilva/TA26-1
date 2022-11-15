package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service 
public class PiezaServiceImpl implements IPiezaService{

	@Autowired
	IPiezaDAO iPiezaDAO;
	
	@Override
	public List<Pieza> listarPiezas() {
		// TODO Auto-generated method stub
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza Pieza) {
		// TODO Auto-generated method stub
			return iPiezaDAO.save(Pieza); //guardo el nuevo Pieza	
	}

	@Override
	public Pieza PiezaXID(Long id) {
		// TODO Auto-generated method stub
		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza Pieza) {
		// TODO Auto-generated method stub
		return iPiezaDAO.save(Pieza);
	}

	@Override
	public void eliminarPieza(Long id) {
		iPiezaDAO.deleteById(id);
		
	}

}
