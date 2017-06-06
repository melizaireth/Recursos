/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis.dao;

import com.mybatis.vo.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Melissa
 */
public interface UsuarioDAO {
    public String USER_FRONT_FACTURA = "Front Facturación";
    public String USER_FRONT_RECURSO = "Front Recursos";
    public String USER_BACK_FACTURA = "Back Facturación";
    public String USER_BACK_RECURSO = "Back Recursos";
            
    @Insert("CREAR_USUARIO")
    public void crearUsuario(Usuario u);
   // public void modificarUsuario(Usuario uvo);
   // public void usuarioByID();
    public List<String> tipoUsuario();
    
    @Select("VERIFICA_LOGIN")
    public int verificarLogin(Usuario u);
    
    @Select("ALL_USUARIOS")
    public List<Usuario> getAllUsuario();
    
    @Select("GET_USER_BY_ID")
    public int validarPassword(Usuario u);
    
    @Update("UPDATE_USUARIO")
    public int actualizaUsuario(Usuario u, int okPass);
    
    @Update("DAR_BAJA_USUARIO")
    public int darBajaUsuario(Usuario u);
}
