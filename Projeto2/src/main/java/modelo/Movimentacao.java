/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author glaykiere
 */
public class Movimentacao implements Serializable{
    private static int cont;
    private final int codigo;
    private String descricao;
    private Date dataMov;
    private float valor;
    private String tipo;
    private String categoria;
    
    public Movimentacao(){
        this.codigo = ++cont;
    }

    public Movimentacao(String descricao, Date dataMov, float valor, String tipo, String categoria) {
        this.codigo = ++cont;
        this.descricao = descricao;
        this.dataMov = dataMov;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataMov() {
        return dataMov;
    }

    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.dataMov);
        hash = 47 * hash + Float.floatToIntBits(this.valor);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimentacao other = (Movimentacao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.dataMov, other.dataMov)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimentacao{" + "codigo=" + codigo + ", descricao=" + descricao + ", dataMov=" + new SimpleDateFormat("dd/MM/yyyy").format(dataMov) + ", valor=" + valor + ", tipo=" + tipo + ", categoria=" + categoria + '}';
    }
    
    
    
}
