/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class Pedido {
    private double taxaEntrega = 10;
    private final LocalDate data;
    private List<Item> itens = new ArrayList<>();
    private Cliente cliente;
    private List<CupomDescontoEntrega> cupons = new ArrayList<>();
    
    public Pedido (LocalDate data, Cliente cliente){
        this.cliente = cliente;
        this.data = data;
    }
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public double getValorPedido(){
        return taxaEntrega;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public List<Item> getItens(){
        return this.itens;
    }
    
    public double getTaxaEntrega(){
        return this.taxaEntrega;
        
    }

    public LocalDate getData() {
        return data;
    }
    
    public void aplicarDesconto(CupomDescontoEntrega desconto){
       double descontoDisponivel = 10.0 - getDescontoConcedido();
       
       if(descontoDisponivel <= 0){
           return;
       }

       double valorDesconto = desconto.getValorDesconto();
       double valorFinal = Math.min(valorDesconto, descontoDisponivel);
        
       if (valorFinal < valorDesconto) {
           new CupomDescontoEntrega(desconto.getNomeMetodo() + " (parcial)", valorFinal);
       }

        taxaEntrega -= valorFinal;
    }
    
    public double getDescontoConcedido(){
        return (10 - taxaEntrega);
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return this.cupons;
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + '}';
    }

}
