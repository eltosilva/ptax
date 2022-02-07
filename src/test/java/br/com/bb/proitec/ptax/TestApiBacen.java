package br.com.bb.proitec.ptax;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bb.proitec.ptax.modelo.RespostaPtax;

@SpringBootTest
public class TestApiBacen {

	@Test
	void testApiBacen() {

		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("olinda.bcb.gov.br")
				.path("olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)")
				.queryParam("@dataCotacao", "'01-10-2022'")
				.queryParam("$top", 10)
				.queryParam("$skip", 0)
				.queryParam("$format", "json")
				.queryParam("$select", "cotacaoCompra,cotacaoVenda,dataHoraCotacao")
				.build();

		RestTemplate rt = new RestTemplate();
		ResponseEntity<RespostaPtax> entity = rt.getForEntity(uri.toUriString(), RespostaPtax.class);
		
		System.out.println(entity.getBody().getValue());
	}
}
