package com.mbeans;

import com.mybatis.bo.ProveedorBO;
import com.mybatis.bo.UsuarioBO;
import com.mybatis.vo.Proveedor;
import com.mybatis.vo.Usuario;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.CellEditEvent;
/**
 *
 * @author Melissa
 */
@ManagedBean (name="editUsuario")
@ViewScoped
public class EditUsuario implements Serializable{
private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of EditUsuario
     */
    List<Usuario> usuarios;
    List<Proveedor> proveedores;
    Usuario u = new Usuario();
    String proveedor;
    List<String> tiposUser = new ArrayList<String>();
    String tipo;
    
    public EditUsuario() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public List<String> getTiposUser() {
        return tiposUser;
    }

    public void setTiposUser(List<String> tiposUser) {
        this.tiposUser = tiposUser;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    
    
    @PostConstruct
    public void init() {
        UsuarioBO ubo = new UsuarioBO();
        usuarios = ubo.getAllUsuario();        
        tiposUser = ubo.tipoUsuario();
        
        ProveedorBO pbo = new ProveedorBO();
        proveedores = pbo.allProveedor();
        
    }
    
    public void onRowEdit(RowEditEvent event) {
        
        u = ((Usuario) event.getObject());
        
        UsuarioBO ubo = new UsuarioBO();
        int okPass = ubo.validarPassword(u);
        ubo.actualizaUsuario(u, okPass);
        FacesMessage msg = new FacesMessage("Usuario Editado: ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void darBaja(AjaxBehaviorEvent event){
    
        u = (Usuario)event.getComponent().getAttributes().get("users");
        
        UsuarioBO ubo = new UsuarioBO();
        ubo.darBajaUsuario(u);
    }
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición de Usuario Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
       
    }
}
