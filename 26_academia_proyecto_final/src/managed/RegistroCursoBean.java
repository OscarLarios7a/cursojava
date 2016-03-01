package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import entidades.Curso;
import modelo.service.GestionAcademia;

@ManagedBean
public class RegistroCursoBean {

	private Curso curso;
	@ManagedProperty("#{gacademia}")
	GestionAcademia gacademia;

	public RegistroCursoBean() {
		curso =  new Curso();
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public GestionAcademia getGacademia() {
		return gacademia;
	}
	public void setGacademia(GestionAcademia gacademia) {
		this.gacademia = gacademia;
	}
	
	public String registrar(){		
		gacademia.registrarCurso(curso);
		return "inicio";
	}	
}
