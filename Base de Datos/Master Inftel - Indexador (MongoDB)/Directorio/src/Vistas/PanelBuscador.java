/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author inftel18
 */
public class PanelBuscador extends javax.swing.JPanel implements VistaBuscador {
    
    int panel = 0;

    /**
     * Creates new form JPanelCriterio
     */
    public PanelBuscador() {
        initComponents();
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();
        
        jPanel3.setOpaque(false);
        
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        photoshop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        flash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        tamanio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        camara = new javax.swing.JButton();
        photoshop = new javax.swing.JButton();
        flash = new javax.swing.JButton();
        fecha = new javax.swing.JButton();
        tamanio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Marca = new javax.swing.JComboBox();
        Modelo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        SiPhoto = new javax.swing.JRadioButton();
        NoPhoto = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        SiFlash = new javax.swing.JRadioButton();
        NoFlash = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ancho = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alto = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondo_1.png"))); // NOI18N

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        camara.setText("Cámara");
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        camara.setPreferredSize(new java.awt.Dimension(100, 50));
        camara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camaraActionPerformed(evt);
            }
        });
        add(camara, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 110, -1));

        photoshop.setText("Photoshop");
        photoshop.setPreferredSize(new java.awt.Dimension(100, 50));
        photoshop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoshopActionPerformed(evt);
            }
        });
        add(photoshop, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        flash.setText("Flash");
        flash.setPreferredSize(new java.awt.Dimension(100, 50));
        flash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flashActionPerformed(evt);
            }
        });
        add(flash, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        fecha.setText("Fecha");
        fecha.setPreferredSize(new java.awt.Dimension(100, 50));
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        tamanio.setText("Tamaño");
        tamanio.setToolTipText("");
        tamanio.setPreferredSize(new java.awt.Dimension(100, 50));
        tamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanioActionPerformed(evt);
            }
        });
        add(tamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Marca.setMaximumSize(new java.awt.Dimension(125, 32767));
        Marca.setMinimumSize(new java.awt.Dimension(125, 27));
        Marca.setPreferredSize(new java.awt.Dimension(125, 27));
        jPanel2.add(Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        Modelo.setMaximumSize(new java.awt.Dimension(125, 32767));
        Modelo.setMinimumSize(new java.awt.Dimension(125, 27));
        Modelo.setPreferredSize(new java.awt.Dimension(125, 27));
        jPanel2.add(Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jPanel1.add(jPanel2, "card2");

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(SiPhoto);
        SiPhoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SiPhoto.setForeground(new java.awt.Color(255, 255, 255));
        SiPhoto.setText("Si");
        SiPhoto.setToolTipText("");
        SiPhoto.setOpaque(false);
        SiPhoto.setPreferredSize(new java.awt.Dimension(80, 31));
        jPanel3.add(SiPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 36, 60, 30));

        buttonGroup1.add(NoPhoto);
        NoPhoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NoPhoto.setForeground(new java.awt.Color(255, 255, 255));
        NoPhoto.setText("No");
        NoPhoto.setOpaque(false);
        jPanel3.add(NoPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 31, 60, 40));
        NoPhoto.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jPanel3, "card3");

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(SiFlash);
        SiFlash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SiFlash.setForeground(new java.awt.Color(255, 255, 255));
        SiFlash.setText("Si");
        SiFlash.setOpaque(false);
        jPanel4.add(SiFlash, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 36, 50, 30));

        buttonGroup2.add(NoFlash);
        NoFlash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NoFlash.setForeground(new java.awt.Color(255, 255, 255));
        NoFlash.setText("No");
        NoFlash.setOpaque(false);
        jPanel4.add(NoFlash, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 36, 50, 30));

        jPanel1.add(jPanel4, "card4");

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 42, -1, -1));
        jPanel5.add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 42, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 42, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fin");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 42, -1, -1));

        jPanel1.add(jPanel5, "card5");

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alto <");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 41, -1, 20));
        jPanel7.add(ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 42, 78, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ancho <");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 41, -1, 20));
        jPanel7.add(alto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 42, 78, -1));

        jPanel1.add(jPanel7, "card6");

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 540, 120));

        buscar.setText("Consultar");
        buscar.setPreferredSize(new java.awt.Dimension(100, 50));
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondo.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void camaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camaraActionPerformed
        panel=1;
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(jPanel2);
        jPanel1.repaint();
        jPanel1.revalidate();
        
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        photoshop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        flash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        tamanio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
    }//GEN-LAST:event_camaraActionPerformed

    private void photoshopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoshopActionPerformed
        panel=2;
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(jPanel3);
        jPanel1.repaint();
        jPanel1.revalidate();
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        photoshop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        flash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        tamanio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
    }//GEN-LAST:event_photoshopActionPerformed

    private void flashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flashActionPerformed
        panel=3;
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(jPanel4);
        jPanel1.repaint();
        jPanel1.revalidate();
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        photoshop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        flash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        tamanio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
    }//GEN-LAST:event_flashActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        panel=4;
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(jPanel5);
        jPanel1.repaint();
        jPanel1.revalidate();
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        photoshop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        flash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        tamanio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
    }//GEN-LAST:event_fechaActionPerformed

    private void tamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanioActionPerformed
        panel=5;
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();

        jPanel1.add(jPanel7);
        jPanel1.repaint();
        jPanel1.revalidate();
        camara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        photoshop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        flash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 0));
        tamanio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
    }//GEN-LAST:event_tamanioActionPerformed

    @Override
    public void controlador(ActionListener ctr) {
        camara.addActionListener(ctr);
        camara.setActionCommand(BotonCamara);
        fecha.addActionListener(ctr);
        fecha.setActionCommand(BotonFecha);
        flash.addActionListener(ctr);
        flash.setActionCommand(BotonFlash);
        photoshop.addActionListener(ctr);
        photoshop.setActionCommand(BotonPhotoshop);
        tamanio.addActionListener(ctr);
        tamanio.setActionCommand(BotonTamanio);
        buscar.addActionListener(ctr);
        buscar.setActionCommand(BotonBuscar);
        Marca.addActionListener(ctr);
        Marca.setActionCommand(BotonElegirMarca);
        Modelo.addActionListener(ctr);
        Modelo.setActionCommand(BotonElegirModelo);
        
    }

    private class TransparentPanel extends JPanel {
    {
        setOpaque(false);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        Rectangle r = g.getClipBounds();
        g.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(g);
    }
}
    
    @Override
    public String getMarca(){
        return Marca.getSelectedItem().toString();
    }
    
    @Override
    public String getModelo(){
        return Modelo.getSelectedItem().toString();
    }
    
    @Override
    public void rellenarMarca(String marca){
        Marca.addItem(marca);
    }
    
    @Override
    public void rellenarModelo(String marca){
        Modelo.addItem(marca);
    }
    
    @Override
    public void VaciarModelo(){
        Modelo.removeAllItems();
    }
    
    @Override
    public void VaciarMarca(){
        Marca.removeAllItems();
    }
    
    @Override
    public boolean isPhotoshopSISelected(){
        return SiPhoto.isSelected();
    }
    
    @Override
    public boolean isPhotoshopNOSelected(){
        return NoPhoto.isSelected();
    }
    
    @Override
    public boolean isFlashSISelected(){
        return SiFlash.isSelected();
    }
    
    @Override
    public boolean isFlashNOSelected(){
        return NoFlash.isSelected();
    }
    
    @Override
    public Date getFechaInicio(){
        return fechaInicio.getDate();
    }
    
    @Override
    public Date getFechaFin(){
        return fechaFin.getDate();
    }
    
    @Override
    public String getAlto(){
        return ancho.getText();
    }
    
    @Override
    public String getAncho(){
        return ancho.getText();
    }
    
    @Override
    public void mensajeError(String message){
        JOptionPane.showMessageDialog(this, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public JFrame getPadre(){
        return (JFrame)this.getRootPane().getParent();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Marca;
    private javax.swing.JComboBox Modelo;
    private javax.swing.JRadioButton NoFlash;
    private javax.swing.JRadioButton NoPhoto;
    private javax.swing.JRadioButton SiFlash;
    private javax.swing.JRadioButton SiPhoto;
    private javax.swing.JTextField alto;
    private javax.swing.JTextField ancho;
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton camara;
    private javax.swing.JButton fecha;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JButton flash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton photoshop;
    private javax.swing.JButton tamanio;
    // End of variables declaration//GEN-END:variables
}