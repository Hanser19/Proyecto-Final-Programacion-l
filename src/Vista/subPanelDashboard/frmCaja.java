/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.subPanelDashboard;

import static Modelo.Cajas.getIdCajas;
import Vista.subFormCaja.Venta;
import java.awt.event.ActionEvent;

/**
 *
 * @author Juan Manuel
 */
public class frmCaja extends javax.swing.JPanel {
    private static String cajaIdSeleccionado;
    
    public frmCaja() {
        initComponents();
        asignarIdComboBoxCaja();
        Code();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        btnHabilitarCaja = new javax.swing.JButton();
        lblClave = new javax.swing.JLabel();
        jComboBoxCajas = new javax.swing.JComboBox<>();
        lblCaja = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1130, 560));

        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHabilitarCaja.setBackground(new java.awt.Color(0, 89, 179));
        btnHabilitarCaja.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnHabilitarCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnHabilitarCaja.setText("Habilitar caja");
        btnHabilitarCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHabilitarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarCajaActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(btnHabilitarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 50, 434, 85));

        lblClave.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblClave.setText("Contraseña del admin");
        jPanelPrincipal.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, -1));

        jComboBoxCajas.setBackground(new java.awt.Color(221, 221, 221));
        jComboBoxCajas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxCajas.setForeground(new java.awt.Color(102, 102, 102));
        jComboBoxCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCajasActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jComboBoxCajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 320, 50));

        lblCaja.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblCaja.setText("Seleccionar caja");
        jPanelPrincipal.add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));
        jPanelPrincipal.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 280, 320, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHabilitarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarCajaActionPerformed
         Venta ventana = new Venta();
    }//GEN-LAST:event_btnHabilitarCajaActionPerformed

    private void jComboBoxCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCajasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCajasActionPerformed
    
    private void asignarIdComboBoxCaja(){
        for(int i: getIdCajas()){
            jComboBoxCajas.addItem(String.valueOf(i));
        }
    }
    
    public static String getCajaIdSeleccionado(){
        return cajaIdSeleccionado;
    }
    
    private void Code(){
        
        jComboBoxCajas.addActionListener((ActionEvent e) -> {
            cajaIdSeleccionado = jComboBoxCajas.getSelectedItem().toString();
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHabilitarCaja;
    private javax.swing.JComboBox<String> jComboBoxCajas;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblClave;
    private javax.swing.JTextField txtContraseña;
    // End of variables declaration//GEN-END:variables

}

