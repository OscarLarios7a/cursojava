package modelo.dao;

import java.util.List;

import entidades.Cliente;

public interface DaoClientes {

	void altaCliente(Cliente c);
	List<Cliente> buscarCliente(String user, String pass) ;
}
