/**
 * 
 */
package com.aplicarpago.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos
 */
@Repository
public class AplciarPagoDao {

    /**
     * Objeto especializado en acceso a la BD
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer obtenerCalificacion(String rfc) {
        // Sacar la calificacion de la persona recibiendo su rfc
        Integer calificacion = null;

        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                "select calificacion from personas where rfc = '" + rfc + "'");
        if(!list.isEmpty()) {
            calificacion = (Integer) list.get(0).get("calificacion");
        }
        
        return calificacion;
    }
  
}
