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
    
    private List<Usuario> listar() throws FileNotFoundException, IOException, ClassNotFoundException {
        if (arquivo.length()>0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            return (List<Usuario>) in.readObject();
        }
        else{
            return new ArrayList<>();
        }
    }
    
    public boolean adicionarUsuario(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        if (usuarios.add(u)){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(usuarios);
            out.close();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean removerUsuario(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        if (usuarios.remove(u)){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(usuarios);
            return true;
        }
        else{
            return false;
        }        
    }

    
    
}
