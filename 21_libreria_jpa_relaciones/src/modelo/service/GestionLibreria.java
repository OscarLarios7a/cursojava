package modelo.service;

import java.util.List;

import entidades.Cliente;
import entidades.Libro;
import entidades.Tema;

public interface GestionLibreria {
	
	boolean registrarCliente(Cliente c);
	boolean autenticarCliente(String user, String pwd);
	List<Tema> recuperarTemas();
	List<Libro> recuperarLibrosPorTema(int idTema);
	List<Libro> recuperarLibros();
}
