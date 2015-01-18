/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author inftel15
 */
public class PanelPaciente extends javax.swing.JPanel implements VistaPaciente {

    /**
     * Creates new form PanelPaciente
     */
    public PanelPaciente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEspecialidad = new javax.swing.JLabel();
        apellidos = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nuevaCita = new javax.swing.JButton();
        borrarCita = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEspecialidad.setText("Apellidos: ");
        add(labelEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 68, 83, 31));

        apellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellidos.setText("Nombre: ");
        add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 68, -1, 31));

        cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/door_in.png"))); // NOI18N
        cerrarSesion.setText("  Cerrar sesión");
        add(cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 170, 60));

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombre.setText("Nombre: ");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 31, 83, 31));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre.setText("Nombre: ");
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 31, -1, 31));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Hora", "Especialidad", "Medico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 541, 171));

        nuevaCita.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        nuevaCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/date.png"))); // NOI18N
        nuevaCita.setText("  Nueva cita");
        add(nuevaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 160, 60));

        borrarCita.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        borrarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/date_delete.png"))); // NOI18N
        borrarCita.setText("  Borrar cita");
        add(borrarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 160, 60));

        error.setForeground(new java.awt.Color(255, 0, 51));
        add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 320, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/rsz_1dna-blue-glass.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 440));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidos;
    private javax.swing.JButton borrarCita;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelEspecialidad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel nombre;
    private javax.swing.JButton nuevaCita;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void setInfoPaciente(String nombre, String apellidos) {
        
        this.nombre.setText(nombre);
        this.apellidos.setText(apellidos);
    }
    
    @Override
    public JFrame getPadre() {
        return (JFrame)this.getRootPane().getParent();
    }
    
    @Override
    public void mostrarError(String error) {
        this.error.setText(error);
    }
    
    @Override
    public void insertarCita(String fecha, String hora, String especialidadMedico, String nombreMedico) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();        
        model.addRow(new Object[]{fecha, hora, especialidadMedico, nombreMedico});
    }
    
    @Override
    public int getSelectedRow(){
        return jTable1.getSelectedRow();
    }
    
    @Override
    public void borrarTabla(){
        ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
    }
    
    @Override
    public void mensajeError(String message){
        JFrame parentFrame = (JFrame)this.getRootPane().getParent();
        JOptionPane.showMessageDialog(parentFrame, message,"Error",JOptionPane.ERROR_MESSAGE);
    } 
    
    @Override
    public void ocultarBoton(){
        borrarCita.setVisible(false);
    }
    
    @Override
    public void controlador(ActionListener ctr) {
        
        borrarCita.addActionListener(ctr);
        borrarCita.setActionCommand(BotonBorrarCita);
        nuevaCita.addActionListener(ctr);
        nuevaCita.setActionCommand(BotonNuevaCita);
        cerrarSesion.addActionListener(ctr);
        cerrarSesion.setActionCommand(BotonCerrarSesion);
        
    }
}
