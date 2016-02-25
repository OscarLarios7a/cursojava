package beans;

public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private int idTema;
	public Libro(String autor, int idTema, int isbn, int paginas,
			double precio, String titulo) {
		super();
		this.autor = autor;
		this.idTema = idTema;
		this.isbn = isbn;
		this.paginas = paginas;
		this.precio = precio;
		this.titulo = titulo;
	}
	public Libro() {
		super();
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
}

