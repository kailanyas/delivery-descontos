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
                cupons.add(new CupomDescontoEntrega(desconto.getNomeMetodo() + " (parcial)", desconto.getValorDesconto()));
                taxaEntrega -= descontoDisponivel;
            }
        }
    }
    
    public void aplicarDescontoPedido(CupomDescontoPedido desconto){
        
        if(cupomPedido == null){
            valorTotalPedido = getValorPedido();
            double valorDescontoPedido = desconto.getValorDescontoPedido();
            cupomPedido = desconto;
            valorTotalPedido -= valorDescontoPedido;
        }
        else if(desconto.getPercentualDesconto() > cupomPedido.getPercentualDesconto()){
            valorTotalPedido = getValorPedido();
            double valorDescontoPedido = desconto.getValorDescontoPedido();
            cupomPedido = desconto;
            valorTotalPedido -= valorDescontoPedido;
        }
        else {
            System.out.println("Já existe um cupom de percentual maior aplicado");
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

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + getTaxaEntrega() + ", cupomPedido=" + cupomPedido + ", valorTotalPedido=" + valorTotalPedido + '}';
    }

    
    public double getValorPedido(){  
        double valorTotal = 0;
        for(Item item : itens){
            valorTotal += item.getValorTotal();
        }
        return valorTotal+taxaEntrega;
    }
    
}
