package com.mybatis.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproveedor;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private String nombrepro;

	private String tipoproveedor;

        private String direccion;
        
        private String telefono;
        
	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="proveedor")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Ofertaprovee
	@OneToMany(mappedBy="proveedor")
	private List<Ofertaprovee> ofertaprovees;

	public Proveedor() {
	}
        
        public Proveedor(int idproveedor, String nombre) {
            this.idproveedor = idproveedor;
            this.nombrepro = nombre;
        }

	public int getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getNombrepro() {
		return this.nombrepro;
	}

	public void setNombrepro(String nombrepro) {
		this.nombrepro = nombrepro;
	}

	public String getTipoproveedor() {
		return this.tipoproveedor;
	}

	public void setTipoproveedor(String tipoproveedor) {
		this.tipoproveedor = tipoproveedor;
	}

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
        
	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setProveedor(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setProveedor(null);

		return factura;
	}

	public List<Ofertaprovee> getOfertaprovees() {
		return this.ofertaprovees;
	}

	public void setOfertaprovees(List<Ofertaprovee> ofertaprovees) {
		this.ofertaprovees = ofertaprovees;
	}

	public Ofertaprovee addOfertaprovee(Ofertaprovee ofertaprovee) {
		getOfertaprovees().add(ofertaprovee);
		ofertaprovee.setProveedor(this);

		return ofertaprovee;
	}

	public Ofertaprovee removeOfertaprovee(Ofertaprovee ofertaprovee) {
		getOfertaprovees().remove(ofertaprovee);
		ofertaprovee.setProveedor(null);

		return ofertaprovee;
	}

}