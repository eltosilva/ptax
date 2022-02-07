package br.com.bb.proitec.ptax.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.proitec.ptax.modelo.Cotacao;
import br.com.bb.proitec.ptax.service.PtaxService;

@RestController
@RequestMapping("/ptax")
public class PtaxController {
	@Autowired
	PtaxService ptaxService;

	@GetMapping
	public ResponseEntity<Cotacao> consultarCotacaoPorData(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate data){
		return ResponseEntity.ok(ptaxService.consultarCotacao(data).getValue().get(0));
	}
	
}
