package modelo;

import java.util.List;

import beans.Libro;
import beans.Tema;

public interface GestionLibros {

	List<Tema> recuperarTemas();

	List<Libro> recuperarLibrosPorTema(int idTema);

	List<Libro> recuperarLibros();

}