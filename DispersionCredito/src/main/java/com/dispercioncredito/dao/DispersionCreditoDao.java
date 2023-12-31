/**
 * 
 */
package com.dispercioncredito.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos
 */
@Repository
public class DispersionCreditoDao {

    /**
     * Objeto especializado en acceso a la BD
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void depositar(double monto, Integer meses, double pagoMensual, String rfc) {
       jdbcTemplate.execute("update personas set prestamo=" + monto +
    		   ", meses=" + meses +
    		   ", pagoMensual=" + pagoMensual + " where rfc = '" + rfc + "'");
    }
}
