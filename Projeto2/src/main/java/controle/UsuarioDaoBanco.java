/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import banco.ConFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author glaykiere
 */
public class UsuarioDaoBanco {
    private Connection con;
    
    public UsuarioDaoBanco() throws ClassNotFoundException, SQLException{
        con = new ConFactory().getConnection();
    }
    
    public boolean addUsuario(Usuario u) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("insert into usuario(email, nome, nascimento, sexo, senha) values(?,?,?,?,?)");
        stmt.setString(1, u.getEmail());
        stmt.setString(2, u.getNome());
        stmt.setString(3, new  SimpleDateFormat("dd/MM/yyyy").format(u.getNascimento()) );
        stmt.setString(0, u.getSexo());
        stmt.setString(5, u.getSenha());
        
        return stmt.executeUpdate() > 0;
        
    }
    
    public List<Usuario> listar() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from usuario");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Usuario u = new Usuario();
            u.setEmail(rs.getString(1));
            u.setNome(rs.getString(2));
            u.setNascimento(rs.getDate(3));
            u.setSenha(rs.getString(4));
            u.setSenha(rs.getString(5));
            
        }
        return usuarios;
        
    }
    
    public boolean atualizar(Usuario u) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("update usuario set nome = '?', nascimento = '?', sexo = '?', senha = '?'");
        stmt.setString(1, u.getNome());
        stmt.setString(2, new SimpleDateFormat("dd/MM/yyyy").format(u.getNascimento()));
        stmt.setString(3, u.getSexo());
        stmt.setString(4, u.getSenha());
        
        return stmt.executeUpdate() > 0;
        
    }
    
    
    
    
}
