/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cuenta;
import entidades.Movimiento;
import modelo.dao.CuentaDao;
import modelo.dao.MovimientosDao;

/**
 *
 * @author Tarde
 */
@Component(value = "gcuentas")
public class GestionCuentasServiceImpl implements GestionCuentasService{
	@Autowired
	CuentaDao cuenta;
	@Autowired
	MovimientosDao movimientos;
    @Transactional
	@Override
    public void extraer(int codigo, double cantidad) {
        
       
        Cuenta c=cuenta.buscarCuentaPorCodigo(codigo);
        c.setSaldo(c.getSaldo()-cantidad);
        cuenta.actualizarCuenta(c);
        Movimiento m=new Movimiento(0, cantidad, new Date(),c.getNumerocuenta(), "Extracción");      
       
        movimientos.altaMovimiento(m);
    }
    @Transactional
    @Override
    public void ingresar(int codigo, double cantidad) {
        
        Cuenta c=cuenta.buscarCuentaPorCodigo(codigo);
        c.setSaldo(c.getSaldo()+cantidad);
        cuenta.actualizarCuenta(c);
        Movimiento m=new Movimiento(0, cantidad, new Date(),c.getNumerocuenta(), "Ingreso");          
        movimientos.altaMovimiento(m);
    }

    @Override
    public Cuenta obtenerCuenta(int codigo) {
       
        return cuenta.buscarCuentaPorCodigo(codigo);
    }

    @Override
    public List<Movimiento> obtenerMovimientos(int codigo) {
        
        return movimientos.obtenerMovimentosDeCuenta(codigo);
    }

    @Override
    public double obtenerSaldo(int codigo) {
        
        return (cuenta.buscarCuentaPorCodigo(codigo)).getSaldo();
    }
    
}
