package modelo;





import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import beans.Libro;
import beans.Tema;
import mapeadores.MapeadorLibro;
import mapeadores.MapeadorTema;

@Component("glibros")
public class GestionLibrosImpl implements GestionLibros {
	

	@Autowired 
	JdbcTemplate jt;
	@Override
	public List<Tema> recuperarTemas() {
		String sql="SELECT * FROM TEMAS";
		return jt.query(sql, new MapeadorTema());
		
	}
	/* (non-Javadoc)
	 * @see modelo.GestionLibros#recuperarLibrosPorTema(int)
	 */
	@Override
	public List<Libro> recuperarLibrosPorTema(int idTema) {
		String sql="select * from libros where idTema=?";
		return jt.query(sql, new MapeadorLibro(),idTema);
	}

	
	/* (non-Javadoc)
	 * @see modelo.GestionLibros#recuperarLibros()
	 */
	@Override
	public List<Libro> recuperarLibros() {
		String sql="select * from libros";
		return jt.query(sql, new MapeadorLibro());
		
	}
	


}
