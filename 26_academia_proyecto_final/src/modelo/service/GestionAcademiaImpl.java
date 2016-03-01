package modelo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;
import modelo.dao.DaoAlumnos;
import modelo.dao.DaoCursos;
import modelo.dao.DaoMatriculas;

@Component("gacademia")
public class GestionAcademiaImpl implements GestionAcademia {

	@Autowired
	DaoAlumnos dalumnos;
	@Autowired
	DaoCursos dcursos;
	@Autowired
	DaoMatriculas dmatriculas;
	
	@Transactional
	@Override
	public boolean registrarAlumno(Alumno a) {
		if(dalumnos.recuperarAlumnoPorDni(a.getDni())!=null){
			return false;
		}else{
			dalumnos.altaAlumno(a);
			return true;
		}
	}

	@Override
	public List<Alumno> recuperarAlumnos() {
		return dalumnos.recuperarAlumnos();
	}

	@Override
	public List<Alumno> recuperarAlumnosPorCurso(int idCurso) {
		List<Matricula> matriculas = dmatriculas.recuperarMatriculasPorCurso(idCurso);
		List<Alumno> alumnos = new  ArrayList<>();
			for (Matricula m : matriculas) {
				alumnos.add(m.getAlumno());
			}
			return alumnos;
	}
	
	@Override
	public Alumno recuperarAlumnoPorDni(String dni) {
		return dalumnos.recuperarAlumnoPorDni(dni);
	}	

	@Transactional
	@Override
	public boolean registrarCurso(Curso c) {
		dcursos.altaCurso(c);
		return true;
	}

	@Override
	public List<Curso> recuperarCursos() {
		return dcursos.recuperarCursos();
	}

	@Transactional
	@Override
	public boolean registrarMatricula(Matricula m) {
		String dni=m.getAlumno().getDni();
		int idCurso=m.getCurso().getIdCurso();
		if(dmatriculas.recuperarMatriculaPorAlumnoCurso(dni, idCurso).size()>0){
			return false;
		}else{
			dmatriculas.altaMatricula(m);
			return true;	
		}
	}

	@Override
	public List<Matricula> recuperarMatriculasPorCurso(int idCurso) {
		return dmatriculas.recuperarMatriculasPorCurso(idCurso);
	}

	@Override
	public List<Matricula> recuperarMatriculasPorAlumno(String dni) {
		return dmatriculas.recuperarMatriculasPorAlumno(dni);
	}

	@Override
	public List<Matricula> recuperarMatriculas() {
		return dmatriculas.recuperarMatriculas();
	}

	@Transactional
	@Override
	public boolean introducirNota(double nota,Curso curso, Alumno alumno) {
		List<Matricula> matriculas = dmatriculas.recuperarMatriculaPorAlumnoCurso(alumno.getDni(), curso.getIdCurso());
		Matricula m = matriculas.get(0);
		m.setNota(nota);
		dmatriculas.actualizarMatricula(m);
		return true;
	}
	
	@Override
	public Curso recuperarCursoPorId(int idCurso) {		
		return dcursos.recuperarCursoPorId(idCurso);
	}

	@Override
	public List<Matricula> recuperarMatriculaPorAlumnoCurso(String dni, int idCurso) {		
		return dmatriculas.recuperarMatriculaPorAlumnoCurso(dni, idCurso);
	}


}
