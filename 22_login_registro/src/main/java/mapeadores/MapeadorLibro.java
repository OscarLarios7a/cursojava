package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import beans.Libro;

public class MapeadorLibro implements RowMapper<Libro> {
	public Libro mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		return new Libro(arg0.getString("autor"), arg0.getInt("idTema"), arg0.getInt("isbn"), 
				arg0.getInt("paginas"), arg0.getDouble("precio"), arg0.getString("titulo"));
	}
}
