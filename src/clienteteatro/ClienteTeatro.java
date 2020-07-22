/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteteatro;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
    
    
     private final static String Cliente = "Default";
     private final static String contra = "12345";
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
    
        public static void VerCartelera(Date Ini, Date Fin, DefaultTableModel Tabla)throws SQLException{
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPSobras ?, ?");
                ct.setDate(1, Ini);
                ct.setDate(2, Fin);
                ResultSet rs = ct.executeQuery();
                Tabla.setRowCount(0);
                while(rs.next()){
                    if("confidencial".equals(rs.getString(3))) {
                    } else{
                    Tabla.addRow(new Object[]{rs.getString(1), rs.getString(2)});
                    }

                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }    
        }
        
        public static void VerPresentaciones(String ObraNombre, String Teatro, DefaultTableModel Tabla)throws SQLException{
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPSpresentacion ?, ?");
                ct.setString(1, ObraNombre);
                ct.setString(2, Teatro);
                ResultSet rs = ct.executeQuery();
                while(rs.next()){
                    Tabla.addRow(new Object[]{rs.getString(1) + "    -    " + rs.getString(2), rs.getString(3), rs.getString(4)});

                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }    
        }
        
            
        public static void CargaFilas(String Teatro, String Bloque, DefaultTableModel Tabla){
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPSfilas ?, ?");
                ct.setString(1, Teatro);
                ct.setString(2, Bloque);
                ResultSet rs = ct.executeQuery();
                while(rs.next()){
                    Tabla.addRow(new Object[]{rs.getString(1), rs.getString(2)});

                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }   
        }
        
        public static void CreaRegistroCompra(int aleatorio, int cantidad, String Titulo) throws UnknownHostException{
            InetAddress address = InetAddress.getLocalHost();
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPIregistro ?, ?, ?, ?");
                ct.setString(1, address.getHostAddress());
                ct.setInt(2, aleatorio);
                ct.setInt(3, cantidad);
                ct.setString(4, Titulo);
                ct.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        
        
        }
        
        
}
