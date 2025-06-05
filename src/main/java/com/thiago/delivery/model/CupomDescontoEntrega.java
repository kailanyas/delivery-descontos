/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.model;

/**
 *
 * @author thiag
 */
public class CupomDescontoEntrega {
    private String nomeMetodo;
    private double valorDesconto = 0;

    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto) {
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" + "nomeMetodo=" + nomeMetodo + ", valorDesconto=" + valorDesconto + '}';
    }

}
