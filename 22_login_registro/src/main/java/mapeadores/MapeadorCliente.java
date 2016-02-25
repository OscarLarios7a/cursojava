package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import beans.Cliente;

public class MapeadorCliente implements RowMapper<Cliente>{
	public Cliente mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		return new Cliente(arg0.getInt("idCliente"), arg0.getString("usuario"),
				arg0.getString("password"), arg0.getString("email"), arg0.getInt("telefono"));
	}
}
