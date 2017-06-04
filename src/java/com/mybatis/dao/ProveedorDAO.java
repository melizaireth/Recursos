/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis.dao;

import com.mybatis.vo.Proveedor;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/**
 *
 * @author Melissa
 */
public interface ProveedorDAO {
   
    @Insert("CREAR_PROVEEDOR")
    public void guadarProveedor(Proveedor p);
    
    @Select("ALL_PROVEEDORES")
    public List<Proveedor> allProveedor();
    
    
}
