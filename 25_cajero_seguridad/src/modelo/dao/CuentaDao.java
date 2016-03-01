/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import entidades.Cuenta;

/**
 *
 * @author Tarde
 */
public interface CuentaDao {
    void altaCuenta(Cuenta c);
    Cuenta buscarCuentaPorCodigo(int codigo);
    void actualizarCuenta(Cuenta c);
}
