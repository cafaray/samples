package com.ftc.iaspel.window;

import com.ftc.aspel.ws.Usuario;
import com.ftc.aspel.ws.UsuarioDetalle;
import com.ftc.aspel.ws.UsuarioServicios;
import com.ftc.aspel.ws.UsuarioServiciosService;
import com.ftc.aspel.ws.WrapperUsuario;
import com.ftc.exceptions.FTCServiceException;
import java.awt.event.MouseAdapter;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JInternalFrame {

    private final String[] COLUMN_NAMES = {"Id", "Cuenta", "Nombre", "Apellidos", "Cta. Aspel", "Estatus"};

    public Usuarios() {
        initComponents();
        tblUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblUsuarios.rowAtPoint(evt.getPoint());
                int col = tblUsuarios.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println("Valor: "+tblUsuarios.getValueAt(row, col)); 
                }
            }
        });
        try {
            List<WrapperUsuario> usuarios = listarUsuarios();
            DefaultTableModel dmodel = (DefaultTableModel) tblUsuarios.getModel();
            Object[][] rows = getModelUsuarios(usuarios);
            for (Object[] row : rows) {
                dmodel.addRow(row);
            }
        } catch (FTCServiceException e) {
            JOptionPane.showMessageDialog(rootPane, "The service is unavailable, please review the services.");
        }
    }

    private int agregaRenglon(Object[] renglon) {
        DefaultTableModel dmodel = (DefaultTableModel) tblUsuarios.getModel();
        dmodel.addRow(renglon);
        return dmodel.getRowCount();
    }

    private Object[][] getModelUsuarios(List<WrapperUsuario> usuarios) {
        if (usuarios != null) {
            String[][] o = new String[usuarios.size()][COLUMN_NAMES.length];
            int columna = 0, renglon = 0;
            for (WrapperUsuario wu : usuarios) {
                o[renglon][columna++] = 10 + String.valueOf(wu.getIdusucon());
                o[renglon][columna++] = wu.getDsusucon();
                o[renglon][columna++] = wu.getUsuarioDetalle().getDsusunom();
                o[renglon][columna++] = wu.getUsuarioDetalle().getDsusuape();
                o[renglon][columna++] = wu.getUsuarioDetalle().getDsusuasp();
                o[renglon++][columna] = wu.getInstatus().equals("A") ? "Activo" : "Suspendido";
            }
            return o;
        }
        return null;
    }

    private List<WrapperUsuario> listarUsuarios() throws FTCServiceException {
        try {
            UsuarioServiciosService servicio = new UsuarioServiciosService();
            UsuarioServicios port = servicio.getUsuarioServiciosPort();
            return port.listado();
        } catch (Exception e) {
            throw new FTCServiceException(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCuentaAspel = new javax.swing.JTextField();
        chkActivar = new javax.swing.JCheckBox();
        cmdCancelar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JPasswordField();
        txtContrasenia2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Gestor de usuarios");
        setName("GestorUsuarios"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Listado de usuarios");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ide", "Cuenta", "Nombre", "Apellidos", "Cuenta Aspel", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblUsuarios.getColumnModel().getColumn(5).setMinWidth(30);
            tblUsuarios.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblUsuarios.getColumnModel().getColumn(5).setMaxWidth(30);
        }

        jLabel2.setText("Cuenta");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Cuenta Aspel");

        chkActivar.setText("Activar la cuenta");
        chkActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActivarActionPerformed(evt);
            }
        });

        cmdCancelar.setText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        cmdGuardar.setText("Guardar");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });

        jLabel6.setText("Contraseña");

        jLabel7.setText("Repetir la contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addGap(540, 540, 540))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCuenta)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtApellidos)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(txtCuentaAspel)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContrasenia2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkActivar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(cmdCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdGuardar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuentaAspel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancelar)
                    .addComponent(cmdGuardar)
                    .addComponent(chkActivar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActivarActionPerformed

    }//GEN-LAST:event_chkActivarActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        txtCuenta.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtCuentaAspel.setText("");
        txtContrasenia.setText("");
        txtContrasenia2.setText("");
        chkActivar.setSelected(false);
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        if (registroValido()) {
            Usuario usuario = new Usuario();
            usuario.setDsusucon(txtCuenta.getText());
            usuario.setDsvalcon(new String(txtContrasenia.getPassword()));
            UsuarioDetalle ud = new UsuarioDetalle();
            ud.setDsusunom(txtNombre.getText());
            ud.setDsusuape(txtApellidos.getText());
            ud.setDsusuasp(txtCuentaAspel.getText());
            usuario.setUsuarioDetalle(ud);
            UsuarioServiciosService service = new UsuarioServiciosService();
            UsuarioServicios port = service.getUsuarioServiciosPort();
            usuario = port.registraUsuario(usuario);
            JOptionPane.showMessageDialog(rootPane, usuario.getUsuarioDetalle().getDsusunom());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los datos no son validos para el registro.");
        }
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private boolean registroValido() {
        boolean respuesta = !(txtCuenta.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtApellidos.getText().isEmpty()
                || txtCuentaAspel.getText().isEmpty()
                || txtContrasenia.getPassword().length == 0
                || txtContrasenia2.getPassword().length == 0
                || txtContrasenia.getPassword().length != txtContrasenia2.getPassword().length);
        if (respuesta) {
            char[] passwd = txtContrasenia.getPassword();
            char[] passwd2 = txtContrasenia2.getPassword();
            int x = 0;
            for (char c : passwd) {
                respuesta &= c == passwd2[x++];
            }
        }
        return respuesta;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkActivar;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JPasswordField txtContrasenia2;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtCuentaAspel;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
