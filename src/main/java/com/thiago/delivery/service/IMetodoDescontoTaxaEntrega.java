/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.CupomDescontoEntrega;
import com.thiago.delivery.model.Pedido;

/**
 *
 * @author thiag
 */
public interface IMetodoDescontoTaxaEntrega {
    public void calcularDesconto(Pedido pedido);
    
    public boolean seAplica(Pedido pedido);
}
