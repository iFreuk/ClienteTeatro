/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteteatro;

import java.util.ArrayList;

/**
 *
 * @author iFreuk
 */
public class Asientos extends javax.swing.JFrame {

    /**
     * Creates new form Asientos
     */
    private final int cantidad;
    private final ArrayList<javax.swing.JSpinner> Spinners = new ArrayList<>();
    public Asientos(int cantidad) {
        this.cantidad = cantidad;
        initComponents();
        enlistarspinners();
        jSpinner8.setVisible(false);
        jSpinner7.setVisible(false);
        jSpinner6.setVisible(false);
        jSpinner5.setVisible(false);
        jSpinner4.setVisible(false);
        jSpinner3.setVisible(false);
        jSpinner2.setVisible(false);
        
        if(cantidad-8==0){
        jSpinner8.setVisible(true);
        jSpinner7.setVisible(true);
        jSpinner6.setVisible(true);
        jSpinner5.setVisible(true);
        jSpinner4.setVisible(true);
        jSpinner3.setVisible(true);
        jSpinner2.setVisible(true);
        }else
        if(cantidad-7==0){
        jSpinner7.setVisible(true);
        jSpinner6.setVisible(true);
        jSpinner5.setVisible(true);
        jSpinner4.setVisible(true);
        jSpinner3.setVisible(true);
        jSpinner2.setVisible(true);
        }else
        if(cantidad-6==0){
        jSpinner6.setVisible(true);
        jSpinner5.setVisible(true);
        jSpinner4.setVisible(true);
        jSpinner3.setVisible(true);
        jSpinner2.setVisible(true);
        }
        if(cantidad-5==0){
        jSpinner5.setVisible(true);
        jSpinner4.setVisible(true);
        jSpinner3.setVisible(true);
        jSpinner2.setVisible(true);
        }
        if(cantidad-4==0){
        jSpinner4.setVisible(true);
        jSpinner3.setVisible(true);
        jSpinner2.setVisible(true);
        }
        if(cantidad-3==0){
        jSpinner3.setVisible(true);
        jSpinner2.setVisible(true);
        }
        if(cantidad-2==0){
        jSpinner2.setVisible(true);
        }
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

        jSpinner4 = new javax.swing.JSpinner();
        Confirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Seleccione los asientos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, null, 42, 1));
        getContentPane().add(jSpinner7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        ArrayList<Integer> numeros = new ArrayList<>();
        for(int i =0; i<cantidad; i++){
        numeros.add(Integer.parseInt(Spinners.get(i).getValue().toString()));
        }
        PagoFilas.setNumeros(numeros);
        this.dispose();
    }//GEN-LAST:event_ConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], int cantidad) {
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
            java.util.logging.Logger.getLogger(Asientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asientos(cantidad).setVisible(true);
            }
        });
    }
    
    private void enlistarspinners(){
    
    Spinners.add(jSpinner1);
    Spinners.add(jSpinner2);
    Spinners.add(jSpinner3);
    Spinners.add(jSpinner4);
    Spinners.add(jSpinner5);
    Spinners.add(jSpinner6);
    Spinners.add(jSpinner7);
    Spinners.add(jSpinner8);
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    // End of variables declaration//GEN-END:variables
}
