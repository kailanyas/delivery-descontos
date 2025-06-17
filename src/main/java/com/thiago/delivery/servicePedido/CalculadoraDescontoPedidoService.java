/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.servicePedido;

import com.thiago.delivery.model.Pedido;

/**
 *
 * @author thiago.silva.66
 */
public class CalculadoraDescontoPedidoService {
    
    
    public void calcularDesconto(IMetodoDescontoPedido regraDesconto, Pedido pedido){
        if (regraDesconto == null) {
            throw new IllegalArgumentException("Informe uma regra de desconto válida!");
        }
        if (pedido == null) {
            throw new IllegalArgumentException("Informe um pedido válido!");
        }

        if (pedido.getValorTotalPedido() == 0) {
            throw new IllegalArgumentException("Não é possível aplicar descontos em pedidos com valor total = 0");
        }
        regraDesconto.calcularDesconto(pedido);
    }
}
