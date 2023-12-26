package com.sistemadecredito.dto;

public class FilaTablaAmortizacion {

	private Integer mes;
	private double pagoMensual;
	private double interes;
	private double capital;
	private double balance;
	private double totalInteres = 0;
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
	 * @return the pago
	 */
	public double getPago() {
		return pagoMensual;
	}
	/**
	 * @param pago the pago to set
	 */
	public void setPago(double pago) {
		this.pagoMensual = pago;
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
	
	
}
