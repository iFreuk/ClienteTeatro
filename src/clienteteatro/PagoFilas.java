/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteteatro;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iFreuk
 */
public class PagoFilas extends javax.swing.JFrame {

    /**
     * Creates new form PagoFilas
     */
    private final int precio;
    private final String teatro;
    int cantidad;
    public PagoFilas(String Titulo, int precio, String Teatro, String Bloque) {
        this.precio = precio;
        this.teatro = Teatro;
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) TablaFilas.getModel();
        ClienteTeatro.CargaFilas(Teatro, Bloque, modelo);
        TituloPago.setText(Titulo);
        CostoField.setText(Integer.toString(precio));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloPago = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFilas = new javax.swing.JTable();
        CantidadSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        CostoField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        TarjetaNumField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        CVVField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloPago.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TituloPago.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(TituloPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        TablaFilas.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        TablaFilas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filas", "Asientos Disponibles"
            }
        ));
        TablaFilas.setRowHeight(50);
        jScrollPane1.setViewportView(TablaFilas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        CantidadSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        CantidadSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CantidadSpinnerStateChanged(evt);
            }
        });
        getContentPane().add(CantidadSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Cantidad:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        CostoField.setEditable(false);
        CostoField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(CostoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 140, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Costo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "19", "20", "21", "22", "23", "24", "25" }));
        jComboBox1.setToolTipText("");
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 60, -1));

        TarjetaNumField.setText("Digite un numero de tarjeta");
        getContentPane().add(TarjetaNumField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 300, -1));

        jLabel3.setText("Vencimiento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 80, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("/");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 322, 20, 40));

        CVVField.setText("CVV");
        getContentPane().add(CVVField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 50, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Pagar 💸");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        
        try{
            long tarjetanum = Long.parseLong(TarjetaNumField.getText());
            int CVVnum = Integer.parseInt(CVVField.getText());
            try{
                Integer.parseInt(CVVField.getText());
                
                int cantidadCompra = Integer.parseInt(CantidadSpinner.getValue().toString());
                int cantidadDisponible = Integer.parseInt(TablaFilas.getValueAt(TablaFilas.getSelectedRow(), 1).toString());
                if(tarjetanum%3==1){
                    JOptionPane.showMessageDialog(this, "El numero de tarjeta es incorreco y no pudo ser encontrado", "Tarjeta incorrecta",0);
                }
                else if(tarjetanum%3==2){
                    JOptionPane.showMessageDialog(this, "La cuenta no cuenta con los fondos suficientes para realizar la transacción", "Fondos insuficientes",0);
                }
                else if(tarjetanum%3!=CVVnum%3){
                    JOptionPane.showMessageDialog(this, "Codigo de seguridad en tarjeta incorrecto", "Codigo incorrecto",0);
                }
                else if(cantidadCompra>cantidadDisponible){
                    JOptionPane.showMessageDialog(this, "Hijole creo que no se va a poder", "Faltan asientos",0);
                }
                else{
                TablaFilas.setValueAt(Integer.toString(cantidadDisponible-cantidadCompra),TablaFilas.getSelectedRow(), 1);
                
                }
         
            }catch(NumberFormatException e){
                CVVField.setText("ERROR");
            }
        }
        catch(NumberFormatException e){
            TarjetaNumField.setText("Numero de Tarjeta Invalido");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CantidadSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CantidadSpinnerStateChanged
        this.cantidad  = Integer.parseInt(CantidadSpinner.getValue().toString());
        CostoField.setText(Integer.toString(cantidad*precio));
    }//GEN-LAST:event_CantidadSpinnerStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],String Titulo, int precio, String Teatro, String Bloque) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagoFilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoFilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoFilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoFilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new PagoFilas(Titulo, precio, Teatro, Bloque).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CVVField;
    private javax.swing.JSpinner CantidadSpinner;
    private javax.swing.JTextField CostoField;
    private javax.swing.JTable TablaFilas;
    private javax.swing.JTextField TarjetaNumField;
    private javax.swing.JLabel TituloPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
