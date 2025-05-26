/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.service;

import com.thiago.delivery.model.Pedido;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author thiag
 */
public class CalculadoraDeDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDeDesconto;
    
    public CalculadoraDeDescontoService(){
        metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(new MetodoDescontoTaxaPorBairro());
	metodosDeDesconto.add(new MetodoDescontoTaxaPorTipoCliente());
	metodosDeDesconto.add(new MetodoDescontoTipoItem());
	metodosDeDesconto.add(new MetodoDescontoValorPedido()); 
        metodosDeDesconto.add(new MetodoDescontoPorDiaDaSemana());
        metodosDeDesconto.add(new MetodoDescontoPorIntervaloDeData());
    }
        
    public void calcularDesconto(Pedido pedido){
        for(IMetodoDescontoTaxaEntrega metodosDescontoTaxaEntrega: metodosDeDesconto){
            if(pedido.getDescontoConcedido() < 10.0){
                if(metodosDescontoTaxaEntrega.seAplica(pedido)){
                    metodosDescontoTaxaEntrega.calcularDesconto(pedido);
                }
            }
        }
    }
}
