/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.Movimentacao;

/**
 *
 * @author glaykiere
 */
public class UsuarioDaoArquivo {
    private File arquivo;
    
    public UsuarioDaoArquivo(){
        arquivo = new File("usuario.bin");
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Falha na conexao com o arquivo", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<Usuario> listar() throws FileNotFoundException, IOException, ClassNotFoundException {
        if (arquivo.length()>0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            return (List<Usuario>) in.readObject();
        }
        else{
            return new ArrayList<>();
        }
    }
    
    public boolean addUsuario(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        Usuario user = buscar(u.getEmail());
        if (user == null){
            usuarios.add(u);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(usuarios);
            out.close();
            return true;
        }
        return false;
       
    }
    
    public boolean removerUsuario(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        Usuario user = buscar(u.getEmail());
        if (usuarios.remove(user)){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(usuarios);
            return true;
        }
        else{
            return false;
        }        
    }
    
    public boolean atualizar(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException {
        List<Usuario> usuarios = listar();
        for (int i = 0; i < usuarios.size(); i++){
            if (u.getEmail().equals(usuarios.get(i).getEmail())){
                usuarios.set(i, u);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
                out.writeObject(usuarios);
                out.close();
                return true;
            }
        }
        return false;
    }
    
    public Usuario buscar(String email) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        for (Usuario u : usuarios){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    
    public boolean atualizar(Usuario u, Movimentacao m) throws IOException, FileNotFoundException, ClassNotFoundException {
        List<Movimentacao> movimentacoes = u.getMovimentacao();
        for (int i = 0; i < movimentacoes.size(); i++){
            if (m.getDescricao().equals(movimentacoes.get(i).getDescricao())){
                movimentacoes.set(i, m);
                atualizar(u);
                return true;
            }
        }
        return false;
    }
        
    public Movimentacao buscar(Usuario u, int codigo) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Movimentacao> movimentacoes = u.getMovimentacao();
        for (Movimentacao m : movimentacoes){
            if (m.getCodigo() == codigo){
                return m;
            }
        }
        return null;
    }
    
    
}
