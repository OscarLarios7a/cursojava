package modelo;

import beans.Cliente;

public interface GestionClientes {

	boolean registrarCliente(Cliente c);

	boolean estaRegistrado(String user, String pwd);

}