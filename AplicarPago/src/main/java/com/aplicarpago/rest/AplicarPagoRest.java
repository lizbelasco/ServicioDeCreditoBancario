package com.aplicarpago.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aplicarpago.dto.RequestAplicarPago;
import com.aplicarpago.dto.RespuestaAplicarPago;

@RestController
public class AplicarPagoRest {

	@PostMapping("/aplicarpago")
	public RespuestaAplicarPago generar(@RequestBody RequestAplicarPago request) {
		// Para convertir a gson
		//Gson gson = new Gson();

		RespuestaAplicarPago respuestaDepositoCredito = new RespuestaAplicarPago();

		// Crear una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// ****SERVICIO DE PAGO
		// URL del servicio REST del Buro de Credito
		String urlPago = "http://localhost:8085/pagar";

		// Hacer una solicitud POST al Buro de Credito REST
		ResponseEntity<RespuestaAplicarPago> responseEntity1 = restTemplate.postForEntity(urlPago, request,
				RespuestaAplicarPago.class);

		respuestaDepositoCredito = responseEntity1.getBody();
		// System.out.println(gson.toJson("Respuesta buro: " +
		// respuestaDepositoCredito.toString()));

		return respuestaDepositoCredito;
	}
}
