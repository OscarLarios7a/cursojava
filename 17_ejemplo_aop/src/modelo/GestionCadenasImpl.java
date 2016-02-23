package modelo;

public class GestionCadenasImpl implements GestionCadenas{

	private String texto;
	
	@Override
	public void setTexto(String cad) {
		texto=cad;
		
	}

	@Override
	public String getTexto() {		
		return texto;
	}

	@Override
	public int contarCaracteres() {		
		return texto.length();
	}

	@Override
	public int contarVocales() {
		int total = 0;
		for (int i=0;i<texto.length();i++){
			switch (texto.toLowerCase().charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				total++;
				break;
			}
		}
		return total;
	}

}
