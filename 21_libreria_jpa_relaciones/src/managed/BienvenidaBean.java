package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Libro;
import entidades.Tema;
import modelo.service.GestionLibreria;

@ManagedBean
public class BienvenidaBean {
	private int temaSeleccionado;
	
	@ManagedProperty("#{glibreria}")
	GestionLibreria glibreria;
	
	public GestionLibreria getGlibreria() {
		return glibreria;
	}
	public void setGlibreria(GestionLibreria glibreria) {
		this.glibreria = glibreria;
	}
	
	public int getTemaSeleccionado() {
		return temaSeleccionado;
	}
	public void setTemaSeleccionado(int temaSeleccionado) {
		this.temaSeleccionado = temaSeleccionado;
	}
	public List<Tema> getTemas(){
		
		return glibreria.recuperarTemas();
	}
	public List<Libro> getLibros() {
		if(temaSeleccionado==0){
			return glibreria.recuperarLibros();
		}
		else{
			return glibreria.recuperarLibrosPorTema(temaSeleccionado);
		}
		
	}
	
}
