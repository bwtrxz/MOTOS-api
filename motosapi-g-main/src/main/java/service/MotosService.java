package service;

import java.util.List;

import br.com.fiap.motosapi.data.MotosDao;
import br.com.fiap.motosapi.model.Motos;

public class MotosService {
	
	MotosDao dao = new MotosDao();
	
	public List<Motos> findAll(){
		return dao.findAll();
	}
	
	public Motos findById(long id) {
		return dao.findById(id);
	}
	
	public void delete(Motos motos) {
		//apagar do bd
	}
	
	public boolean save(Motos motos) {
		if (motos.id() == 0) return false;
		if (motos.nomeMoto().length() < 5) return false;
		if (motos.placa().length() < 7) return false;
		if (motos.ano().length() < 4) return false;
		
		//inserir no bd
		return true;	
	}
	
	public boolean update(Motos motos) {
		//atualizar no bd
		return true;
	}
}
	
	
	