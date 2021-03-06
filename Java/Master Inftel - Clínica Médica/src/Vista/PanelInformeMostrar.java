/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.sql.Blob;

/**
 *
 * @author inftel18
 */
public final class PanelInformeMostrar extends javax.swing.JPanel implements VistaInformeMostrar {


    /**
     * Creates new form PanelInformeMostrar
     */
    public PanelInformeMostrar() {
        initComponents();
        myComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        infDatos = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infTratamiento = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        infDiagnostico = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1416608998_arrow_rotate_anticlockwise.png"))); // NOI18N
        jButton1.setText("Volver");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 336, 126, 47));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Mostrar Informe");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 34, -1, -1));

        jLabel2.setText("Paciente :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 39, -1, -1));

        jLabel3.setText("Texto");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 39, -1, -1));

        infDatos.setColumns(1);
        infDatos.setRows(2);
        jScrollPane5.setViewportView(infDatos);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 268, 432, 50));

        jLabel5.setText("Diagnóstico :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 82, -1, -1));

        jLabel6.setText("Datos de Exploración :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 240, -1, -1));

        infTratamiento.setColumns(1);
        infTratamiento.setRows(2);
        jScrollPane2.setViewportView(infTratamiento);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 182, 432, 50));

        jButton3.setText("Ver Imagen");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 336, 130, -1));

        jLabel4.setText("Tratamiento :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 160, -1, -1));

        infDiagnostico.setColumns(1);
        infDiagnostico.setRows(2);
        jScrollPane3.setViewportView(infDiagnostico);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 104, 430, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/report_user.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 22, 43, 48));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/rsz_1dna-blue-glass.jpg"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea infDatos;
    private javax.swing.JTextArea infDiagnostico;
    private javax.swing.JTextArea infTratamiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cambiarLabel(String s) {
        jLabel3.setText(s);
    }
    
    public void controlador(ActionListener ctr) {
        jButton1.addActionListener(ctr);
        jButton1.setActionCommand(BotonInformeVolver);
    }
    
    public void myComponents(){
        
        infDiagnostico.setEditable(false);
        infTratamiento.setEditable(false); 
        infDatos.setEditable(false); 
        
        infDiagnostico.setWrapStyleWord(true);
        infDiagnostico.setLineWrap(true);
        
        infTratamiento.setWrapStyleWord(true);
        infTratamiento.setLineWrap(true);
        
        infDatos.setWrapStyleWord(true);
        infDatos.setLineWrap(true);
        
    }
    
    @Override
    public void setInfo(String dia, String trat, String dat, Blob file){
        
        infDiagnostico.setText(dia);
        infTratamiento.setText(trat);
        infDatos.setText(dat);
        
    }
    
}
