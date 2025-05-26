/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.CupomDescontoEntrega;
import com.thiago.delivery.model.Item;
import com.thiago.delivery.model.Pedido;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thiag
 */
public class MetodoDescontoTipoItem implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorTipoItem = new HashMap<>();
    
    public MetodoDescontoTipoItem(){
        descontosPorTipoItem.put("Alimentação", 5.00);
        descontosPorTipoItem.put("Educação", 2.00);
        descontosPorTipoItem.put("Lazer", 1.50);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        for(Item item :pedido.getItens()){
            if(descontosPorTipoItem.containsKey(item.getTipo())){  
                pedido.aplicarDesconto(new CupomDescontoEntrega("Cupom por tipo item = " + item.getTipo() +" (" + item.getNome() + ")", descontosPorTipoItem.get(item.getTipo())));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido){
        for(Item item: pedido.getItens()){
            if(descontosPorTipoItem.containsKey(item.getTipo())){
                return true;
            }
        }
        return false;
    }
}
