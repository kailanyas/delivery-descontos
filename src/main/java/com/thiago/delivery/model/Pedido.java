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
    private double taxaEntrega = 10.00;
    private final LocalDate data;
    private List<Item> itens = new ArrayList<>();
    private Cliente cliente;
    private List<CupomDescontoEntrega> cupons = new ArrayList<>();
    private CupomDescontoPedido cupomPedido;
    private double valorTotalPedido = 0;
    
    public Pedido (LocalDate data, Cliente cliente){
        this.cliente = cliente;
        this.data = data;
    }
    public void adicionarItem(Item item){
        itens.add(item);
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
    
    public void aplicarDescontoEntrega(CupomDescontoEntrega desconto){
        double descontoDisponivel = 10.0 - getDescontoConcedido();
        
        if(descontoDisponivel <= 0){
            return;
        }
        else{
            if(desconto.getValorDesconto() <= descontoDisponivel){
                cupons.add(desconto);
                taxaEntrega -= desconto.getValorDesconto();
            }
            else {
                cupons.add(desconto);
                taxaEntrega -= descontoDisponivel;
            }
        }
    }

    public double getDescontoConcedido(){
        return (10.00 - getTaxaEntrega());
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return this.cupons;
    }
    
    public CupomDescontoPedido getCupomDescontoPedido(){
        return this.cupomPedido;
    }

    public double calculaValorTotalItens(){
        double total = 0;
        for(Item item : itens){
            total += item.getValorTotal();
        }
        return total;
    }

    public double getValorTotalPedido(){
       valorTotalPedido = calculaValorTotalItens();
       return valorTotalPedido + taxaEntrega;
    }

    public void aplicarDescontoPedido(CupomDescontoPedido desconto){
        valorTotalPedido -= desconto.getValorDescontoPedido();
    }

    public void setCupomDescontoPedido(CupomDescontoPedido cupomPedido){
        this.cupomPedido = cupomPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + getTaxaEntrega() + ", cupomPedido=" + cupomPedido + ", valorTotalPedido=" + valorTotalPedido + '}';
    }
    
}
