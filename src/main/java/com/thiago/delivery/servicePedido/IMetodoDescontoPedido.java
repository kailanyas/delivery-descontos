/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thiago.delivery.servicePedido;

import com.thiago.delivery.model.Pedido;

/**
 *
 * @author thiago.silva.66
 */
public interface IMetodoDescontoPedido {
    public void calcularDesconto(Pedido pedido, String cupomDigitado);
}
