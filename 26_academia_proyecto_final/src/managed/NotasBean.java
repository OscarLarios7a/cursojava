package managed;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.AjaxBehaviorEvent;

import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;
import modelo.service.GestionAcademia;

@ManagedBean
public class NotasBean {
	private int cursoSeleccionado;
	private String alumnoSeleccionado;
	private double nota;
	
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

	public double getNota() {

			return nota;
		
	}

	public void setNota(double nota) {
		this.nota=nota;
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
		if(cursoSeleccionado!=0){
			return gacademia.recuperarAlumnosPorCurso(cursoSeleccionado);
		}else{
			return gacademia.recuperarAlumnos();
		}		
	}
	
	public String registrarNota(){
		Curso curso = gacademia.recuperarCursoPorId(cursoSeleccionado);		
		Alumno alumno = gacademia.recuperarAlumnoPorDni(alumnoSeleccionado);
		gacademia.introducirNota(nota,curso,alumno);	
		return null;
	}	
	
	public void mostrarNota(AjaxBehaviorEvent event){
		ArrayList<Matricula> m = (ArrayList<Matricula>) gacademia.recuperarMatriculaPorAlumnoCurso(alumnoSeleccionado, cursoSeleccionado);
		if(m.size()>0){
			this.nota = m.get(0).getNota();
		}	
	}
}
