package model;

import java.util.Objects;

public class Stagista {

	String nome;
	String cognome;
	String sesso;
	
	@Override
	public int hashCode() {
		return Objects.hash(cognome, nome, sesso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagista other = (Stagista) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(nome, other.nome)
				&& Objects.equals(sesso, other.sesso);
	}
	public Stagista(String nome, String cognome, String sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	 
}
