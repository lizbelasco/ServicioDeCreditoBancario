package com.pagocredito.dto;

import java.util.List;

public class RespuestaPagoCredito {

	
	private String rfc; // El identificador único del crédito o del cliente
	private List<FilaTablaAmortizacion> tablaAmortizacion; // La tabla de amortización actualizada
	private String mensaje; // Mensaje descriptivo sobre el resultado del pago
	
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
