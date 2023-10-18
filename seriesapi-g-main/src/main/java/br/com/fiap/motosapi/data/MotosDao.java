package br.com.fiap.motosapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.motosapi.model.Motos;

public class MotosDao {
	
	List<Motos> motos = new ArrayList<>();
	
	public void MotoDao() {
		motos = List.of (
				new Motos(1, "Lost", "Um aviao cai", "http..", 1200),
				new Motos(1, "Os outros", "Só tratamento top", "http..", 1200),
				new Motos(1, "Treata", "Começa batendo", "http..", 1200)
				);
	}
	
	public List<Motos> findAll(){
		return motos;
	}
		
	public Motos findById(Long id) {
	// SELECT * FROM MOTOS WHERE ID=?
		return motos
				.stream()
				.filter(moto -> moto.id() == id)
				.findFirst()
				.orElse(null);
				
	}
}