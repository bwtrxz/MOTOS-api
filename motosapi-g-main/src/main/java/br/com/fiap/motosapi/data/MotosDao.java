package br.com.fiap.motosapi.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connectionFactory.ConnectionFactory;
import br.com.fiap.motosapi.model.Motos;


public class MotosDao {

    private Connection conexao;

    public MotosDao() throws SQLException {
    	 conexao = ConnectionFactory.getConnection();
    }
    
    List <Motos> motos = new ArrayList<>();

    public void insert(Motos moto) throws SQLException {
        String sql = "INSERT INTO MOTOS (marca, placa, ano, cilindradas) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, moto.id());
            statement.setString(2, moto.nomeMoto());
            statement.setString(3, moto.placa());
            statement.setString(4, moto.ano());
            statement.setInt(5, moto.valor());
            statement.executeUpdate();
        }
    }

    public void update(Motos moto) throws SQLException {
        String sql = "UPDATE MOTOS SET marca=?, placa=?, ano=?, cilindradas=? WHERE id=?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
        	 statement.setInt(1, moto.id());
             statement.setString(2, moto.nomeMoto());
             statement.setString(3, moto.placa());
             statement.setString(4, moto.ano());
             statement.setInt(5, moto.valor());
            statement.executeUpdate();
        }
    }

    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM MOTOS WHERE id=?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

	public List<Motos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Motos findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
