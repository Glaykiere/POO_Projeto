/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author glaykiere
 */
public class Usuario {
    private String login;
    private String senha;
    private char sexo;
    private Date nascimento;
    private float saldo;
    final List<Movimentacao> movimentacao;

    public Usuario(String login, Date nascimento, float saldo,char sexo, String senha) {
        this.login = login;
        this.senha = senha;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.saldo = saldo;
        this.movimentacao = new ArrayList<>();
    }
    
    public boolean adicionaMovimentacao(Movimentacao m){
        return movimentacao.add(m);
    }
    public void i(){
        
    }
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.login);
        hash = 17 * hash + Objects.hashCode(this.senha);
        hash = 17 * hash + this.sexo;
        hash = 17 * hash + Objects.hashCode(this.nascimento);
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
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", sexo=" + sexo + ", nascimento=" + new SimpleDateFormat("dd/MM/yyyy").format(nascimento) + ", saldo=" + saldo + ", movimentacao=" + movimentacao + "}" + "\n";
    }
    
    
    
    
}
