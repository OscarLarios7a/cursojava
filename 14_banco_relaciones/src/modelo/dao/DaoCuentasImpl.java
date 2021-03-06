package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cuenta;

@Component
 class DaoCuentasImpl implements DaoCuentas { 
	
	@PersistenceContext(unitName="14_banco_PU")
	EntityManager em;
	
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
