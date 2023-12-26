package com.pagocredito.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pagocredito.business.PagoCreditoBusiness;
import com.pagocredito.commons.Env;
import com.pagocredito.dao.PagoCreditoDao;
import com.pagocredito.dto.RequestPagoCredito;
import com.pagocredito.dto.RespuestaPagoCredito;

@RestController
public class PagoCreditoRest {

	@Autowired
	private PagoCreditoBusiness business;

	@Autowired
	private PagoCreditoDao dao;

	@PostMapping("/pagar")
	public ResponseEntity<RespuestaPagoCredito> pagar(@RequestBody RequestPagoCredito request) {
		RespuestaPagoCredito resp = new RespuestaPagoCredito();
		//System.out.println(dao.obtenerPrestamo(request.getRfc()));
		if(dao.obtenerPrestamo(request.getRfc()) != null) {
			
			String porcentaje = Env.getProperty("porcentaje.interes");
	        double porcentajeEnv = Double.parseDouble(porcentaje);
			request.setPorcentaje(porcentajeEnv);
	        
			if (request.getPagoExtra() == 0 && request.getPagoMensual() == dao.obtenerPagoMensual(request.getRfc())) {
				resp = business.pagar(request);
			} else if (request.getPagoExtra() > 0 &&
					request.getPagoMensual() == dao.obtenerPagoMensual(request.getRfc())) {
				resp = business.pagarExtra(request);
			} else {
				resp.setMensaje("El pago tiene que ser el minimo");
			}	
		}else {
			resp.setRfc(request.getRfc());
			resp.setMensaje("No tienes nigun prestamo en curso");
		}
		ResponseEntity<RespuestaPagoCredito> re = new ResponseEntity<RespuestaPagoCredito>(resp,
				HttpStatusCode.valueOf(200));
		return re;
	}
}
