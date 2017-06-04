package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarioproveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarioproveedor.findAll", query="SELECT u FROM Usuarioproveedor u")
public class Usuarioproveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idfactura;

	private int idoferta;

	private int idproveedor;

	private int idusuario;

	public Usuarioproveedor() {
	}

	public int getIdfactura() {
		return this.idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
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

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

}