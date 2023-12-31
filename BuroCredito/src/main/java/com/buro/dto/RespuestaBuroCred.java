package com.buro.dto;

public class RespuestaBuroCred {
    
    private String rfc;
    private boolean aceptacion;
    private double monto;
    private Integer meses;
    private String mensaje;
    
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
     * @return the aceptacion
     */
    public boolean isAceptacion() {
        return aceptacion;
    }
    /**
     * @param aceptacion the aceptacion to set
     */
    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
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
