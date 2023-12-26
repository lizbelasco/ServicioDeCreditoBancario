package com.buro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buro.business.BuroBusiness;
import com.buro.dto.RequestBuroCred;
import com.buro.dto.RespuestaBuroCred;

@RestController
public class BuroRest {

    @Autowired
    private BuroBusiness business;
    
    @PostMapping("/buro")
    public ResponseEntity<RespuestaBuroCred> generarCalificacion(@RequestBody RequestBuroCred request) {
    //Request pasar el rfc al dao para obtener la calificacion y después obtener la aceptacion en business
    RespuestaBuroCred resp = new RespuestaBuroCred();
    boolean aceptacion = business.aceptar(request);
    resp.setAceptacion(aceptacion);
    resp.setRfc(request.getRfc());
    resp.setMeses(request.getMeses());
    resp.setMonto(request.getMonto());
    if(aceptacion) {
        resp.setMensaje("Credito aceptado");
    }else {
        resp.setMensaje("Credito no aprobado");
    }
    
    ResponseEntity<RespuestaBuroCred> re = 
                new ResponseEntity<RespuestaBuroCred>(resp, 
                HttpStatusCode.valueOf(200));
    return re;
    }
}

