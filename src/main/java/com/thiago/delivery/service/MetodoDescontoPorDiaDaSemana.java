/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.CupomDescontoEntrega;
import com.thiago.delivery.model.Pedido;
import java.time.DayOfWeek;

/**
 *
 * @author kaila
 */
public class MetodoDescontoPorDiaDaSemana implements IMetodoDescontoTaxaEntrega{

    public MetodoDescontoPorDiaDaSemana(){
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        DayOfWeek diaSemanaPedido = pedido.getData().getDayOfWeek();
        double taxaEntrega = pedido.getTaxaEntrega();
        
        if(diaSemanaPedido == DayOfWeek.TUESDAY){
            pedido.aplicarDesconto(new CupomDescontoEntrega("Cupom por dia da semana: Terça-Feira", taxaEntrega));
        }
        else if(diaSemanaPedido == DayOfWeek.THURSDAY){
            pedido.aplicarDesconto(new CupomDescontoEntrega("Cupom por dia da semana: Quinta-Feira", (taxaEntrega * 0.6)));
        }
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        DayOfWeek diaSemanaPedido = pedido.getData().getDayOfWeek();
        
        if(diaSemanaPedido == DayOfWeek.TUESDAY || diaSemanaPedido == DayOfWeek.THURSDAY){
            return true;
        }
        return false;
    }
}
