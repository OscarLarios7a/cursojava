/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Cuenta;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CuentaDaoImpl implements CuentaDao {
    @PersistenceContext(unitName="24_cajero2_PU")
	EntityManager em;
    
    @Transactional
    @Override
    public void altaCuenta(Cuenta c) {
      em.persist(c);     
    }

    @Override
    public Cuenta buscarCuentaPorCodigo(int codigo) {
        Cuenta c=em.find(Cuenta.class, codigo);
        return c;
    }

    @Transactional
    @Override
    public void actualizarCuenta(Cuenta c) {
        em.merge(c);

    }
    
}
