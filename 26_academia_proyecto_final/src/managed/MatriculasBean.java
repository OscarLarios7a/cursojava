package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;
import modelo.service.GestionAcademia;

@ManagedBean
public class MatriculasBean {
	private int cursoSeleccionado;
	private String alumnoSeleccionado;
	
	@ManagedProperty("#{gacademia}")
	GestionAcademia gacademia;

	public int getCursoSeleccionado() {
		return cursoSeleccionado;
	}

	public void setCursoSeleccionado(int cursoSeleccionado) {
		this.cursoSeleccionado = cursoSeleccionado;
	}

	public String getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}

	public void setAlumnoSeleccionado(String alumnoSeleccionado) {
		this.alumnoSeleccionado = alumnoSeleccionado;
	}

	public GestionAcademia getGacademia() {
		return gacademia;
	}

	public void setGacademia(GestionAcademia gacademia) {
		this.gacademia = gacademia;
	}
	
	public List<Curso> getCursos(){
		return gacademia.recuperarCursos();
	}
	
	public List<Alumno> getAlumnos(){
		return gacademia.recuperarAlumnos();
	}

	public List<Matricula> getMatriculasAlumnos(){
	    if(alumnoSeleccionado==null||alumnoSeleccionado.equals("0")){
			return null;
			
		}else{		
			return gacademia.recuperarMatriculasPorAlumno(alumnoSeleccionado);
			
		}
	}	
	
	public List<Matricula> getMatriculasCursos(){
		if(cursoSeleccionado==0){
			return null;
		}else{
			return gacademia.recuperarMatriculasPorCurso(cursoSeleccionado);
		}
	}
	

}
