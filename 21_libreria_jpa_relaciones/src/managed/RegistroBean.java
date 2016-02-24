package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Cliente;
import modelo.service.GestionLibreria;

@ManagedBean
public class RegistroBean {
	private Cliente cliente;

	@ManagedProperty("#{glibreria}")
	GestionLibreria glibreria;
	
	public GestionLibreria getGlibreria() {
		return glibreria;
	}
	public void setGlibreria(GestionLibreria glibreria) {
		this.glibreria = glibreria;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public RegistroBean(){
		cliente=new Cliente();
	}
	
	public String registrar(){
		
		glibreria.registrarCliente(cliente);
		return "login";
	}
}
