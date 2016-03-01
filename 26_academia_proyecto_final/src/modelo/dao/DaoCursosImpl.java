package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Curso;

@Component
public class DaoCursosImpl implements DaoCursos {

	@PersistenceContext(unitName="26_academia_PU")
	EntityManager em;
	
	@Transactional
	@Override
	public void altaCurso(Curso c) {
		em.persist(c);
	}

	@Override
	public List<Curso> recuperarCursos() {
		Query q = em.createNamedQuery("Curso.findAll");
		return (List<Curso>) q.getResultList();
	}

	@Override
	public Curso recuperarCursoPorId(int idCurso) {
		return em.find(Curso.class, idCurso);
	}

}
