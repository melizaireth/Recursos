/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.mybatis.bo.ProveedorBO;
import com.mybatis.bo.UsuarioBO;
import com.mybatis.vo.Proveedor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Melissa
 */
@ManagedBean(name = "editP")
@ViewScoped
public class EditProveedor {

    /**
     * Creates a new instance of EditProveedor
     */
    List<Proveedor> proveedores;
    Proveedor proveedor;
    
    public EditProveedor() {
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    @PostConstruct
    public void init() {
        ProveedorBO pbo = new ProveedorBO();
        proveedores = pbo.allProveedor();
               
    }
    
    public void onRowEdit(RowEditEvent event) {
        
        proveedor = ((Proveedor) event.getObject());
        
        ProveedorBO pbo = new ProveedorBO();
        int ok = pbo.actualizarProveedor(proveedor);
        FacesMessage msg = new FacesMessage("Proveedor Editado: ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se ha cancelado la modificación del proveedor");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
