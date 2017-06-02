package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ofertacompetencia database table.
 * 
 */
@Entity
@NamedQuery(name="Ofertacompetencia.findAll", query="SELECT o FROM Ofertacompetencia o")
public class Ofertacompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	private int experiencia;

	private String requerido;

	//bi-directional many-to-one association to CompetenciaVO
        
	@ManyToOne
	@JoinColumn(name="idcompetenciafk")
	private Competencia competencia;

	//bi-directional many-to-one association to Oferta
	@ManyToOne
	@JoinColumn(name="idofertafka")
	private Oferta oferta;

	public Ofertacompetencia() {
	}

	public int getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public String getRequerido() {
		return this.requerido;
	}

	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

}