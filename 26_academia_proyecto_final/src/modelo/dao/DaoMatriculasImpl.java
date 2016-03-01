package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;

@Component
public class DaoMatriculasImpl implements DaoMatriculas {

	@PersistenceContext(unitName="26_academia_PU")
	EntityManager em;
	
	@Transactional
	@Override
	public void altaMatricula(Matricula m) {
		em.persist(m);
	}

	@Override
	public List<Matricula> recuperarMatriculas() {
		Query q = em.createNamedQuery("Matricula.findAll");
		return (List<Matricula>) q.getResultList();
	}

	@Override
	public List<Matricula> recuperarMatriculasPorCurso(int idCurso) {
		Curso curso = em.find(Curso.class, idCurso);
		return curso.getMatriculas();
	}

	@Override
	public List<Matricula> recuperarMatriculasPorAlumno(String dni) {
		Alumno alumno = em.find(Alumno.class, dni);
		return alumno.getMatriculas();
	}

	@Transactional
	@Override
	public void actualizarMatricula(Matricula m) {
		em.merge(m);
	}

	@Override
	public List<Matricula> recuperarMatriculaPorAlumnoCurso(String dni, int idCurso) {
		String jpql = "Select m from Matricula m where m.alumno.dni=?1 and m.curso.idCurso=?2";
		Query q = em.createQuery(jpql);
		q.setParameter(1, dni);
		q.setParameter(2, idCurso);
		return (List<Matricula>) q.getResultList();
	}

}
