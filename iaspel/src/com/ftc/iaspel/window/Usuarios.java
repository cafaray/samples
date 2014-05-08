package com.ftc.iaspel.window;

import com.ftc.aspel.ws.UsuarioServicios;
import com.ftc.aspel.ws.UsuarioServiciosService;
import com.ftc.aspel.ws.WrapperUsuario;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JInternalFrame {

    private final String[] COLUMN_NAMES = {"Id", "Cuenta", "Nombre", "Apellidos", "Cta. Aspel", "Estatus"};

    public Usuarios() {
        initComponents();
        List<WrapperUsuario> usuarios = listarUsuarios();
        DefaultTableModel dmodel = (DefaultTableModel) tblUsuarios.getModel();
        Object[][] rows = getModelUsuarios(usuarios);
        for (Object[] row : rows) {
            dmodel.addRow(row);
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

    private List<WrapperUsuario> listarUsuarios() {
        UsuarioServiciosService servicio = new UsuarioServiciosService();
        UsuarioServicios port = servicio.getUsuarioServiciosPort();
        return port.listado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setClosable(true);
        setTitle("Gestor de usuarios");
        setName("GestorUsuarios"); // NOI18N

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
                false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblUsuarios.getColumnModel().getColumn(5).setMinWidth(30);
            tblUsuarios.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblUsuarios.getColumnModel().getColumn(5).setMaxWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
