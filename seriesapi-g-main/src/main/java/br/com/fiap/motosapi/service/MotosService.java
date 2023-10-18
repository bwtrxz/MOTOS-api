package br.com.fiap.motosapi.service;

import java.util.List;
import br.com.fiap.motosapi.data.MotosDao;
import br.com.fiap.motosapi.model.Motos;
public class MotosService {
	
	MotosDao dao = new MotosDao();

	public List<Motos> findAll() {
		return dao.findAll();
	}

	public Motos findById(Long id) {
		return dao.findById(id);
	}
}
