/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author inftel15
 */
public final class PanelInforme extends javax.swing.JPanel implements VistaInforme{

    /**
     * Creates new form PanelInforme
     */
    public PanelInforme() {
        initComponents();
        myComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infCrear = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infCrear.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        infCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1416608974_tick.png"))); // NOI18N
        infCrear.setText("  Crear");
        infCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infCrearActionPerformed(evt);
            }
        });
        add(infCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 320, 121, 43));

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/info_rhombus.png"))); // NOI18N
        jButton3.setText("  Mostrar");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 320, 123, 43));

        jLabel9.setText("Paciente :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel10.setText("Texto");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Informes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 35, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Informe", "Especialidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 110, 358, 191));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/report_user.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 25, 44, 45));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1416608998_arrow_rotate_anticlockwise.png"))); // NOI18N
        jButton1.setText("  Volver");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 319, 121, 45));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/rsz_1dna-blue-glass.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void infCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infCrearActionPerformed

    }//GEN-LAST:event_infCrearActionPerformed


    @Override
    public void controlador(ActionListener ctr) {
        infCrear.addActionListener(ctr);
        infCrear.setActionCommand(BotonCrearInforme);
        
        jButton3.addActionListener(ctr);
        jButton3.setActionCommand(BotonMostrarInforme);
        
        jButton1.addActionListener(ctr);
        jButton1.setActionCommand(BotonVolverInforme);

        
    }
    
    @Override
    public void meterInformeTabla(int id, String espec, Date fecha) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        DateFormat dt = new SimpleDateFormat ("yyyy/MM/dd");
        dt.format(fecha);
        
        
        model.addRow(new Object[]{id, espec, dt.format(fecha)});
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton infCrear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cambiarLabel(String s) {
        jLabel10.setText(s);
    }
    
    public void myComponents(){
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    @Override
    public int getSelectedRow(){
        return jTable1.getSelectedRow();
    }
    
}
