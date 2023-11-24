/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import subPanel_Dashboard.frmInicio;
import subPanel_Dashboard.frmAlmacen;
import subPanel_Dashboard.frmCaja;
import subPanel_Dashboard.frmCompras;
import subPanel_Dashboard.frmAdministrador;
import java.awt.BorderLayout;

/**
 *
 * @author Hanser Perez
 */
public class frmDashboard extends javax.swing.JFrame {

    /**
     * Creates new form frmDashboard
     */
    public frmDashboard() {
        initComponents();
        PanelInicio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBorder = new javax.swing.JPanel();
        JPanelMenu = new javax.swing.JPanel();
        Logotipo = new javax.swing.JLabel();
        lblNombreLogotipo = new javax.swing.JLabel();
        lblNombreLogotipo1 = new javax.swing.JLabel();
        btnAlmacen = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        btnContabilidad = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jPanelSuperior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PanelBorder.setBackground(new java.awt.Color(255, 255, 255));

        JPanelMenu.setBackground(new java.awt.Color(0, 51, 102));

        Logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Logo.png"))); // NOI18N

        lblNombreLogotipo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombreLogotipo.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreLogotipo.setText("Punto de Venta");

        lblNombreLogotipo1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNombreLogotipo1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreLogotipo1.setText("MarketVent");

        btnAlmacen.setBackground(new java.awt.Color(0, 51, 102));
        btnAlmacen.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        btnAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Almacen.png"))); // NOI18N
        btnAlmacen.setText("         Almacen");
        btnAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlmacen.setPreferredSize(new java.awt.Dimension(128, 80));
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        btnInicio.setBackground(new java.awt.Color(0, 51, 102));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/home.png"))); // NOI18N
        btnInicio.setText("          Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setPreferredSize(new java.awt.Dimension(128, 80));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnCompras.setBackground(new java.awt.Color(0, 51, 102));
        btnCompras.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Compras.png"))); // NOI18N
        btnCompras.setText("        Compras");
        btnCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCompras.setPreferredSize(new java.awt.Dimension(128, 80));
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });

        btnCaja.setBackground(new java.awt.Color(0, 51, 102));
        btnCaja.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Caja.png"))); // NOI18N
        btnCaja.setText("           Caja");
        btnCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCaja.setPreferredSize(new java.awt.Dimension(128, 80));
        btnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaActionPerformed(evt);
            }
        });

        btnContabilidad.setBackground(new java.awt.Color(0, 51, 102));
        btnContabilidad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnContabilidad.setForeground(new java.awt.Color(255, 255, 255));
        btnContabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Contabilidad.png"))); // NOI18N
        btnContabilidad.setText("     Contabilidad");
        btnContabilidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContabilidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnContabilidad.setPreferredSize(new java.awt.Dimension(128, 80));

        btnAdministrador.setBackground(new java.awt.Color(0, 51, 102));
        btnAdministrador.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Administrador.png"))); // NOI18N
        btnAdministrador.setText("     Administrador");
        btnAdministrador.setToolTipText("");
        btnAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdministrador.setPreferredSize(new java.awt.Dimension(128, 80));
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(0, 51, 102));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/exit.png"))); // NOI18N
        btnCerrarSesion.setText("      Cerrar sesion");
        btnCerrarSesion.setToolTipText("");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(128, 80));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelMenuLayout = new javax.swing.GroupLayout(JPanelMenu);
        JPanelMenu.setLayout(JPanelMenuLayout);
        JPanelMenuLayout.setHorizontalGroup(
            JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(Logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(85, 85, 85))
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblNombreLogotipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblNombreLogotipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90))
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnContabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPanelMenuLayout.setVerticalGroup(
            JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(lblNombreLogotipo1)
                .addGap(6, 6, 6)
                .addComponent(lblNombreLogotipo)
                .addGap(72, 72, 72)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnContabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanelSuperior.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pagina de inicio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inicio");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hoy es dia de mes del año");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(837, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanelCentral.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelBorderLayout = new javax.swing.GroupLayout(PanelBorder);
        PanelBorder.setLayout(PanelBorderLayout);
        PanelBorderLayout.setHorizontalGroup(
            PanelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBorderLayout.createSequentialGroup()
                .addComponent(JPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelBorderLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jPanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBorderLayout.setVerticalGroup(
            PanelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelBorderLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelBorderLayout.createSequentialGroup()
                .addComponent(jPanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(560, 560, 560))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        // TODO add your handling code here:
        PanelAlmacen();
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
        PanelInicio();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
        // TODO add your handling code here:
        PanelCaja();
    }//GEN-LAST:event_btnCajaActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:
        PanelCompras();
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        // TODO add your handling code here:
        PanelAdministrador();
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelMenu;
    private javax.swing.JLabel Logotipo;
    private javax.swing.JPanel PanelBorder;
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnContabilidad;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JLabel lblNombreLogotipo;
    private javax.swing.JLabel lblNombreLogotipo1;
    // End of variables declaration//GEN-END:variables

    public void PanelInicio() {
        frmInicio inicio = new frmInicio();
        inicio.setSize(1130, 560);
        inicio.setLocation(0, 0);

        jPanelCentral.removeAll();
        jPanelCentral.add(inicio, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }

    public void PanelAlmacen() {
        frmAlmacen almacen = new frmAlmacen();
        almacen.setSize(1130, 560);
        almacen.setLocation(0, 0);

        jPanelCentral.removeAll();
        jPanelCentral.add(almacen, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }

    public void PanelCaja() {
        frmCaja caja = new frmCaja();
        caja.setSize(1130, 560);
        caja.setLocation(0, 0);

        jPanelCentral.removeAll();
        jPanelCentral.add(caja, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }
    
        public void PanelCompras() {
        frmCompras compras = new frmCompras();
        compras.setSize(1130, 560);
        compras.setLocation(0, 0);

        jPanelCentral.removeAll();
        jPanelCentral.add(compras, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }
        
            
        public void PanelAdministrador() {
        frmAdministrador administrador = new frmAdministrador();
        administrador.setSize(1130, 560);
        administrador.setLocation(0, 0);

        jPanelCentral.removeAll();
        jPanelCentral.add(administrador, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }

}
