package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ControlCadenas {

	@After("execution(public int modelo.GestionCadenas.*(..))")
	public void logMetodo(JoinPoint jp){
		/* El método getSignature() de JoinPoint, devuelve un objeto
		   Signature que representa la firma del método donde se aplica el 
		   aspecto. Mediante getName() obtenemos su nombre.
		*/
		System.out.println("Se ejecuta " + jp.getSignature().getName());
		
	}
}
