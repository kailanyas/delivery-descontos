/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thiago.delivery;
import com.thiago.delivery.model.Cliente;
import com.thiago.delivery.model.Item;
import com.thiago.delivery.model.Pedido;
import com.thiago.delivery.service.CalculadoraDeDescontoService;
import com.thiago.delivery.servicePedido.CalculadoraDescontoPedidoService;
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
        CalculadoraDescontoPedidoService calculadoraPedido;
        
        Cliente cliente1 = new Cliente("Ana Claudia", "Ouro", 1, "Rua das Flores", "Centro", "Alegre");
        Item item1 = new Item("Livro UML", 1, 100.0, "Educação");
        Pedido pedido1 = new Pedido(LocalDate.now(), cliente1);
        
        pedido1.adicionarItem(item1);
        
        
        
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
        while(true){
            System.out.println("Digite o cupom: ");
            String cupomDigitado = scanner.nextLine();
            calculadoraPedido = new CalculadoraDescontoPedidoService();
            calculadoraPedido.calcularDesconto(pedido1, cupomDigitado);
            System.out.println("Valor da taxa de entrega com descontos: " + pedido1.toString());
            System.out.println("Digite 1 para finalizar a compra, 2 para alterar o cupom e 3 para sair: ");
            String numeroDigitado = scanner.nextLine();
            if(numeroDigitado.equals("1")){
                System.out.println("Compra efetuada! ");
                break;
            }
            else if (numeroDigitado.equals("3")){
                System.out.println("Encerrando... ");
                break;
            }
        }
    }
}
