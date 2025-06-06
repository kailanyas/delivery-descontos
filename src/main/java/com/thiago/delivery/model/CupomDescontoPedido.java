/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.model;

/**
 *
 * @author thiag
 */
public class CupomDescontoPedido {
    private String nomeCupom;
    private double percentualDesconto = 0;
    private double valorDescontoPedido = 0;

    public CupomDescontoPedido(String nomeCupom, double percentualDesconto, double valorDescontoPedido) {
        this.nomeCupom = nomeCupom;
        this.percentualDesconto = percentualDesconto;
        this.valorDescontoPedido = valorDescontoPedido;
    }

    public String getNomeCupom() {
        return nomeCupom;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public double getValorDescontoPedido() {
        return valorDescontoPedido;
    }

    @Override
    public String toString() {
        return "CupomDescontoPedido{" + "nomeCupom=" + nomeCupom + ", percentualDesconto=" + percentualDesconto + ", valorDescontoPedido=" + valorDescontoPedido + '}';
    }
}
