/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbeans;

import com.mybatis.vo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import com.mybatis.bo.SessionUtils;
import com.mybatis.dao.UsuarioDAO;
import java.io.Serializable;

/**
 *
 * @author Melissa
 */
@ManagedBean(name = "log")
@SessionScoped
public class LoginBens implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of LoginBens
     */
    public LoginBens() {
    }
    String username;
    
    String password;

    String perfil;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String actionValidar(){
		
		Usuario u = new Usuario();
		
		//perfil = u.getUserByUserId(username, password);				
		
		
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("username", username);
		session.setAttribute("profile", perfil);
		if(perfil.equals(UsuarioDAO.USER_BACK_FACTURA) || perfil.equals(UsuarioDAO.USER_BACK_RECURSO)){
			return "backoffice";
		}else{
			if(perfil.equals(UsuarioDAO.USER_FRONT_FACTURA) || perfil.equals(UsuarioDAO.USER_FRONT_RECURSO)){
				return "frontoffice";
			}else{
				 return "fail";
			}
		}	
		
    }
    
}
