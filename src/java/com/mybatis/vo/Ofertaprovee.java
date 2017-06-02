package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ofertaprovee database table.
 * 
 */
@Entity
@NamedQuery(name="Ofertaprovee.findAll", query="SELECT o FROM Ofertaprovee o") 
public class Ofertaprovee implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idproveedorfk;

	//bi-directional many-to-one association to Oferta
	@ManyToOne
	@JoinColumn(name="idofertafk")
	private Oferta oferta;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idofertafk")
	private Proveedor proveedor;

	public Ofertaprovee() {
	}

	public int getIdproveedorfk() {
		return this.idproveedorfk;
	}

	public void setIdproveedorfk(int idproveedorfk) {
		this.idproveedorfk = idproveedorfk;
	}

	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}