/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Movimiento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MovimientosDaoImpl implements MovimientosDao{
    @PersistenceContext(unitName="24_cajero2_PU")
	EntityManager em;
	
	@Transactional
    @Override
    public void altaMovimiento(Movimiento m) {      
        em.persist(m);
    }

    @Override
    public List<Movimiento> obtenerMovimentosDeCuenta(int codigo) {
        Query q=em.createNamedQuery("Movimiento.FindByCuenta");
        q.setParameter(1, codigo);
        return q.getResultList();
    }
    
}
