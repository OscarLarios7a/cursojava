package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the temas database table.
 * 
 */
@Entity
@Table(name="temas")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idtema;

	private String tema;

	//bi-directional many-to-one association to Libro
	@OneToMany(mappedBy="tema", fetch=FetchType.EAGER)
	private List<Libro> libros;

	public Tema() {
	}

	public Integer getIdtema() {
		return this.idtema;
	}

	public void setIdtema(Integer idtema) {
		this.idtema = idtema;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro addLibro(Libro libro) {
		getLibros().add(libro);
		libro.setTema(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setTema(null);

		return libro;
	}

}