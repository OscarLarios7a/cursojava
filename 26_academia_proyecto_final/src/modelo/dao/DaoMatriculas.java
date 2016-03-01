package modelo.dao;

import java.util.List;

import entidades.Matricula;

public interface DaoMatriculas {
	void altaMatricula(Matricula m);
	List<Matricula> recuperarMatriculas();
	List<Matricula> recuperarMatriculasPorCurso(int idCurso);
	List<Matricula> recuperarMatriculasPorAlumno(String dni);
	void actualizarMatricula (Matricula m);
	List<Matricula> recuperarMatriculaPorAlumnoCurso(String dni, int idCurso);	
}
