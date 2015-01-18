/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.PanelMedico.myBundle;
import consultamedica.ConsultaMedica;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Blackproxy
 */
public class PanelNuevoUsuario extends javax.swing.JPanel implements VistaNuevoUsuario {

    /**
     * Creates new form PanelNuevoUsuario
     */
    public PanelNuevoUsuario() {
        
        myBundle = ConsultaMedica.getBundle();
        
        initComponents();
        limitArea();
        PanelContenedor.removeAll();
        PanelContenedor.repaint();
        PanelContenedor.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        labelNif = new javax.swing.JLabel();
        txtNif = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        labelContrasena1 = new javax.swing.JLabel();
        labelContrasena2 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        txtRepContrasena = new javax.swing.JTextField();
        labelPerfil = new javax.swing.JLabel();
        comboPerfil = new javax.swing.JComboBox();
        PanelContenedor = new javax.swing.JPanel();
        PanelTipoPaciente = new javax.swing.JPanel();
        labelSS = new javax.swing.JLabel();
        txtNumSS = new javax.swing.JTextField();
        labelAlergias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        labelTratamientos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTratamientos = new javax.swing.JTextArea();
        labelOperaciones = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtOperaciones = new javax.swing.JTextArea();
        PanelTipoMedico = new javax.swing.JPanel();
        labelEspecialidad = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        labelHorarioInicio = new javax.swing.JLabel();
        comboHoraInicio = new javax.swing.JComboBox();
        labelHorarioFin = new javax.swing.JLabel();
        comboHoraFin = new javax.swing.JComboBox();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelTitulo.setText("NUEVO USUARIO");
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        labelNombre.setText("Nombre");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 150, -1));

        labelApellidos.setText("Apellidos");
        add(labelApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 150, -1));

        labelNif.setText("NIF");
        add(labelNif, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        add(txtNif, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 134, 100, -1));

        labelDireccion.setText("Dirección");
        add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, -1));

        labelFecha.setText("Fecha de nacimiento");
        add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jLabel1.setText("Telefono");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 100, -1));

        labelEmail.setText("Email");
        add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 155, -1));

        labelContrasena1.setText("Contraseña");
        add(labelContrasena1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        labelContrasena2.setText("Repitir contraseña");
        add(labelContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 150, -1));
        add(txtRepContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 150, -1));

        labelPerfil.setText("Perfil Usuario");
        add(labelPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Medico", "Paciente" }));
        comboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPerfilActionPerformed(evt);
            }
        });
        add(comboPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        PanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenedor.setLayout(new java.awt.CardLayout());

        PanelTipoPaciente.setBackground(new java.awt.Color(255, 255, 255));

        labelSS.setText("Número Seguridad Social");

        labelAlergias.setText("Alergias");

        txtAlergias.setColumns(20);
        txtAlergias.setRows(3);
        jScrollPane1.setViewportView(txtAlergias);

        labelTratamientos.setText("Tratamientos");

        txtTratamientos.setColumns(20);
        txtTratamientos.setRows(3);
        jScrollPane2.setViewportView(txtTratamientos);

        labelOperaciones.setText("Operaciones Quirúrgicas");

        txtOperaciones.setColumns(20);
        txtOperaciones.setRows(3);
        jScrollPane3.setViewportView(txtOperaciones);

        javax.swing.GroupLayout PanelTipoPacienteLayout = new javax.swing.GroupLayout(PanelTipoPaciente);
        PanelTipoPaciente.setLayout(PanelTipoPacienteLayout);
        PanelTipoPacienteLayout.setHorizontalGroup(
            PanelTipoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTipoPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTipoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTipoPacienteLayout.createSequentialGroup()
                        .addComponent(labelSS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumSS))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(PanelTipoPacienteLayout.createSequentialGroup()
                        .addGroup(PanelTipoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAlergias)
                            .addComponent(labelTratamientos)
                            .addComponent(labelOperaciones))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelTipoPacienteLayout.setVerticalGroup(
            PanelTipoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTipoPacienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTipoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSS)
                    .addComponent(txtNumSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAlergias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTratamientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOperaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        PanelContenedor.add(PanelTipoPaciente, "card2");

        PanelTipoMedico.setBackground(new java.awt.Color(255, 255, 255));

        labelEspecialidad.setText("Especialidad");

        txtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadActionPerformed(evt);
            }
        });

        labelHorarioInicio.setText("Inicio de horario");

        comboHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));

        labelHorarioFin.setText("Fin de horario");

        comboHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));

        javax.swing.GroupLayout PanelTipoMedicoLayout = new javax.swing.GroupLayout(PanelTipoMedico);
        PanelTipoMedico.setLayout(PanelTipoMedicoLayout);
        PanelTipoMedicoLayout.setHorizontalGroup(
            PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTipoMedicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEspecialidad)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTipoMedicoLayout.createSequentialGroup()
                        .addGroup(PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHorarioInicio)
                            .addComponent(comboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHorarioFin))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        PanelTipoMedicoLayout.setVerticalGroup(
            PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTipoMedicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEspecialidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHorarioInicio)
                    .addComponent(labelHorarioFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTipoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        PanelContenedor.add(PanelTipoMedico, "card3");

        add(PanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 29, 290, 330));

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/report_user.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void comboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPerfilActionPerformed
        int indiceCombo= comboPerfil.getSelectedIndex();
        switch(indiceCombo){
            case 0:{
                PanelContenedor.removeAll();
                PanelContenedor.repaint();
                PanelContenedor.revalidate();
                break;
            }
            case 1:{
                PanelContenedor.removeAll();
                PanelContenedor.repaint();
                PanelContenedor.revalidate();
                PanelContenedor.add(PanelTipoMedico);
                PanelContenedor.repaint();
                PanelContenedor.revalidate();
                break;
            }
            case 2:{
                PanelContenedor.removeAll();
                PanelContenedor.repaint();
                PanelContenedor.revalidate();
                PanelContenedor.add(PanelTipoPaciente);
                PanelContenedor.repaint();
                PanelContenedor.revalidate();
                break;
            }
        }
    }//GEN-LAST:event_comboPerfilActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void txtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecialidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JPanel PanelTipoMedico;
    private javax.swing.JPanel PanelTipoPaciente;
    private javax.swing.JComboBox comboHoraFin;
    private javax.swing.JComboBox comboHoraInicio;
    private javax.swing.JComboBox comboPerfil;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAlergias;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelContrasena1;
    private javax.swing.JLabel labelContrasena2;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEspecialidad;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHorarioFin;
    private javax.swing.JLabel labelHorarioInicio;
    private javax.swing.JLabel labelNif;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelOperaciones;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelSS;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTratamientos;
    private javax.swing.JTextArea txtAlergias;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEspecialidad;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNif;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumSS;
    private javax.swing.JTextArea txtOperaciones;
    private javax.swing.JTextField txtRepContrasena;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtTratamientos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void controlador(ActionListener ctr) {
        jButtonAceptar.addActionListener(ctr);
        jButtonAceptar.setActionCommand(BotonCrearUsuario);
        jButtonCancelar.addActionListener(ctr);
        jButtonCancelar.setActionCommand(BotonCancelar);
    }

    @Override
    public String getNombre() {
        return txtNombre.getText();
    }

    @Override
    public String getApellidos() {
        return txtApellidos.getText();
    }

    @Override
    public String getDireccion() {
        return txtDireccion.getText();
    }

    @Override
    public Date getFecha() {
        return txtFecha.getDate();
    }

    @Override
    public String getNIF() {
        return txtNif.getText();
    }

    @Override
    public String getTelefono() {
        return txtTelefono.getText();
    }

    @Override
    public String getEmail() {
        return txtEmail.getText();
    }

    @Override
    public String getContrasena() {
        return txtContrasena.getText();
    }

    @Override
    public int getPerfil() {
        int indice=comboPerfil.getSelectedIndex();
        int res=0;
        switch(indice){
            case 0:{res= 2;break;}
            case 1:{res= 0;break;}
            case 2:{res= 1;break;}
        }
        return res;
    }

    @Override
    public String getTratamientos() {
        return txtTratamientos.getText();
    }

    @Override
    public String getOperaciones() {
        return txtOperaciones.getText();
    }

    @Override
    public String getNumSS() {
        return txtNumSS.getText();
    }

    @Override
    public String getAlergias() {
        return txtAlergias.getText();
    }

    @Override
    public String getEspecialidad() {
        return txtEspecialidad.getText();
    }

    @Override
    public String getHorarioInicio() {
        return comboHoraInicio.getSelectedItem().toString();
    }

    @Override
    public String getHorarioFin() {
        
        return comboHoraFin.getSelectedItem().toString();
    }

    @Override
    public String getContrasena2() {
        return txtRepContrasena.getText();
    }

    @Override
    public void mensajeError(String message) {
        JFrame parentFrame = (JFrame)this.getRootPane().getParent();
        JOptionPane.showMessageDialog(parentFrame, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void limitArea(){
        txtOperaciones.setWrapStyleWord(true);
        txtOperaciones.setLineWrap(true);
        txtAlergias.setWrapStyleWord(true);
        txtAlergias.setLineWrap(true);
        txtTratamientos.setWrapStyleWord(true);
        txtTratamientos.setLineWrap(true);
        
    }
}
