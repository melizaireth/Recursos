/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis.dao;

import com.mybatis.vo.Oferta;

/**
 *
 * @author Melissa
 */
public interface OfertaDAO {
    public void crearOferta(Oferta oferta);
    public void modificarOferta(Oferta oferta);
}