package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cuenta;
import entidades.Movimiento;

 @Component
 class DaoMovimientosImpl implements DaoMovimientos {

	@PersistenceContext(unitName="14_banco_PU")
	EntityManager em;
		
	@Transactional
	@Override
	public void altaMovimiento(Movimiento m) {
        em.persist(m);        
    }
	
    @Override
	public List<Movimiento> obtenerMovimientosDeCuenta(int codigo) {
/*        Query q=em.createNamedQuery("Movimiento.FindByCuenta");
        q.setParameter(1, codigo);
        return (List<Movimiento>)q.getResultList();*/
    	Cuenta c = em.find(Cuenta.class, codigo);
    	return c.getMovimientos();
    }
}
