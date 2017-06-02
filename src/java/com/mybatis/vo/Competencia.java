package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competencia database table.
 * 
 */
@Entity
@NamedQuery(name="Competencia.findAll", query="SELECT c FROM Competencia c")
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcompetencia;

	private int bandera;

	private String descripcion;

	private String tipo;

	//bi-directional many-to-one association to Ofertacompetencia
	@OneToMany(mappedBy="competencia")
	private List<Ofertacompetencia> ofertacompetencias;

	public Competencia() {
	}

	public int getIdcompetencia() {
		return this.idcompetencia;
	}

	public void setIdcompetencia(int idcompetencia) {
		this.idcompetencia = idcompetencia;
	}

	public int getBandera() {
		return this.bandera;
	}

	public void setBandera(int bandera) {
		this.bandera = bandera;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Ofertacompetencia> getOfertacompetencias() {
		return this.ofertacompetencias;
	}

	public void setOfertacompetencias(List<Ofertacompetencia> ofertacompetencias) {
		this.ofertacompetencias = ofertacompetencias;
	}

	public Ofertacompetencia addOfertacompetencia(Ofertacompetencia ofertacompetencia) {
		getOfertacompetencias().add(ofertacompetencia);
		ofertacompetencia.setCompetencia(this);

		return ofertacompetencia;
	}

	public Ofertacompetencia removeOfertacompetencia(Ofertacompetencia ofertacompetencia) {
		getOfertacompetencias().remove(ofertacompetencia);
		ofertacompetencia.setCompetencia(null);

		return ofertacompetencia;
	}

}