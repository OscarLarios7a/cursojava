package beans;

public class Tema { 
	private int id;
	private String tema;
	
	public Tema(int id, String tema) {
		this.id = id;
		this.tema = tema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
}


