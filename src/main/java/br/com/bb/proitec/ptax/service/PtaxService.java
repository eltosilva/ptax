package br.com.bb.proitec.ptax.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bb.proitec.ptax.modelo.RespostaPtax;

@Service
public class PtaxService {

	public RespostaPtax consultarCotacao(LocalDate data) {
		
		String dataStr = "'" + data.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + "'";
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("olinda.bcb.gov.br")
				.path("olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)")
				.queryParam("@dataCotacao", dataStr)
				.queryParam("$top", 10)
				.queryParam("$skip", 0)
				.queryParam("$format", "json")
				.queryParam("$select", "cotacaoCompra,cotacaoVenda,dataHoraCotacao")
				.build();

		RestTemplate rt = new RestTemplate();
		ResponseEntity<RespostaPtax> entity = rt.getForEntity(uri.toUriString(), RespostaPtax.class);
		
		return entity.getBody();
	}
}
