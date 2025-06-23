/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.servicePedido;

import com.thiago.delivery.model.Pedido;

import java.util.List;

/**
 *
 * @author thiago.silva.66
 */
public class CalculadoraDescontoPedidoService {
    
    
    public void calcularDesconto(List<IMetodoDescontoPedido> regrasDesconto, Pedido pedido){
        if (regrasDesconto == null || regrasDesconto.isEmpty()){
            throw new IllegalArgumentException("Informe uma regra de desconto válida!");
        }
        if (pedido == null) {
            throw new IllegalArgumentException("Informe um pedido válido!");
        }

        if (pedido.getValorTotalPedido() == 0) {
            throw new IllegalArgumentException("Não é possível aplicar descontos em pedidos com valor total = 0");
        }

        for(IMetodoDescontoPedido regraDesconto: regrasDesconto){
            regraDesconto.calcularDesconto(pedido);
        }
    }
}
