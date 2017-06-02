package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idfactura;

	private String concepto;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fechapago")
	private Date fechapago;

	@Temporal(TemporalType.DATE)
	private Date fechaentrega;

	private float importetotal;

	private String nrofacproveedor;

	private String obseravciones;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private Proveedor proveedor;

	public Factura() {
	}

	public int getIdfactura() {
		return this.idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechapago() {
		return this.fechapago;
	}

	public void setFechaAgo(Date fechapago) {
		this.fechapago = fechapago;
	}

	public Date getFechaentrega() {
		return this.fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public float getImportetotal() {
		return this.importetotal;
	}

	public void setImportetotal(float importetotal) {
		this.importetotal = importetotal;
	}

	public String getNrofacproveedor() {
		return this.nrofacproveedor;
	}

	public void setNrofacproveedor(String nrofacproveedor) {
		this.nrofacproveedor = nrofacproveedor;
	}

	public String getObseravciones() {
		return this.obseravciones;
	}

	public void setObseravciones(String obseravciones) {
		this.obseravciones = obseravciones;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}