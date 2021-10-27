package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	private int numero;

	private Double saldo;

	private Double limite;

	public Conta(int numero, Double saldo, Double limite) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}

	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((limite == null) ? 0 : limite.hashCode());
		result = prime * result + numero;
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (limite == null) {
			if (other.limite != null)
				return false;
		} else if (!limite.equals(other.limite))
			return false;
		if (numero != other.numero)
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

}
