/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thiago.delivery;
import com.thiago.delivery.servicePedido.MetodoDescontoPercentualPedido;
import com.thiago.delivery.model.Cliente;
import com.thiago.delivery.model.CupomDescontoPedido;
import com.thiago.delivery.model.Item;
import com.thiago.delivery.model.Pedido;
import com.thiago.delivery.repository.CupomDescontoRepository;
import com.thiago.delivery.service.CalculadoraDeDescontoService;
import com.thiago.delivery.servicePedido.CalculadoraDescontoPedidoService;
import com.thiago.delivery.servicePedido.IMetodoDescontoPedido;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class Delivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDeDescontoService calculadora;
        CalculadoraDescontoPedidoService calculadoraPedido = new CalculadoraDescontoPedidoService();
        
        try { 
            Cliente cliente1 = new Cliente("Ana Claudia", "Ouro", 1, "Rua das Flores", "Centro", "Alegre");
            Item item1 = new Item("Livro UML", 1, 100.0, "Educação");
            Pedido pedido1 = new Pedido(LocalDate.now(), cliente1);
            pedido1.adicionarItem(item1);
 
            CupomDescontoPedido cupom = new CupomDescontoPedido("DESC10", 10);
            
            CupomDescontoRepository cupomRepository = new CupomDescontoRepository();

            IMetodoDescontoPedido regraDesconto = new MetodoDescontoPercentualPedido(cupomRepository, cupom);
           
            System.out.println("Deseja aplicar descontos na taxa de entrega? (s/n) ");
            String resposta = scanner.nextLine();
                //System.out.println("\nDados do cliente: " + cliente1.toString());
            if(resposta.equals("s")){
                calculadora = new CalculadoraDeDescontoService(true);
                calculadora.calcularDesconto(pedido1);
                System.out.println("Valor da taxa de entrega com descontos: " + pedido1.getTaxaEntrega()); 
            }
            else{
                System.out.println("Valor da taxa de entrega: " + pedido1.getTaxaEntrega());
            }
            calculadoraPedido.calcularDesconto(regraDesconto, pedido1);
            System.out.println("Valor do pedido total com descontos: " + pedido1.toString());
        } 
        catch (Exception e) {
            System.out.println("Falha: " + e.getMessage());
        }
    }
}
