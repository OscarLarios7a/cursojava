package modelo.service;

import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.Libro;
import entidades.Tema;
import entidades.Venta;

public interface GestionLibreria {
	
	boolean registrarCliente(Cliente c);
	boolean autenticarCliente(String user, String pwd);
	List<Tema> recuperarTemas();
	List<Libro> recuperarLibrosPorTema(int idTema);
	List<Libro> recuperarLibros();
	List<Venta> recuperarVentasFechas(Date fechaIni,Date fechaFin);
	List<Venta> recuperarVentas();
}
