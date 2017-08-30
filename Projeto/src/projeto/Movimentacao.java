/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glaykiere
 */
public class Movimentacao {
    
    private final String descricao;
    private final LocalDate data;
    private final float valor;
    private final String categoria;
    private final String tipo;
    

    public Movimentacao(String descricao,  LocalDate data, float valor, String categoria, String tipo) {
        this.descricao = descricao;        
        this.data = data;
        this.valor = valor;
        this.categoria = categoria;
        this.tipo = tipo;
        
        
    }
           

    @Override
    public String toString() {
        return "descricao=" + descricao + ", data=" + data + ", valor=" + valor + ", categoria=" + categoria + ", tipo=" + tipo; 
    }    
    
    
}
