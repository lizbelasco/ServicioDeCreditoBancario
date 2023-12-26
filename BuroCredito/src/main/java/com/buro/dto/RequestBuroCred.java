package com.buro.dto;

public class RequestBuroCred {

    private String rfc;
    private double monto;
    private Integer meses;
    
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
   

}
