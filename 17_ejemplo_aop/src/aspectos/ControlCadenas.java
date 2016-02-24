package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import modelo.GestionCadenas;

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
	
	@Around("execution(public int modelo.GestionCadenas.contarCaracteres(..))")
	public int logDurante(ProceedingJoinPoint pjp) throws Throwable{
		//Obtenemos el método
		GestionCadenas gestion = (GestionCadenas) pjp.getTarget();		
		/*Si el numero de caracteres en mayor de 20 el resultado que 
		  devuelve es 0, si es menor, devuelve el control al método principal
		 */
		if(gestion.getTexto().length()<20){
			return(int)pjp.proceed();
		}else{
			return 0;			
		}		
	}
}
