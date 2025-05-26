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
public class MetodoDescontoTaxaPorBairro implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorBairro;
    
    public MetodoDescontoTaxaPorBairro(){
        descontosPorBairro = new HashMap();
        descontosPorBairro.put("Centro", 2.00);
        descontosPorBairro.put("Bela Vista", 3.00);
        descontosPorBairro.put("Cidade Maravilhosa", 1.50);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        pedido.aplicarDesconto(new CupomDescontoEntrega("Cupom por bairro = " + pedido.getCliente().getBairro(), descontosPorBairro.get(pedido.getCliente().getBairro())));
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        return descontosPorBairro.containsKey(pedido.getCliente().getBairro());
    }
}
