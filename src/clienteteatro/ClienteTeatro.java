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
        
            
        public static void CargaFilas(String Teatro, String Bloque, String obra, DefaultTableModel Tabla){
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPSfilas ?, ?");
                ct.setString(1, Teatro);
                ct.setString(2, Bloque);
                ResultSet rs = ct.executeQuery();
                while(rs.next()){
                    String FechaHora = Bloques.TablaBloques.getValueAt(Bloques.TablaBloques.getSelectedRow(), 0).toString();
                    String fecha = FechaHora.split("    -    ")[0];
                    String hora = FechaHora.split("    -    ")[1];
                    Tabla.addRow(new Object[]{rs.getString(1), Integer.parseInt(rs.getString(2))-CuentaAsiento(Teatro, obra, Bloque, rs.getString(1), fecha, hora), rs.getString(2)});

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
        
        public static String BuscaAsiento(String teatro, String produ, String bloque, String fila, String fecha, String Hora, int numasiento){
            boolean found = false;
            String usados = "Los asientos ya usados son: ";
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPSasientos ?, ?, ?, ?, ?, ?, ?");
                ct.setString(1, teatro);
                ct.setString(2, produ);
                ct.setString(3, bloque);
                ct.setString(4, fila);
                ct.setString(5, fecha);
                ct.setString(6, Hora);
                ct.setInt(7, numasiento);
                ResultSet rs = ct.executeQuery();
                if(rs.next()){
                    usados = usados + rs.getInt(1);
                    while(rs.next()){
                        System.out.println(rs.getInt(1));
                        usados = usados + " - " + rs.getInt(1);

                    }
                }
                else{
                    return "";
                }
                return usados;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        return "";
        }
        
        public static void InsertarAsientos(String teatro, String produ, String bloque, String fila, String fecha, String hora, int numasiento, String IP, int cantidad, int numreg, int monto){
        try{
                PreparedStatement ct = con.prepareStatement("EXEC SPIasientos ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
                ct.setString(1, teatro);
                ct.setString(2, produ);
                ct.setString(3, bloque);
                ct.setString(4, fila);
                ct.setString(5, fecha);
                ct.setString(6, hora);
                ct.setInt(7, numasiento);
                ct.setString(8, IP);
                ct.setInt(9, cantidad);
                ct.setInt(10, numreg);
                ct.setInt(11, monto);
                ct.executeUpdate();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static int CuentaAsiento(String teatro, String produ, String bloque, String fila, String fecha, String Hora) throws SQLException{
            try{
                PreparedStatement ct = con.prepareStatement("EXEC SPCasientos ?, ?, ?, ?, ?, ?");
                ct.setString(1, teatro);
                ct.setString(2, produ);
                ct.setString(3, bloque);
                ct.setString(4, fila);
                ct.setString(5, fecha);
                ct.setString(6, Hora);
                ResultSet rs = ct.executeQuery();
                rs.next();
                return rs.getInt(1);
                }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
            return 0;
        }
        
        
}
