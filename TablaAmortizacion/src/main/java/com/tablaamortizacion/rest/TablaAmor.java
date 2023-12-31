package com.tablaamortizacion.rest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tablaamortizacion.business.TablaAmorBusiness;
import com.tablaamortizacion.commons.Env;
import com.tablaamortizacion.dto.FilaTablaAmortizacion;
import com.tablaamortizacion.dto.RequestTablaAmor;
import com.tablaamortizacion.dto.RespuestaTablaAmor;

@RestController
public class TablaAmor {

    @Autowired
    private TablaAmorBusiness business;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    @PostMapping("/generarTablaAmortizacion")
    public RespuestaTablaAmor generarTablaAmortizacion(@RequestBody RequestTablaAmor request) {
        RespuestaTablaAmor respuesta = new RespuestaTablaAmor();
        List<FilaTablaAmortizacion> tablaAmortizacion = new ArrayList<>();

        String porcentaje = Env.getProperty("porcentaje.interes");
        double porcentajeEnv = Double.parseDouble(porcentaje);
        
        double interesMensual = porcentajeEnv / 100 / 12; //Obtiene porcentaje decimal
        double pagoMensual = business.pagoMensual(request.getMonto(), interesMensual, request.getMeses());
        double totalInteres = 0;
        double balance = request.getMonto();

        for (int meses = 1; meses <= request.getMeses(); meses++) {
            double interes = balance * interesMensual;
            double capital = pagoMensual - interes;
            balance -= capital;
            totalInteres = totalInteres + interes;

            FilaTablaAmortizacion fila = new FilaTablaAmortizacion();
            fila.setMes(meses);
            fila.setPago(Double.parseDouble(DECIMAL_FORMAT.format(pagoMensual)));
            fila.setInteres(Double.parseDouble(DECIMAL_FORMAT.format(interes)));
            fila.setCapital(Double.parseDouble(DECIMAL_FORMAT.format(capital)));
            fila.setBalance(Double.parseDouble(DECIMAL_FORMAT.format(balance)));
            fila.setTotalInteres(Double.parseDouble(DECIMAL_FORMAT.format(totalInteres)));

            tablaAmortizacion.add(fila);
        }
        respuesta.setRfc(request.getRfc());
        respuesta.setTablaAmortizacion(tablaAmortizacion);
        respuesta.setMonto(request.getMonto());
        respuesta.setMeses(request.getMeses());
        respuesta.setPagoMensual(Double.parseDouble(DECIMAL_FORMAT.format(pagoMensual)));

        return respuesta;
    }
    
}
