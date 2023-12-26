package com.sistemadecredito.dto;

public class Request {

    private String rfc;
    private double monto;
    private double meses;
    private double porcentaje;
    
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
     * @return the meses
     */
    public double getMeses() {
        return meses;
    }
    /**
     * @param meses the meses to set
     */
    public void setMeses(double meses) {
        this.meses = meses;
    }
    /**
     * @return the porcentaje
     */
    public double getPorcentaje() {
        return porcentaje;
    }
    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

}
