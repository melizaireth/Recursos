/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.mybatis.bo.ProveedorBO;
import com.mybatis.vo.Proveedor;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Melissa
 */
@ManagedBean(name = "proveedor")
@RequestScoped
public class ProveedorBeans {

    /**
     * Creates a new instance of ProveedorBeans
     */
    public ProveedorBeans() {
    }
    Proveedor p = new Proveedor();

    public Proveedor getP() {
        return p;
    }

    public void setP(Proveedor p) {
        this.p = p;
    }
    
    public void altaProveedor(){
        p.setIdproveedor(-1);
        Date fecha = new Date();
        p.setFechaingreso(fecha);
        ProveedorBO pbo = new ProveedorBO();
        pbo.guadarProveedor(p);
    }
}
