package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import entidades.Libro;
import entidades.Tema;

@Component
public class DaoLibrosImpl implements DaoLibros {

	@PersistenceContext(unitName="21_libreria_PU")
	EntityManager em;
	
	@Override
	public List<Libro> recuperarLibros() {
		Query q = em.createNamedQuery("Libro.findAll");
		return (List<Libro>) q.getResultList();
	}

	@Override
	public List<Libro> recuperarLibrosPorTema(int idTema) {
		Tema t = em.find(Tema.class, idTema);
		return t.getLibros();
	}

}
