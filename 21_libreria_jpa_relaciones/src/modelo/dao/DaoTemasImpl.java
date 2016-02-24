package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import entidades.Tema;

@Component
public class DaoTemasImpl implements DaoTemas {

	@PersistenceContext(unitName="20_libreria_PU")
	EntityManager em;
	
	@Override
	public List<Tema> recuperarTemas() {
		Query q = em.createNamedQuery("Tema.findAll");
		return (List<Tema>) q.getResultList();
	}

}
