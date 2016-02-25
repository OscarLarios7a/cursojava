package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cuenta;
import entidades.Movimiento;
import dao.DaoCuentas;
import dao.DaoMovimientos;

 @Component("gcajero")
 class GestionCajeroImpl implements GestionCajero {
	
	@Autowired
    DaoCuentas dcuentas;    
	@Autowired 
    DaoMovimientos dmovimientos;

	@Transactional
    @Override
	public void extraer(int codigo, double cantidad) {        
        Cuenta c=dcuentas.buscarCuentaPorCodigo(codigo);
        c.setSaldo(c.getSaldo()-cantidad);
        dcuentas.actualizarCuenta(c);
        Movimiento m=new Movimiento(0, cantidad, new Date(),c, "Extraccion");      
        dmovimientos.altaMovimiento(m);
    }

	@Transactional
    @Override
	public void ingresar(int codigo, double cantidad) {       
        Cuenta c=dcuentas.buscarCuentaPorCodigo(codigo);
        c.setSaldo(c.getSaldo()+cantidad);        
        dcuentas.actualizarCuenta(c);
        Movimiento m=new Movimiento(0,  cantidad,new Date(),c, "Ingreso");           
        dmovimientos.altaMovimiento(m);
    }

    @Override
	public boolean autenticarCuenta(int codigo) {        
        Cuenta cuenta= dcuentas.buscarCuentaPorCodigo(codigo);
        if(cuenta==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
	public List<Movimiento> obtenerMovimientos(int codigo) {      
        return dmovimientos.obtenerMovimientosDeCuenta(codigo);
    }

    @Override
	public double obtenerSaldo(int codigo) {        
        return (dcuentas.buscarCuentaPorCodigo(codigo)).getSaldo();
    }
}
