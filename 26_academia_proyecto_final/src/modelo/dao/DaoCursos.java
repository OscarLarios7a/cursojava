package modelo.dao;

import java.util.List;

import entidades.Curso;

public interface DaoCursos {
	void altaCurso(Curso c);
	List<Curso> recuperarCursos();
	Curso recuperarCursoPorId(int idCurso);
	
}
