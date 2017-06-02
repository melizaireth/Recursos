package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compeofertacandidato database table.
 * 
 */
@Entity
@NamedQuery(name="Compeofertacandidato.findAll", query="SELECT c FROM Compeofertacandidato c")
public class Compeofertacandidato implements Serializable {
	private static final long serialVersionUID = 1L;

        @Id
	private int idcompetenciafkc;

	private int idofertafkc;

	private String nivelcandidato;

	//bi-directional many-to-one association to Candidato
	@ManyToOne
	@JoinColumn(name="idcandidatofkc")
	private Candidato candidato;

	public Compeofertacandidato() {
	}

	public int getIdcompetenciafkc() {
		return this.idcompetenciafkc;
	}

	public void setIdcompetenciafkc(int idcompetenciafkc) {
		this.idcompetenciafkc = idcompetenciafkc;
	}

	public int getIdofertafkc() {
		return this.idofertafkc;
	}

	public void setIdofertafkc(int idofertafkc) {
		this.idofertafkc = idofertafkc;
	}

	public String getNivelcandidato() {
		return this.nivelcandidato;
	}

	public void setNivelcandidato(String nivelcandidato) {
		this.nivelcandidato = nivelcandidato;
	}

	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}