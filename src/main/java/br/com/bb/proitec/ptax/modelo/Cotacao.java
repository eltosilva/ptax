package br.com.bb.proitec.ptax.modelo;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cotacao {

	private Double cotacaoCompra;
	private Double cotacaoVenda;
	private LocalDate data;

	public Double getCompra() {
		return cotacaoCompra;
	}

	public void setCotacaoCompra(Double cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}

	public Double getVenda() {
		return cotacaoVenda;
	}

	public void setCotacaoVenda(Double cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}

	public LocalDate getData() {
		return data;
	}

	public void setDataHoraCotacao(String dataHoraCotacao) {
		Pattern regex = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher = regex.matcher(dataHoraCotacao);
		
		LocalDate ld = null;
		while(matcher.find()) {
			ld = LocalDate.parse(matcher.group());
		}
		this.data = ld;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaoCompra, cotacaoVenda, data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cotacao other = (Cotacao) obj;
		return Objects.equals(cotacaoCompra, other.cotacaoCompra) && Objects.equals(cotacaoVenda, other.cotacaoVenda)
				&& Objects.equals(data, other.data);
	}

	@Override
	public String toString() {
		return "Cotacao [cotacaoCompra=" + cotacaoCompra + ", cotacaoVenda=" + cotacaoVenda + ", dataHoraCotacao="
				+ data + "]";
	}

}
