package br.com.bb.proitec.ptax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bb.proitec.ptax.modelo.Cotacao;
import br.com.bb.proitec.ptax.modelo.RespostaPtax;

@SpringBootTest
public class TestPtaxService {

	@Autowired
	private PtaxService ptaxService;
	
	
	@Test
	public void testSucessoAoConsultarCotacao() {
		
		RespostaPtax respostaCorreta = new RespostaPtax();

		List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		Cotacao cotacao = new Cotacao();
		cotacao.setCotacaoCompra(5.673);
		cotacao.setCotacaoVenda(5.6736);
		cotacao.setDataHoraCotacao("2022-01-10 13:09:59.748");
		
		cotacoes.add(cotacao);
		respostaCorreta.setValue(cotacoes);
		
		RespostaPtax resposta = ptaxService.consultarCotacao(LocalDate.of(2022, 1, 10));
		
		assertEquals(respostaCorreta, resposta);
	}
}
