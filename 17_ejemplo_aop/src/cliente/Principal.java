package cliente;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.GestionCadenas;

public class Principal {
	public static void main(String[] args) {
		//Iniciamos Spring
		BeanFactory factory = (BeanFactory) new ClassPathXmlApplicationContext("17config.xml");
		//Solicitamos una implementación de GestionCadenas
		GestionCadenas g = (GestionCadenas) factory.getBean("gcadenas");
		//Utilizamos el objeto
		System.out.println("Caracteres: " + g.contarCaracteres());
		System.out.println("Vocales: " + g.contarVocales());		
	}
}
