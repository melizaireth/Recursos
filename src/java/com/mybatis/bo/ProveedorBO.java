/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis.bo;

import com.mybatis.bd.MapperUtil;
import com.mybatis.dao.ProveedorDAO;
import com.mybatis.vo.Proveedor;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Melissa
 */
public class ProveedorBO implements ProveedorDAO{

    @Override
    public void guadarProveedor(Proveedor p) {
         SqlSession session = new MapperUtil().getSession();
         if(session!=null){
            try{
                
                session.insert("com.mybatis.dao.ProveedorDAO.CREAR_PROVEEDOR", p);
                
                session.commit();
            }finally{
                session.close();
            }
        }else{
            //enviar mensaje
        }
    }

    @Override
    public List<Proveedor> allProveedor() {
        SqlSession session = new MapperUtil().getSession();
        List<Proveedor> p = new ArrayList<Proveedor>();
        if(session!=null){
            try{
                
                p = session.selectList("com.mybatis.dao.ProveedorDAO.ALL_PROVEEDORES");                
                
            }finally{
                session.close();
            }
        }else{
            //enviar mensaje
        }
        return p;
    }
    
    
    
}
