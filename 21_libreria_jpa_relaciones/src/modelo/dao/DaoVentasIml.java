package modelo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import entidades.Venta;

@Component
public class DaoVentasIml implements DaoVentas {

	@PersistenceContext(unitName="21_libreria_PU")
	EntityManager em;
	
	@Override
	public List<Venta> recuperarVentas() {
		Query q = em.createNamedQuery("Venta.findAll");
		return (List<Venta>) q.getResultList();
	}

	@Override
	public List<Venta> recuperarVentasFechas(Date fechaIni, Date fechaFin) {
		String jpql = "Select v from Venta v where v.fecha between ? and ?";
		Query q = em.createQuery(jpql);
		q.setParameter(1, fechaIni);
		q.setParameter(2, fechaFin);
		return (List<Venta>) q.getResultList();
	}

}
