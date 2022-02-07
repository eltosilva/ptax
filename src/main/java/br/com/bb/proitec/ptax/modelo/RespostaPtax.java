package br.com.bb.proitec.ptax.modelo;

import java.util.List;
import java.util.Objects;

public class RespostaPtax {

	private List<Cotacao> value;

	public List<Cotacao> getValue() {
		return value;
	}

	public void setValue(List<Cotacao> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RespostaPtax [value=" + value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaPtax other = (RespostaPtax) obj;
		return Objects.equals(value, other.value);
	}

}
