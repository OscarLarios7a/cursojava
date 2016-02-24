package modelo.dao;

import java.util.Date;
import java.util.List;

import entidades.Venta;


public interface DaoVentas {

	List<Venta> recuperarVentas();
	List<Venta> recuperarVentasFechas(Date fechaIni,Date fechaFin);
}
