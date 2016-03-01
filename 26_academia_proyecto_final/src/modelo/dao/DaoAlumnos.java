package modelo.dao;

import java.util.List;

import entidades.Alumno;

public interface DaoAlumnos {
	void altaAlumno(Alumno a);
	List<Alumno> recuperarAlumnos();
	Alumno recuperarAlumnoPorDni(String dni);
}
