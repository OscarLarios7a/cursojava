package managed;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Venta;
import modelo.service.GestionLibreria;

@ManagedBean
public class VentasBean {
	private Date fechaIni;
	private Date fechaFin;

	@ManagedProperty("#{glibreria}")
	GestionLibreria glibreria;
	
	public GestionLibreria getGlibreria() {
		return glibreria;
	}
	public void setGlibreria(GestionLibreria glibreria) {
		this.glibreria = glibreria;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public List<Venta> getVentas() {		
		if(fechaIni==null && fechaFin==null){
			return glibreria.recuperarVentas();
		}
		else{
			return glibreria.recuperarVentasFechas(fechaIni, fechaFin);
		}
	}
}

