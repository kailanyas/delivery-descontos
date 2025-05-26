/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.CupomDescontoEntrega;
import com.thiago.delivery.model.Pedido;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thiag
 */
public class MetodoDescontoTaxaPorTipoCliente implements IMetodoDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoCliente;
    
    public MetodoDescontoTaxaPorTipoCliente(){
        descontosPorTipoCliente = new HashMap();
        descontosPorTipoCliente.put("Bronze", 1.00);
        descontosPorTipoCliente.put("Prata", 2.00);
        descontosPorTipoCliente.put("Ouro", 3.00);
    }
    
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por tipo de cliente", descontosPorTipoCliente.get(pedido.getCliente().getTipo())));
    }

    @Override
    public boolean seAplica(Pedido pedido){
            return descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
}
