package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the candidato database table.
 * 
 */
@Entity
@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcandidato;

	private String apellido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int idoferta;

	private int idproveedor;

	private String nombre;

	private String rutacv;

	private String seleccionado;

	//bi-directional many-to-one association to Compeofertacandidato
	@OneToMany(mappedBy="candidato")
	private List<Compeofertacandidato> compeofertacandidatos;

	public Candidato() {
	}

	public int getIdcandidato() {
		return this.idcandidato;
	}

	public void setIdcandidato(int idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdoferta() {
		return this.idoferta;
	}

	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}

	public int getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRutacv() {
		return this.rutacv;
	}

	public void setRutacv(String rutacv) {
		this.rutacv = rutacv;
	}

	public String getSeleccionado() {
		return this.seleccionado;
	}

	public void setSeleccionado(String seleccionado) {
		this.seleccionado = seleccionado;
	}

	public List<Compeofertacandidato> getCompeofertacandidatos() {
		return this.compeofertacandidatos;
	}

	public void setCompeofertacandidatos(List<Compeofertacandidato> compeofertacandidatos) {
		this.compeofertacandidatos = compeofertacandidatos;
	}

	public Compeofertacandidato addCompeofertacandidato(Compeofertacandidato compeofertacandidato) {
		getCompeofertacandidatos().add(compeofertacandidato);
		compeofertacandidato.setCandidato(this);

		return compeofertacandidato;
	}

	public Compeofertacandidato removeCompeofertacandidato(Compeofertacandidato compeofertacandidato) {
		getCompeofertacandidatos().remove(compeofertacandidato);
		compeofertacandidato.setCandidato(null);

		return compeofertacandidato;
	}

}