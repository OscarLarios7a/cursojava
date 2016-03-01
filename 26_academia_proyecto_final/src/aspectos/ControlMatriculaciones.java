package aspectos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import entidades.Matricula;

@Aspect
public class ControlMatriculaciones {
	private String ruta = "c:\\temporal\\matriculaciones.txt";
	
	@Around("execution(public boolean modelo.service.GestionAcademia.registrarMatricula(..))")
	public boolean logMetodo(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args=pjp.getArgs();
		Matricula m = (Matricula) args[0];	
		boolean valorRetorno = (boolean) pjp.proceed();		
		if(valorRetorno){
			agregar(m.getAlumno().getNombre(), m.getAlumno().getDni(), m.getCurso().getNombre(), new Date());
			return true;
		}	else{
			return false;
		}

	}
	
    private void agregar(String alumno,String dni, String curso, Date fecha) {
        String cadena = alumno + "|" + dni + "|" + curso+ "|" + fecha;
        try (FileOutputStream fo = new FileOutputStream(ruta, true);
                PrintStream out = new PrintStream(fo);) {
            out.println(cadena);
            out.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
}
