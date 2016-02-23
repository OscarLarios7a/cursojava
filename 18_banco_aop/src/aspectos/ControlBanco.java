package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControlBanco {
	int ing, ext;
	
	@Before("execution(* modelo.service.GestionCajero.ingresar(..))")
	public void logIngreso(JoinPoint jp){
		ing++;
		System.out.println("Ingresos: "+ing);
	}
	@Before("execution(* modelo.service.GestionCajero.extraer(..))")
	public void logExtraer(JoinPoint jp){
		ext++;
		System.out.println("Extracciones: "+ext);
	}
	
}
