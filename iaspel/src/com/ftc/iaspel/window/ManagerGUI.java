package com.ftc.iaspel.window;

import com.ftc.aspel.ws.WrapperUsuarioDetalle;
import com.ftc.iaspel.enums.TipoUsuario;
import com.ftc.iaspel.util.Conexion;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class ManagerGUI extends javax.swing.JFrame {

    public ManagerGUI() {
        initComponents();
    }

    void activaMenu(boolean esActivo) {
        esAdmin = Conexion.getUsuario().getDsusucon().equals("sysadmin");
        mnuUsuarios.setEnabled(esAdmin && esActivo);
        mnuChangePasswd.setEnabled(esActivo);
        mnuGenerador.setEnabled(esActivo);
        mnuCompras.setEnabled(esActivo);
        mnuVentas.setEnabled(esActivo);
        mnuReporte.setEnabled(esActivo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        mnuMain = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuConectar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuUsuarios = new javax.swing.JMenuItem();
        mnuChangePasswd = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        mnuGenerador = new javax.swing.JMenu();
        mnuCompras = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iaspel-Generador de pólizas contables");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("iaspelGeneradorPolizas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        desktop.setBackground(java.awt.SystemColor.activeCaptionBorder);
        desktop.setName("Desktop"); // NOI18N

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        mnuArchivo.setText("Archivo");

        mnuConectar.setText("Conectar");
        mnuConectar.setToolTipText("Inicia sesión");
        mnuConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConectarActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuConectar);
        mnuArchivo.add(jSeparator1);

        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.setEnabled(false);
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuUsuarios);

        mnuChangePasswd.setText("Cambiar contraseña");
        mnuChangePasswd.setEnabled(false);
        mnuArchivo.add(mnuChangePasswd);
        mnuArchivo.add(jSeparator2);

        mnuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnuSalir.setText("Salir");
        mnuSalir.setToolTipText("Cierra sesion y termina la aplicación");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalir);

        mnuMain.add(mnuArchivo);

        mnuGenerador.setText("Generador");
        mnuGenerador.setEnabled(false);

        mnuCompras.setText("Compras");
        mnuGenerador.add(mnuCompras);

        mnuVentas.setText("Ventas");
        mnuGenerador.add(mnuVentas);
        mnuGenerador.add(jSeparator3);

        mnuReporte.setText("Reporte");
        mnuGenerador.add(mnuReporte);

        mnuMain.add(mnuGenerador);

        setJMenuBar(mnuMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        log.info("Application is exiting");
        if (Conexion.isConectado()) {
            log.info("Closing conecction for you");
        } else {
        }
        log.info("Application is ready to quit");
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConectarActionPerformed
        if (!Conexion.isConectado()) {
            //TODO establecer conexión con la base de datos y devolver Token de sesion
            InicioSesion login = new InicioSesion(this, true);
            login.setLocation(200, 200);
            login.setVisible(true);
        } else {
            //TODO cerrar la conexion
            Conexion.desconectar();
        }
        System.out.println(Conexion.isConectado());
        mnuConectar.setText(Conexion.isConectado() ? "Deconectar" : "Conectar");
        activaMenu(Conexion.isConectado());
    }//GEN-LAST:event_mnuConectarActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
        Usuarios wUsuarios = new Usuarios();
        desktop.add(wUsuarios);
        wUsuarios.setLocation(10, 10);
        wUsuarios.setVisible(esAdmin);
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem mnuChangePasswd;
    private javax.swing.JMenuItem mnuCompras;
    private javax.swing.JMenuItem mnuConectar;
    private javax.swing.JMenu mnuGenerador;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenuItem mnuReporte;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuUsuarios;
    private javax.swing.JMenuItem mnuVentas;
    // End of variables declaration//GEN-END:variables
    private boolean esAdmin = false;
    private TipoUsuario tipoUsuario;
    private final static Logger log = Logger.getLogger(ManagerGUI.class.getName());

}
