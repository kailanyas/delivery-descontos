package com.thiago.delivery.servicePedido;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.thiago.delivery.model.CupomDescontoPedido;
import com.thiago.delivery.model.Pedido;
import com.thiago.delivery.repository.CupomDescontoRepository;
import com.thiago.delivery.servicePedido.IMetodoDescontoPedido;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author thiago.silva.66
 */
public class MetodoDescontoPercentualPedido implements IMetodoDescontoPedido{ 
    private CupomDescontoPedido novoCupom;
    
    public MetodoDescontoPercentualPedido(CupomDescontoRepository cupomRepository, CupomDescontoPedido novoCupom){
        cupomRepository.validaCupom(novoCupom.getNomeCupom());
        this.novoCupom = novoCupom;
    }
    
    @Override
    public void calcularDesconto(Pedido pedido){
        double valorTotalPedido = pedido.getValorTotalPedido(); 
        double valorDesconto = valorTotalPedido * (novoCupom.getPercentualDesconto() / 100);        

        novoCupom.setValorDescontoPedido(valorDesconto);

        CupomDescontoPedido cupomExistente = pedido.getCupomDescontoPedido();

        if (cupomExistente == null) {
            pedido.setCupomDescontoPedido(novoCupom);
            return;
        }

        if (novoCupom.getPercentualDesconto() > cupomExistente.getPercentualDesconto()) {
            pedido.setCupomDescontoPedido(novoCupom);
        }
    }

}

