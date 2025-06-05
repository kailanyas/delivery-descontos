/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.servicePedido;

import com.thiago.delivery.model.Pedido;
import com.thiago.delivery.servicePedido.IMetodoDescontoPedido;
import com.thiago.delivery.servicePedido.MetodoDescontoPercentualPedido;

/**
 *
 * @author thiago.silva.66
 */
public class CalculadoraDescontoPedidoService {
    private IMetodoDescontoPedido metodoDescontoPedido;

    public CalculadoraDescontoPedidoService(){
        metodoDescontoPedido = new MetodoDescontoPercentualPedido();
    }
    
    public void calcularDesconto(Pedido pedido, String cupomDigitado){
        metodoDescontoPedido.calcularDesconto(pedido, cupomDigitado);
    }
}
