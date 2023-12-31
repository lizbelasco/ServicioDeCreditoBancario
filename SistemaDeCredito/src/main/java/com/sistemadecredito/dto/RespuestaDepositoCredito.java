/**
 * 
 */
package com.sistemadecredito.dto;

import java.util.List;

/**
 * 
 */
public class RespuestaDepositoCredito {
	
	private List<FilaTablaAmortizacion> tablaAmortizacion;
	private String rfc;
	private String mensaje;
	
	/**
	 * @return the tablaAmortizacion
	 */
	public List<FilaTablaAmortizacion> getTablaAmortizacion() {
		return tablaAmortizacion;
	}
	/**
	 * @param tablaAmortizacion the tablaAmortizacion to set
	 */
	public void setTablaAmortizacion(List<FilaTablaAmortizacion> tablaAmortizacion) {
		this.tablaAmortizacion = tablaAmortizacion;
	}
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
