package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;
import modelo.service.GestionAcademia;

@ManagedBean
public class RegistroMatriculaBean {
	
	private int cursoSeleccionado;
	private String alumnoSeleccionado;
	private String mensaje;
	
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
	
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String registrar(){		
		Matricula matricula = new Matricula(0, -1, gacademia.recuperarCursoPorId(cursoSeleccionado),
												gacademia.recuperarAlumnoPorDni(alumnoSeleccionado));
		if(gacademia.registrarMatricula(matricula)){
			return "inicio";
		}else{
			mensaje="El alumno ya está matriculado en este curso";
			return null;
		}
		
	}	
	
}
