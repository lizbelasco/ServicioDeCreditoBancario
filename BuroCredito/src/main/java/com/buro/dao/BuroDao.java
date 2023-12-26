/**
 * 
 */
package com.buro.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos
 */
@Repository
public class BuroDao {

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
    
    public boolean prestamoActivo(String rfc) {
        // Sacar la calificacion de la persona recibiendo su rfc
        boolean prestamoActivo = false;

        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                "select prestamo from personas where rfc = '" + rfc + "'");
        
        if(list.get(0).get("prestamo") == null) {
        	prestamoActivo = false;
        }else {
        	prestamoActivo = true;
        }
        
        return prestamoActivo;
    }
  
}
