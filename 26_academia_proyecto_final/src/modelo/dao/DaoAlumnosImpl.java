package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Alumno;

@Component
public class DaoAlumnosImpl implements DaoAlumnos {

	@PersistenceContext(unitName="26_academia_PU")
	EntityManager em;
	
	@Transactional
	@Override
	public void altaAlumno(Alumno a) {
		em.persist(a);
	}

	@Override
	public List<Alumno> recuperarAlumnos() {
		Query q = em.createNamedQuery("Alumno.findAll");
		return (List<Alumno>) q.getResultList();
	}

	@Override
	public Alumno recuperarAlumnoPorDni(String dni) {
		return em.find(Alumno.class, dni);
	}

}
