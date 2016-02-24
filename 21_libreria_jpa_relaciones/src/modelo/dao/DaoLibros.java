package modelo.dao;

import java.util.List;

import entidades.Libro;

public interface DaoLibros {

	List<Libro> recuperarLibros();
	List<Libro> recuperarLibrosPorTema(int idTema);
}
