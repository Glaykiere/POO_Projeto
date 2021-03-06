/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author glaykiere
 */
public class Usuario implements Serializable{
    private String email;
    private String nome;
    private Date nascimento;
    private String sexo;
    private String senha;
    private List<Movimentacao> movimentacao;

    public Usuario() {        
    } 
    
    public Usuario(String email, String nome, Date nascimento, String sexo, String senha) {
        this.email = email;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.senha = senha;
        this.movimentacao = new ArrayList<>();
    }   
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<Movimentacao> getMovimentacao(){
        return movimentacao; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.nascimento);
        hash = 17 * hash + Objects.hashCode(this.sexo);
        hash = 17 * hash + Objects.hashCode(this.senha);
        hash = 17 * hash + Objects.hashCode(this.movimentacao);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.movimentacao, other.movimentacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nome=" + nome + ", nascimento=" + new SimpleDateFormat("dd/MM/yyyy").format(nascimento) + ", sexo=" + sexo + ", senha=" + senha + ", movimentacao=" + movimentacao + '}';
    }
    
    public boolean adicionaMovimentacao(Movimentacao m){
        Movimentacao mov = buscar(m.getCodigo());
        if (mov == null){
            return movimentacao.add(m);
        }
        else{
            return false;
        }
    }
    
    public Movimentacao buscar(int cod){
        for(Movimentacao m : this.movimentacao){
            if (m.getCodigo() == cod){
                return m;
            }
        }
        return null;
    }
    
    public boolean atualizaMovimentacao(Movimentacao m){
        List<Movimentacao> movimentacoes = this.movimentacao;
        for (int i = 0; i < movimentacoes.size(); i++){
           if(m.getCodigo() == movimentacoes.get(i).getCodigo()){
               movimentacoes.set(i, m);
               return true;
           }
        }
        return false;
    } 
    
    public boolean autenticar(String email, String senha){
        return this.email.equals(email) && this.senha.equals(senha);
    }
    
    
    
    
    
}
