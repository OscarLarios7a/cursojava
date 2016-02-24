package modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cliente;
import entidades.Libro;
import entidades.Tema;
import entidades.Venta;
import modelo.dao.DaoClientes;
import modelo.dao.DaoLibros;
import modelo.dao.DaoTemas;
import modelo.dao.DaoVentas;

@Component("glibreria")
public class GestionLibreriaImpl implements GestionLibreria {
	
	@Autowired
	DaoClientes dclientes;
	@Autowired
	DaoLibros dlibros;
	@Autowired
	DaoTemas dtemas;
	@Autowired
	DaoVentas dventas;

	@Transactional
	@Override
	public boolean registrarCliente(Cliente c) {
		if(dclientes.buscarCliente(c.getUsuario(), c.getPassword())!=null){
			return false;
		}else{
			dclientes.altaCliente(c);
			return true;
		}
	}

	@Override
	public boolean autenticarCliente(String user, String pwd) {
		List<Cliente> clientes = dclientes.buscarCliente(user, pwd);
        if(clientes.size()>0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public List<Tema> recuperarTemas() {
		return dtemas.recuperarTemas();
	}

	@Override
	public List<Libro> recuperarLibrosPorTema(int idTema) {
		return dlibros.recuperarLibrosPorTema(idTema);
	}

	@Override
	public List<Libro> recuperarLibros() {
		return dlibros.recuperarLibros();
	}

	@Override
	public List<Venta> recuperarVentasFechas(Date fechaIni, Date fechaFin) {
		return dventas.recuperarVentasFechas(fechaIni, fechaFin);
	}

	@Override
	public List<Venta> recuperarVentas() {
		return dventas.recuperarVentas();
	}

}
