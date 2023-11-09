package service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.motosapi.data.MotosDao;
import br.com.fiap.motosapi.model.Motos;

public class MotosService {
    
    private MotosDao dao;

    public MotosService() {
        try {
			this.dao = new MotosDao();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }

    public List<Motos> findAll() throws SQLException {
        return dao.findAll();
    }

    public Motos findById(long id) throws SQLException {
        return dao.findById(id);
    }

    public void delete(long id) throws SQLException {
        dao.delete(id);
    }

    public boolean save(Motos motos) throws SQLException {
        if (motos.nomeMoto().length() < 5) return false;
        if (motos.placa().length() < 7) return false;
        if (motos.ano().length() < 4) return false;

        dao.insert(motos);
        return true;
    }

    public boolean update(Motos motos) throws SQLException {
        dao.update(motos);
        return true;
    }

	public Object findById() {
		// TODO Auto-generated method stub
		return null;
	}
}
