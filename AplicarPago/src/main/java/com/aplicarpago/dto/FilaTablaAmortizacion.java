package com.aplicarpago.dto;

public class FilaTablaAmortizacion {

	private int mes;
    private double pago; // Pago mensual fijo
    private double pagoExtra; // Pago adicional realizado en este mes
    private double interes; // Monto de interés en este mes
    private double capital; // Monto de capital en este mes
    private double balance; // Saldo restante después de este mes
    private double totalInteres;
	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}
	/**
	 * @return the pago
	 */
	public double getPago() {
		return pago;
	}
	/**
	 * @param pago the pago to set
	 */
	public void setPago(double pago) {
		this.pago = pago;
	}
	/**
	 * @return the interes
	 */
	public double getInteres() {
		return interes;
	}
	/**
	 * @param interes the interes to set
	 */
	public void setInteres(double interes) {
		this.interes = interes;
	}
	/**
	 * @return the capital
	 */
	public double getCapital() {
		return capital;
	}
	/**
	 * @param capital the capital to set
	 */
	public void setCapital(double capital) {
		this.capital = capital;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the totalInteres
	 */
	public double getTotalInteres() {
		return totalInteres;
	}
	/**
	 * @param totalInteres the totalInteres to set
	 */
	public void setTotalInteres(double totalInteres) {
		this.totalInteres = totalInteres;
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
