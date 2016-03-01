package modelo.service;

import java.util.List;

import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;

public interface GestionAcademia {

	boolean registrarAlumno(Alumno a);
	List<Alumno> recuperarAlumnos();
	List<Alumno> recuperarAlumnosPorCurso(int idCurso);
	Alumno recuperarAlumnoPorDni(String dni);
	boolean registrarCurso(Curso c);
	List<Curso> recuperarCursos();
	Curso recuperarCursoPorId(int idCurso);	
	boolean registrarMatricula(Matricula m);
	List<Matricula> recuperarMatriculasPorCurso(int idCurso);
	List<Matricula> recuperarMatriculasPorAlumno(String dni);
	List<Matricula> recuperarMatriculas();
	boolean introducirNota(double nota,Curso curso, Alumno alumno);
	List<Matricula> recuperarMatriculaPorAlumnoCurso(String dni, int idCurso);	
}
