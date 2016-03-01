package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Alumno;
import modelo.service.GestionAcademia;

@ManagedBean
public class RegistroAlumnoBean {
	
	private Alumno alumno;
	
	@ManagedProperty("#{gacademia}")
	GestionAcademia gacademia;
	
	public RegistroAlumnoBean(){
		alumno = new Alumno();
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public GestionAcademia getGacademia() {
		return gacademia;
	}

	public void setGacademia(GestionAcademia gacademia) {
		this.gacademia = gacademia;
	}
	
	public String registrar(){		
		gacademia.registrarAlumno(alumno);
		return "registroMatricula";
	}	
}
