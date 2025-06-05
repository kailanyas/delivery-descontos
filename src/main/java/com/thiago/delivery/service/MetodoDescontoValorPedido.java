/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.CupomDescontoEntrega;
import com.thiago.delivery.model.Pedido;

/**
 *
 * @author thiag
 */
public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    private final static double VALOR_DESCONTO = 5.0;

    public MetodoDescontoValorPedido() {
 
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Cupom por valor do pedido", VALOR_DESCONTO));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido.getValorPedido() > 200.0){
            return true;
        }
        return false;
    }
}
