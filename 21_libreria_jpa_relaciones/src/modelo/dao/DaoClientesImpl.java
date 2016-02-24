package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cliente;

@Component
public class DaoClientesImpl implements DaoClientes {

	@PersistenceContext(unitName="21_libreria_PU")
	EntityManager em;
	
	@Transactional
	@Override
	public void altaCliente(Cliente c) {
		em.persist(c);
	}

	@Override
	public List<Cliente> buscarCliente(String user, String pass) {	
		Query q=em.createNamedQuery("Cliente.FindCliente");
        q.setParameter(1, user);
        q.setParameter(2, pass);
        return (List<Cliente>)q.getResultList();
	}

}
