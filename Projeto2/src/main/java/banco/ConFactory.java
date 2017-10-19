/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author glaykiere
 */
public class ConFactory {
    
    private final String host;
    private final String user;
    private final String password;

    public ConFactory() {
        this.host = "jdbc:postgresql://127.0.0.1:5432/AulaPoo";
        this.user = "postgres";
        this.password = "glaykiere";
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(host, user, password);
        
    }
    
    
}
