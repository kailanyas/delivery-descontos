/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.servicePedido;
import com.thiago.delivery.model.CupomDescontoPedido;
import com.thiago.delivery.model.Pedido;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author thiago.silva.66
 */
public class MetodoDescontoPercentualPedido implements IMetodoDescontoPedido{
    private Map<String, Double> descontosPercentualPedido = new HashMap<>(); 
    
    public MetodoDescontoPercentualPedido(){
        descontosPercentualPedido.put("DESC10", 10.0);
        descontosPercentualPedido.put("DESC20", 20.0);
        descontosPercentualPedido.put("DESC30", 30.0);
        descontosPercentualPedido.put("NATAL12", 12.0);
        descontosPercentualPedido.put("DIAPAIS12", 12.0);
        descontosPercentualPedido.put("PROMO10", 10.0);
        descontosPercentualPedido.put("DIAMAES15", 15.0);
        descontosPercentualPedido.put("RELAMPAGO50", 50.0);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido, String cupomDigitado){
        double valorTotalPedido = pedido.getValorPedido(); 
        pedido.aplicarDescontoPedido(new CupomDescontoPedido(cupomDigitado, descontosPercentualPedido.get(cupomDigitado), 
                                                            ((descontosPercentualPedido.get(cupomDigitado)/100) * valorTotalPedido)));

    }
}
