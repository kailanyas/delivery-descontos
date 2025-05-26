/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.model;

/**
 *
 * @author thiag
 */
public class Item {
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private String tipo;

    public Item(String nome, int quantidade, double valorUnitario, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }
    
    public double getValorTotal() {
        return (valorUnitario*quantidade);
    }
    
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Item{" + "nome=" + nome + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", tipo=" + tipo + '}';
    }
}
