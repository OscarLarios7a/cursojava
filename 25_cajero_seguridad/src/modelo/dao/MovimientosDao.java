/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Movimiento;
import java.util.List;

/**
 *
 * @author Tarde
 */
public interface MovimientosDao {
   void altaMovimiento(Movimiento m);
    List<Movimiento> obtenerMovimentosDeCuenta(int codigo); 
}
