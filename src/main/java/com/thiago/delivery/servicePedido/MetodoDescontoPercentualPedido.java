/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.servicePedido;
import com.thiago.delivery.model.CupomDescontoPedido;
import com.thiago.delivery.model.Pedido;
import com.thiago.delivery.repository.CupomDescontoRepository;
import com.thiago.delivery.servicePedido.IMetodoDescontoPedido;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author thiago.silva.66
 */
public class MetodoDescontoPercentualPedido implements IMetodoDescontoPedido{
    private Map<String, Double> descontosPercentualPedido = new HashMap<>(); 
    private CupomDescontoPedido novoCupom;
    
    public MetodoDescontoPercentualPedido(CupomDescontoRepository cupomRepository, CupomDescontoPedido novoCupom){
        cupomRepository.validaCupom(novoCupom.getNomeCupom());
        this.novoCupom = novoCupom;
    }
    
    @Override
    public void calcularDesconto(Pedido pedido){
        double valorTotalPedido = pedido.getValorPedido(); 
        double valorDesconto = valorTotalPedido * (novoCupom.getPercentualDesconto() / 100);        

        novoCupom.setValorDescontoPedido(valorDesconto);

        CupomDescontoPedido cupomExistente = pedido.getCupomDescontoPedido();

        if (cupomExistente == null) {
            pedido.setCupomDescontoPedido(novoCupom);
            return;
        }

        if (novoCupom.getPercentualDesconto() > cupomExistente.getPercentualDesconto()) {
            pedido.setCupomDescontoPedido(novoCupom);
        }
    }

}

public clas PrincipalSolucaoDescontoPedido {
    public static void main(String[] args) {
        try {
            // Cria cliente ...
            Pedido pedido = new Pedido()...
            // Adiciona itens ...

            // Executa calculadora de desconto na taxa de entrega

            CalculadoraDeDescontoPedidoService calculadoraDescontoPedido =
                     new CalculadoraDeDescontoPedidoService();

            CupomDesconto cupom = new CupomDesconto("DESC10", 0.10);

            CupomDescontoRepository cupomRepository = new CupomDescontoRepository();

            IRegraDesconto regraDesconto = new RegraDescontoPorCupom(cupomRepository, cupom);
           
            calculadoraDescontoPedido.aplicarDesconto(regraDesconto, pedido);

        } catch (Exception e) {
            System.out.println("Falha: " + e.getMessage());
    }
}

public class CalculadoraDeDescontoPedidoService {

    public void aplicarDesconto(IRegraDesconto regraDesconto, Pedido pedido) {
        if (regraDesconto == null) {
            throw new IllegalArgumentException("Informe uma regra de desconto válida!");
        }
        if (pedido == null) {
            throw new IllegalArgumentException("Informe um pedido válido!");
        }

        if (pedido.getValor == 0) {
            throw new IllegalArgumentException("Não é possível aplicar descontos em pedidos com valor total = 0");
        }

        regraDesconto.calcular(pedido);
    }
}
