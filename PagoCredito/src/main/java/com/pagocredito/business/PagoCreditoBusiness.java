/**
 * 
 */
package com.pagocredito.business;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagocredito.dao.PagoCreditoDao;
import com.pagocredito.dto.FilaTablaAmortizacion;
import com.pagocredito.dto.RequestPagoCredito;
import com.pagocredito.dto.RespuestaPagoCredito;

/**
 * 
 */
@Component
public class PagoCreditoBusiness {

    @Autowired
    private PagoCreditoDao dao;

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public RespuestaPagoCredito pagar(RequestPagoCredito request) {
        RespuestaPagoCredito resp = new RespuestaPagoCredito();
        int contador = dao.obtenerPagos(request.getRfc());

        if (contador >= request.getMes()) {
            resp.setRfc(request.getRfc());
            resp.setMensaje("Ya se han realizado todos los pagos");
            dao.ceros(request.getRfc());
            return resp;
        }

        dao.pagoRealizado(request.getRfc(), contador + 1);
        resp.setRfc(request.getRfc());
        resp.setTablaAmortizacion(request.getTablaAmortizacion());
        resp.setMensaje("Se realizó el pago correctamente");
        return resp;
    }

    public RespuestaPagoCredito pagarExtra(RequestPagoCredito request) {
        RespuestaPagoCredito resp = new RespuestaPagoCredito();
        int contador = dao.obtenerPagos(request.getRfc());
        double pagoExtra = request.getPagoExtra();
        double prestamo = dao.obtenerPrestamo(request.getRfc());
        List<FilaTablaAmortizacion> tablaAmortizacion = request.getTablaAmortizacion();

        if (contador >= request.getMes()) {
            resp.setRfc(request.getRfc());
            resp.setMensaje("Ya se han realizado todos los pagos");
            return resp;
        }

        for (int i = contador; i < request.getTablaAmortizacion().size(); i++) {
            double porcentaje = request.getPorcentaje() / 100;
            double pagoMensual = tablaAmortizacion.get(i).getPago();
            double interes = tablaAmortizacion.get(i).getInteres();
            double capital = tablaAmortizacion.get(i).getCapital();
     
            if (i == 0) {
                tablaAmortizacion.get(i).setPago(Double.parseDouble(decimalFormat.format(pagoMensual)));
                tablaAmortizacion.get(i).setInteres(Double.parseDouble(decimalFormat.format(interes)));
                tablaAmortizacion.get(i).setCapital(Double.parseDouble(decimalFormat.format(capital)));
                tablaAmortizacion.get(i).setBalance(Double.parseDouble(decimalFormat.format((prestamo + ((prestamo * porcentaje) / 12)) - pagoMensual - pagoExtra)));
                tablaAmortizacion.get(i).setTotalInteres(Double.parseDouble(decimalFormat.format(interes)));
            } else if(i==contador){
                double pagoMensualAnterior = tablaAmortizacion.get(i - 1).getPago();
                double interesAnterior = tablaAmortizacion.get(i - 1).getInteres();
                double balanceAnterior = tablaAmortizacion.get(i - 1).getBalance();
                double totalInteresesAnterior = tablaAmortizacion.get(i - 1).getTotalInteres();
                
                //PAGO
                if (balanceAnterior > (pagoMensualAnterior - interesAnterior)) {
                    tablaAmortizacion.get(i).setPago(Double.parseDouble(decimalFormat.format(pagoMensual)));
                } else {
                    tablaAmortizacion.get(i).setPago(Double.parseDouble(decimalFormat.format(balanceAnterior + interes)));
                }
                
                //INTERES
                tablaAmortizacion.get(i).setInteres(Double.parseDouble(decimalFormat.format(balanceAnterior * porcentaje / 12)));
                
                //CAPITAL
                if (balanceAnterior > (pagoMensual - interes)) {
                    tablaAmortizacion.get(i).setCapital(Double.parseDouble(decimalFormat.format(pagoMensual - interes)));
                } else {
                    tablaAmortizacion.get(i).setCapital(Double.parseDouble(decimalFormat.format(balanceAnterior)));
                }
                
                //BALANCE
                if (((balanceAnterior + ((balanceAnterior * porcentaje) / 12)) - pagoMensual - pagoExtra) > 0) {
                    tablaAmortizacion.get(i).setBalance(Double.parseDouble(decimalFormat.format((balanceAnterior + ((balanceAnterior * porcentaje) / 12)) - pagoMensual - pagoExtra)));
                } else {
                    tablaAmortizacion.get(i).setBalance(0);
                }
                
                //TOTAL INTERESES
                tablaAmortizacion.get(i).setTotalInteres(Double.parseDouble(decimalFormat.format(totalInteresesAnterior + interes)));
            }else {
            	double pagoMensualAnterior = tablaAmortizacion.get(i - 1).getPago();
                double interesAnterior = tablaAmortizacion.get(i - 1).getInteres();
                double balanceAnterior = tablaAmortizacion.get(i - 1).getBalance();
                double totalInteresesAnterior = tablaAmortizacion.get(i - 1).getTotalInteres();
                
                //PAGO
                if (balanceAnterior > (pagoMensualAnterior - interesAnterior)) {
                    tablaAmortizacion.get(i).setPago(Double.parseDouble(decimalFormat.format(pagoMensual)));
                } else {
                    tablaAmortizacion.get(i).setPago(Double.parseDouble(decimalFormat.format(balanceAnterior + interes)));
                }
                
                //INTERES
                tablaAmortizacion.get(i).setInteres(Double.parseDouble(decimalFormat.format(balanceAnterior * porcentaje / 12)));
                
                //CAPITAL
                if (balanceAnterior > (pagoMensual - interes)) {
                    tablaAmortizacion.get(i).setCapital(Double.parseDouble(decimalFormat.format(pagoMensual - interes)));
                } else {
                    tablaAmortizacion.get(i).setCapital(Double.parseDouble(decimalFormat.format(balanceAnterior)));
                }
                
                //BALANCE
                if (((balanceAnterior + ((balanceAnterior * porcentaje) / 12)) - pagoMensual) > 0) {
                    tablaAmortizacion.get(i).setBalance(Double.parseDouble(decimalFormat.format((balanceAnterior + ((balanceAnterior * porcentaje) / 12)) - pagoMensual)));
                } else {
                    tablaAmortizacion.get(i).setBalance(0);
                }
                
                //TOTAL INTERESES
                tablaAmortizacion.get(i).setTotalInteres(Double.parseDouble(decimalFormat.format(totalInteresesAnterior + interes)));
            }
        }
        
        dao.pagoRealizado(request.getRfc(), contador + 1);
        int contador2 = dao.obtenerPagos(request.getRfc());
        tablaAmortizacion.get(contador2 - 1).setPagoExtra(pagoExtra);
        resp.setRfc(request.getRfc());
        resp.setTablaAmortizacion(tablaAmortizacion);
        resp.setMensaje("Se realizó el pago correctamente con un monto extra");
        return resp;
    }
}