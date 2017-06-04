/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.mybatis.vo.Usuario;
import com.mybatis.bo.ProveedorBO;
import com.mybatis.bo.UsuarioBO;
import com.mybatis.vo.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Melissa
 */
@ManagedBean(name = "user")
@RequestScoped
public class UsuarioBeans {

    /**
     * Creates a new instance of UsuarioBeans
     */
    Usuario u = new Usuario();
    List<Proveedor> lp = new ArrayList<Proveedor>();
    List<String> tiposUser = new ArrayList<String>();
    String tipo;
    int proveedor;
    public UsuarioBeans() {
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public List<Proveedor> getLp() {
        return lp;
    }

    public void setLp(List<Proveedor> lp) {
        this.lp = lp;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
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
       ProveedorBO pbo = new ProveedorBO();
       lp = pbo.allProveedor();     
       UsuarioBO ubo = new UsuarioBO();
       tiposUser = ubo.tipoUsuario();
    }
    public void nuevoUsuario(){
        //En este metodo debemos verificar que el login no exista
        u.setIdproveedor(proveedor);
        u.setDepartamento(tipo);
        System.out.println("Proveedor: "+proveedor);
        System.out.println("Tipo: "+tipo);
        u.setIdusuario(-1);
        UsuarioBO ubo = new UsuarioBO();
        int ok = ubo.verificarLogin(u);
        System.out.println("Valor de la verificacion: "+ok);
        if(ok==0){
            System.out.println("Va a crear el usuario:" +u);
            ubo.crearUsuario(u);
        }else{
            //retorno respuesta
        }
    
    }
}
