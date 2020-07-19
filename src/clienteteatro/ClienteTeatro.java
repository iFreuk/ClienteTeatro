/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteteatro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

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
        new Cartelera();
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
    
        public static void VerCartelera(String Ini, String Fin, DefaultTableModel Tabla)throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPSobras ? ?");  //Revisa si la organizacion existe
            ct.setDate(1, Date.valueOf(Ini));
            ct.setDate(2, Date.valueOf(Fin));
            ResultSet rs = ct.executeQuery();
                            System.out.println(rs.getString(1));
            while(rs.next()){

                Tabla.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            
            }
        }catch(SQLException e){
        System.out.println(e.getMessage());
        
        }
            }
        
        
}
