package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import beans.Tema;

public class MapeadorTema implements RowMapper<Tema> {

	@Override
	public Tema mapRow(ResultSet arg0, int arg1) throws SQLException {
		return new Tema(arg0.getInt("idTema"), arg0.getString("tema"));
	}

}
