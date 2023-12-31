/**
 * 
 */
package com.pagocredito.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos
 */
@Repository
public class PagoCreditoDao {

	/**
	 * Objeto especializado en acceso a la BD
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public double obtenerPagoMensual(String rfc) {
		// Sacar la calificacion de la persona recibiendo su rfc
		double pagoMensual = 0;

		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select pagoMensual from personas where rfc = '" + rfc + "'");
		if (!list.isEmpty()) {
			pagoMensual = (double) list.get(0).get("pagoMensual");
		}

		return pagoMensual;
	}

	public Integer obtenerMensualidades(String rfc) {
		// Sacar la calificacion de la persona recibiendo su rfc
		Integer meses = 0;

		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select meses from personas where rfc = '" + rfc + "'");
		if (!list.isEmpty()) {
			meses = (Integer) list.get(0).get("meses");
		}

		return meses;
	}

	public Integer obtenerPagos(String rfc) {
		// Sacar la calificacion de la persona recibiendo su rfc
		Integer meses = 0;

		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select pagosRealizados from personas where rfc = '" + rfc + "'");
		if (!list.isEmpty()) {
			meses = (Integer) list.get(0).get("pagosRealizados");
		}

		return meses;
	}

	public void pagoRealizado(String rfc, Integer contador) {
		jdbcTemplate.execute("update personas set pagosRealizados =" + contador + " where rfc = '" + rfc + "'");
	}

	public void restarBalance(String rfc, double balance) {
		jdbcTemplate.execute("update personas set prestamo =" + balance + " where rfc = '" + rfc + "'");
	}

	public void ceros(String rfc) {
		jdbcTemplate.execute(
				"update personas set prestamo = null, meses = null, pagoMensual = null, pagosRealizados = 0 where rfc = '"
						+ rfc + "'");
	}

	// Metodo para obtener el prestamos requerido por la persona
	public Double obtenerPrestamo(String rfc) {
		Double prestamo = null;

		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select prestamo from personas where rfc = '" + rfc + "'");
		if (!list.isEmpty()) {
			prestamo = (Double) list.get(0).get("prestamo");
		}

		return prestamo;
	}

}
