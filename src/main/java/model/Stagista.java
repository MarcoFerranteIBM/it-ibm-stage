package model;

import javax.xml.bind.annotation.*;

import com.google.gson.annotations.*;

@XmlRootElement
@XmlType(propOrder = { "nome", "cognome", "sesso", "eta" })
public class Stagista {

	@Expose
	String nome;

	@Expose
	String cognome;

	@Expose
	@XmlTransient
	String sesso;

	@XmlTransient
	int eta;

	public Stagista() {
	}

	public Stagista(String nome, String cognome, String sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}

	@XmlElement
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@XmlElement
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
