/**
 * 
 */
package com.tablaamortizacion.business;

import org.springframework.stereotype.Component;


/**
 * 
 */
@Component
public class TablaAmorBusiness {
    
	/*Valor inicial, interes mensual y mes
	 * Return pagoMensualConInteres
	 */
	
    public double pagoMensual(double principal, double interesMensual, double mes) {
        return (interesMensual * principal) / (1 - Math.pow(1 + interesMensual, -mes));
    }

}
