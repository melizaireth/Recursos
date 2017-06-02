package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oferta database table.
 * 
 */
@Entity
@NamedQuery(name="Oferta.findAll", query="SELECT o FROM Oferta o")
public class Oferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idoferta;

	private String estado;

	private String estudios;

	private Date fechafin;

	private Date fechainicio;

	private String puesto;

	private String segundonivel;

	private String tercernivel;

	//bi-directional many-to-one association to Ofertacompetencia
	@OneToMany(mappedBy="oferta")
	private List<Ofertacompetencia> ofertacompetencias;

	//bi-directional many-to-one association to Ofertaprovee
	@OneToMany(mappedBy="oferta")
	private List<Ofertaprovee> ofertaprovees;

	public Oferta() {
	}

	public int getIdoferta() {
		return this.idoferta;
	}

	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstudios() {
		return this.estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getSegundonivel() {
		return this.segundonivel;
	}

	public void setSegundonivel(String segundonivel) {
		this.segundonivel = segundonivel;
	}

	public String getTercernivel() {
		return this.tercernivel;
	}

	public void setTercernivel(String tercernivel) {
		this.tercernivel = tercernivel;
	}

	public List<Ofertacompetencia> getOfertacompetencias() {
		return this.ofertacompetencias;
	}

	public void setOfertacompetencias(List<Ofertacompetencia> ofertacompetencias) {
		this.ofertacompetencias = ofertacompetencias;
	}

	public Ofertacompetencia addOfertacompetencia(Ofertacompetencia ofertacompetencia) {
		getOfertacompetencias().add(ofertacompetencia);
		ofertacompetencia.setOferta(this);

		return ofertacompetencia;
	}

	public Ofertacompetencia removeOfertacompetencia(Ofertacompetencia ofertacompetencia) {
		getOfertacompetencias().remove(ofertacompetencia);
		ofertacompetencia.setOferta(null);

		return ofertacompetencia;
	}

	public List<Ofertaprovee> getOfertaprovees() {
		return this.ofertaprovees;
	}

	public void setOfertaprovees(List<Ofertaprovee> ofertaprovees) {
		this.ofertaprovees = ofertaprovees;
	}

	public Ofertaprovee addOfertaprovee(Ofertaprovee ofertaprovee) {
		getOfertaprovees().add(ofertaprovee);
		ofertaprovee.setOferta(this);

		return ofertaprovee;
	}

	public Ofertaprovee removeOfertaprovee(Ofertaprovee ofertaprovee) {
		getOfertaprovees().remove(ofertaprovee);
		ofertaprovee.setOferta(null);

		return ofertaprovee;
	}

}