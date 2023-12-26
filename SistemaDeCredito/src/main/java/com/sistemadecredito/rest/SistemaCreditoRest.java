package com.sistemadecredito.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sistemadecredito.dto.Request;
import com.sistemadecredito.dto.RespuestaBuroCredito;
import com.sistemadecredito.dto.RespuestaDepositoCredito;
import com.sistemadecredito.dto.RespuestaTablaAmortizacion;

@RestController
public class SistemaCreditoRest {
	
	private static final Logger LOGGER = LogManager.getLogger(SistemaCreditoRest.class);
	
	@PostMapping("/sistemacredito")
	public RespuestaDepositoCredito obtener(@RequestBody Request request) {
		// Para convertir a gson
		// Gson gson = new Gson();

		RespuestaDepositoCredito respuestaDepositoCredito = new RespuestaDepositoCredito();

		// Crear una instancia de RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// ****SERVICIO DE BURO DE CREDITO
		LOGGER.info("Inicio de servicio de buro de credito.");
		// URL del servicio REST del Buro de Credito
		String urlBuroCredito = "http://localhost:8080/buro";

		// Hacer una solicitud POST al Buro de Credito REST
		ResponseEntity<RespuestaBuroCredito> responseEntity1 = restTemplate.postForEntity(urlBuroCredito, request,
				RespuestaBuroCredito.class);

		RespuestaBuroCredito respuestaBuroCredito = responseEntity1.getBody();
		// System.out.println(gson.toJson("Respuesta buro: " +
		// respuestaBuroCredito.toString()));

		if (respuestaBuroCredito.isAceptacion()) {
			// ****SERVICIO DE TABLA DE AMORTIZACION
			LOGGER.info("Inicio de servicio para crear la tabla de amortizacion.");
			//System.out.println("Si fui aceptado: ");
			// URL del servicio REST a la tabla de amortizacion
			String urlTablaAmortizacion = "http://localhost:8082/generarTablaAmortizacion";

			// Hacer una solicitud POST al tabla de amortizacion REST
			ResponseEntity<RespuestaTablaAmortizacion> responseEntity2 = restTemplate.postForEntity(
					urlTablaAmortizacion, respuestaBuroCredito, // Debes proporcionar un objeto Request válido
					RespuestaTablaAmortizacion.class);

			RespuestaTablaAmortizacion respuestaTablaAmortizacion = responseEntity2.getBody();
			// System.out.println(gson.toJson("Respuesta tabla: " +
			// respuestaTablaAmortizacion));

			// ****SERVICIO DE DEPOSITO
			LOGGER.info("Inicio de servicio de deposito.");
			// URL del servicio REST a la tabla de amortizacion
			String urlDeposito = "http://localhost:8083/deposito";

			// Hacer una solicitud POST al tabla de amortizacion REST
			ResponseEntity<RespuestaDepositoCredito> responseEntity3 = restTemplate.postForEntity(urlDeposito,
					respuestaTablaAmortizacion, // Debes proporcionar un objeto Request válido
					RespuestaDepositoCredito.class);

			respuestaDepositoCredito = responseEntity3.getBody();
			// System.out.println(gson.toJson("Respuesta tabla: " +
			// respuestaTablaAmortizacion));
		}else {
			respuestaDepositoCredito.setMensaje("No se acepto el credito de " + request.getRfc());
		}

		return respuestaDepositoCredito;
	}
}
