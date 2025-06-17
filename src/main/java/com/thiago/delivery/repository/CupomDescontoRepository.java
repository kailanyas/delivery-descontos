/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thiago.delivery.repository;

import com.thiago.delivery.model.CupomDescontoPedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class CupomDescontoRepository {
    private List<CupomDescontoPedido> cuponsValidos = new ArrayList<>();

    public CupomDescontoRepository() {
        cuponsValidos.add(new CupomDescontoPedido("NATALFELIZ", 10));
        cuponsValidos.add(new CupomDescontoPedido("DIANAM15", 15));        
        cuponsValidos.add(new CupomDescontoPedido("DESC10", 10));                        
        cuponsValidos.add(new CupomDescontoPedido("DESC20", 20));                        
    }

    public void validaCupom(String codigoCupom) {
        for(CupomDescontoPedido cupom: cuponsValidos) {
            if (cupom.getNomeCupom().equals(codigoCupom)) {
                return;
            }
        }
        throw new IllegalArgumentException("O cupom informado náo é válido! " + "\nCodigo informado: " + codigoCupom);
    }

}
