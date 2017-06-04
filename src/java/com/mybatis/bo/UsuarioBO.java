/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis.bo;

import com.entities.Usuario;
import com.mybatis.bd.MapperUtil;
import com.mybatis.dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Melissa
 */
public class UsuarioBO implements UsuarioDAO{

    @Override
    public List<String> tipoUsuario() {
        List<String> tipo = new ArrayList<String>();
        tipo.add(USER_FRONT_FACTURA);
        tipo.add(USER_FRONT_RECURSO);
        tipo.add(USER_BACK_FACTURA);
        tipo.add(USER_BACK_RECURSO);
        return tipo;
    }

    @Override
    public int verificarLogin(Usuario u) {
        SqlSession session = new MapperUtil().getSession();
        int ok = 0;
        Usuario usuario = new Usuario();
        if(session!=null){
            try{
                
                usuario =  session.selectOne("com.mybatis.dao.UsuarioDAO.", u);               
                if(usuario!=null){
                    ok = 1;
                }
              
            }finally{
                session.close();
            }
        }else{
            //enviar mensaje
        }
        return ok;
    }

    @Override
    public void crearUsuario(Usuario u) {
        SqlSession session = new MapperUtil().getSession();
        if(session!=null){
            try{
                u.setPassword(DigestUtils.md5Hex(u.getPassword()));
                session.insert("com.mybatis.dao.UsuarioDAO.CREAR_USUARIO", u);
                
                session.commit();
            }finally{
                session.close();
            }
        }else{
            //enviar mensaje
        }
    }
    
}
