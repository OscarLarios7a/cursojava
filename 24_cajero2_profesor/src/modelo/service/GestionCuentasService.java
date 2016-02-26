/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import entidades.Cuenta;
import entidades.Movimiento;
import java.util.List;

/**
 *
 * @author Tarde
 */
public interface GestionCuentasService {
    void extraer(int codigo, double cantidad);

    void ingresar(int codigo, double cantidad);

    Cuenta obtenerCuenta(int codigo);

    List<Movimiento> obtenerMovimientos(int codigo);

    double obtenerSaldo(int codigo);

}
