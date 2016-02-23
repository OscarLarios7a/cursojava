package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import modelo.service.GestionLibreria;

@ManagedBean(name="loginBean")
public class LoginBean {
	private String usuario;
	private String password;
	private String error;
	
	@ManagedProperty("#{glibreria}")
	GestionLibreria glibreria;
	
	public GestionLibreria getGlibreria() {
		return glibreria;
	}
	public void setGlibreria(GestionLibreria glibreria) {
		this.glibreria = glibreria;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validar(){		
		if(glibreria.autenticarCliente(usuario, password)){			
			return "bienvenida";
		}else{
			error="Datos no validos!!";
			return null;
		}
	}
}
