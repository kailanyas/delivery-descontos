/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thiago.delivery;
import com.thiago.delivery.model.Cliente;
import com.thiago.delivery.model.Item;
import com.thiago.delivery.model.Pedido;
import com.thiago.delivery.service.CalculadoraDeDescontoService;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class Delivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDeDescontoService calculadora = new CalculadoraDeDescontoService();
        
        Cliente cliente1 = new Cliente("Ana Claudia", "Ouro", 1, "Rua das Flores", "Centro", "Alegre");
        Item item1 = new Item("Livro UML", 1, 300.0, "Educação");
        Pedido pedido1 = new Pedido(LocalDate.now(), cliente1);
        
        pedido1.adicionarItem(item1);
        
        System.out.println("Dados do cliente: " + cliente1.toString());
        System.out.println("Valor da taxa de entrega: " + pedido1.toString());
        
        System.out.println("Deseja aplicar descontos na taxa de entrega? (s/n) ");
        String resposta = scanner.nextLine();
        
        if(resposta.equals("s")){
            calculadora.calcularDesconto(pedido1);
            System.out.println("Valor da taxa de entrega com descontos: " + pedido1.toString()); 
        }      
    }
}
