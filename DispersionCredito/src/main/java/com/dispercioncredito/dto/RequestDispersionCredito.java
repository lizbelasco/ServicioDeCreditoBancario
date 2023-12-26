package com.dispercioncredito.dto;

import java.util.List;

public class RequestDispersionCredito {

	private List<FilaTablaAmortizacion> tablaAmortizacion;
	private String rfc;
	private double monto;
	private Integer meses;
	private double pagoMensual;
    
    /**
	 * @return the meses
	 */
	public Integer getMeses() {
		return meses;
	}
	/**
	 * @param meses the meses to set
	 */
	public void setMeses(Integer meses) {
		this.meses = meses;
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
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }
    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
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

}
