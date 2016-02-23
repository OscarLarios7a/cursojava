/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.service.GestionCajero;

@ManagedBean
@SessionScoped
public class ValidacionBean {
    private int codigoCuenta;
    
   	@ManagedProperty("#{gcajero}")
       GestionCajero gcajero;

       public GestionCajero getGcajero() {
   		return gcajero;
   	}

   	public void setGcajero(GestionCajero gcajero) {
   		this.gcajero = gcajero;
   	}
   	
    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
    
    public String validar(){        
        if(gcajero.autenticarCuenta(codigoCuenta)){
            return "operaciones";
        }
        else{
            return null;
        }
    }
    
}
