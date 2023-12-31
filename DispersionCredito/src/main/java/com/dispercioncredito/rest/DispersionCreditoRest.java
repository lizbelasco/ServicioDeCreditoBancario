package com.dispercioncredito.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dispercioncredito.dao.DispersionCreditoDao;
import com.dispercioncredito.dto.RequestDispersionCredito;
import com.dispercioncredito.dto.RespuestaDispersionCredito;

@RestController
public class DispersionCreditoRest {

    @Autowired
    private DispersionCreditoDao dao;
    
    @PostMapping("/deposito")
    public ResponseEntity<RespuestaDispersionCredito> depositar(@RequestBody RequestDispersionCredito request) {
    //Request pasar el rfc al dao para obtener la calificacion y después obtener la aceptacion en business
    RespuestaDispersionCredito resp = new RespuestaDispersionCredito();
    
    dao.depositar(request.getMonto(), request.getMeses(), request.getPagoMensual(), request.getRfc());
    
    resp.setRfc(request.getRfc()); 
    resp.setMes(request.getMeses());
    resp.setPagoMensual(request.getPagoMensual());  
    resp.setTablaAmortizacion(request.getTablaAmortizacion());    
    resp.setMensaje("Se deposito $" + request.getMonto() + " en la cuenta de " + request.getRfc() );    
    
    ResponseEntity<RespuestaDispersionCredito> re = 
                new ResponseEntity<RespuestaDispersionCredito>(resp, 
                HttpStatusCode.valueOf(200));
    return re;
    }
}

