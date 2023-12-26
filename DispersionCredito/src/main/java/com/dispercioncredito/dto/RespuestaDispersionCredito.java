package com.dispercioncredito.dto;

import java.util.List;

public class RespuestaDispersionCredito {
    
	private List<FilaTablaAmortizacion> tablaAmortizacion;
	private String rfc;
	private double pagoMensual;
	private Integer mes;
	private double pagoExtra;
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
	 * @return the pagoMensual
	 */
	public double getPagoMensual() {
		return pagoMensual;
	}
	/**
	 * @param pagoMensual the pagoMensual to set
	 */
	public void setPagoMensual(double pagoMensual) {
		this.pagoMensual = pagoMensual;
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
	/**
	 * @return the mes
	 */
	public Integer getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	/**
	 * @return the pagoExtra
	 */
	public double getPagoExtra() {
		return pagoExtra;
	}
	/**
	 * @param pagoExtra the pagoExtra to set
	 */
	public void setPagoExtra(double pagoExtra) {
		this.pagoExtra = pagoExtra;
	}
    
}
