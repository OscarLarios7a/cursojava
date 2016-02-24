package modelo.dao;

import java.util.Date;
import java.util.List;

import entidades.Venta;


public interface DaoVentas {

	List<Venta> recuperarentas();
	List<Venta> recuperarentasFechas(Date fechaIni,Date fechaFin);
}
