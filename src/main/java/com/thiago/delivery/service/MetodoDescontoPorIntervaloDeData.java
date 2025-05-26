/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.CupomDescontoEntrega;
import com.thiago.delivery.model.Pedido;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Triple;

/**
 *
 * @author kaila
 */
public class MetodoDescontoPorIntervaloDeData implements IMetodoDescontoTaxaEntrega{
    private Map<String, Triple<LocalDate, LocalDate, Double>> descontosPorIntervaloData = new HashMap<>();
    
    public MetodoDescontoPorIntervaloDeData(){
        descontosPorIntervaloData.put("Intervalo1", Triple.of(LocalDate.of(2025, 05, 22), LocalDate.of(2025, 05, 27), 1.0));
        descontosPorIntervaloData.put("Intervalo2", Triple.of(LocalDate.of(2025, 06, 16), LocalDate.of(2025, 06, 16), 0.6));
        descontosPorIntervaloData.put("Intervalo3", Triple.of(LocalDate.of(2025, 05, 25), LocalDate.of(2025, 05, 25), 0.5));
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        LocalDate dataPedido = pedido.getData();
        double maiorPercentual = 0.0;
        
        for(Triple<LocalDate, LocalDate, Double> intervalo: descontosPorIntervaloData.values()){
            LocalDate dataInicio = intervalo.getLeft();
            LocalDate dataFim = intervalo.getMiddle();
            double percentualDesconto = intervalo.getRight();
                
            if(((dataPedido.equals(dataInicio) || dataPedido.isAfter(dataInicio)) && ((dataPedido.equals(dataFim)) || (dataPedido.isBefore(dataFim))))){
                if(percentualDesconto > maiorPercentual){
                    maiorPercentual = percentualDesconto;
                }
            }    
        }
        
        if(maiorPercentual > 0.0){
            double taxaEntrega = pedido.getTaxaEntrega();
            pedido.aplicarDesconto(new CupomDescontoEntrega("Cupom por intervalo de data", (taxaEntrega * maiorPercentual)));
        }     
    }

    @Override
    public boolean seAplica(Pedido pedido){
        LocalDate dataPedido = pedido.getData();
        
        for(Triple<LocalDate, LocalDate, Double> intervalo: descontosPorIntervaloData.values()){
            LocalDate dataInicio = intervalo.getLeft();
            LocalDate dataFim = intervalo.getMiddle();
           
            if(((dataPedido.equals(dataInicio) || dataPedido.isAfter(dataInicio)) && ((dataPedido.equals(dataFim)) || (dataPedido.isBefore(dataFim))))){
                return true;
            }
        }
        return false;
    }
} 
   