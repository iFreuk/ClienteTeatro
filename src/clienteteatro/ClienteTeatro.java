/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteteatro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ClienteTeatro {
    public static Connection con;
    
    
     private static String Cliente = "Default";
     private static String contra = "12345";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login();
    }
    
    public static boolean Login(){
        try {
          String connectionUrl = "jdbc:sqlserver://;database=TEATROS;";
          Connection c = DriverManager.getConnection(connectionUrl, Cliente, contra);
          con = c;
          System.out.println("Conectado.");
        } 
        catch (SQLException ex) 
        {
            System.err.println(ex.toString());
            return false;

        }
        return true;
    }
    
}
