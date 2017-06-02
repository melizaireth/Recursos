/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis.dao;

import com.entities.Usuario;

/**
 *
 * @author Melissa
 */
public interface UsuarioDAO {
    //public void crearUsuario(UsuarioVO uvo);
    public void modificarUsuario(Usuario uvo);
    public void usuarioByID();
    
}
