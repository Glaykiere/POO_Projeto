/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glaykiere
 */
public class Cadastro {
    List<Usuario> usuarios;
   
    
    public Cadastro(){
        usuarios = new ArrayList<>();
    }
    
    
    public boolean adicionar(Usuario u){
        return usuarios.add(u);
    }
    
    
    
        
    public boolean remover(Usuario u){
        return usuarios.remove(u);
    }
    
    public Usuario buscar(String login){
        for (Usuario u: usuarios){
            if(u.getLogin().equals(login)){
                return u;
            }
        }
        return null;
    }
        
    public boolean atualizar(Usuario u){
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getLogin().equals(u.getLogin())){
                usuarios.set(i, u);
                return true;
            }
        }
        return false;
    }  
    

}
