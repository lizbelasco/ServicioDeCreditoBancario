/**
 * 
 */
package com.buro.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buro.dao.BuroDao;
import com.buro.dto.RequestBuroCred;

/**
 * 
 */
@Component
public class BuroBusiness {

	@Autowired
	private BuroDao dao;

	private static boolean aceptacion;

	public Boolean aceptar(RequestBuroCred request) {
		boolean prestamoAct = dao.prestamoActivo(request.getRfc());
		System.out.println(prestamoAct);
		if (!prestamoAct) {
			// Obtiene la calificación del rfc que viene en el request
			int calificacion = dao.obtenerCalificacion(request.getRfc());

			if (calificacion <= 5) {
				aceptacion = false;
			} else if (calificacion > 5) {
				aceptacion = true;
			}
		}else {
			aceptacion = false;
		}

		return aceptacion;
	}

}
