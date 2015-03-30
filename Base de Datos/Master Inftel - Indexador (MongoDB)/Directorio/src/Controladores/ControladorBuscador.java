/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.DAO.MongoDAO;
import Vistas.PanelDialog;
import Vistas.PanelFoto;
import Vistas.VistaBuscador;
import com.mongodb.BasicDBObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author loubna
 */
public class ControladorBuscador implements ActionListener {

    private final VistaBuscador vista;
    private int botonPulsado = 0;
    private boolean timo = true;

    public ControladorBuscador(VistaBuscador vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case VistaBuscador.BotonBuscar: {
                switch (botonPulsado) {
                    case 1:
                        String marca = vista.getMarca();
                        String modelo = vista.getModelo();
                        List<BasicDBObject> fotos1 = MongoDAO.AllFotosCamaraModelo(marca, modelo);
                        for (BasicDBObject object : fotos1) {
                            System.out.println(object);
                        }
                        if (fotos1.isEmpty()) {
                            vista.mensajeError("No se han encontrado fotos");
                        } else {
                            try {
                                PanelFoto panelFotos = new PanelFoto();
                                ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos1);
                                panelFotos.controlador(controladorFoto);
                                PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                System.out.println("AQUI LLEGA");
                                dialog.setContentPane(panelFotos);
                                dialog.validate();
                                dialog.repaint();
                                dialog.setVisible(true);
                            } catch (IOException ex) {
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }

                        break;
                    case 2:
                        if (vista.isPhotoshopNOSelected()) {
                            List<BasicDBObject> fotos2 = MongoDAO.AllNoFotosShop();
                            for (BasicDBObject object : fotos2) {
                                System.out.println(object);
                            }
                            if (fotos2.isEmpty()) {
                                vista.mensajeError("No se han encontrado fotos");
                            } else {
                                try {
                                    PanelFoto panelFotos = new PanelFoto();
                                    ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos2);
                                    panelFotos.controlador(controladorFoto);
                                    PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                    dialog.setContentPane(panelFotos);
                                    dialog.validate();
                                    dialog.repaint();
                                    dialog.setVisible(true);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }

                        } else if (vista.isPhotoshopSISelected()) {
                            List<BasicDBObject> fotos2 = MongoDAO.AllFotosShop();
                            for (BasicDBObject object : fotos2) {
                                System.out.println(object);
                            }
                            if (fotos2.isEmpty()) {
                                vista.mensajeError("No se han encontrado fotos");
                            } else {
                                try {
                                    PanelFoto panelFotos = new PanelFoto();
                                    ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos2);
                                    panelFotos.controlador(controladorFoto);
                                    PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                    dialog.setContentPane(panelFotos);
                                    dialog.validate();
                                    dialog.repaint();
                                    dialog.setVisible(true);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }
                        } else {
                            vista.mensajeError("No ha selecionado ninguna casilla");
                        }
                        break;
                    case 3:
                        Date fechaInicio = vista.getFechaInicio();
                        Date fechaFin = vista.getFechaFin();
                        if (fechaInicio == null || fechaFin == null) {
                            vista.mensajeError("Existe algún campo sin rellenar");
                        } else {
                            List<BasicDBObject> fotos3 = MongoDAO.AllFotosFecha(fechaInicio, fechaFin);
                            for (BasicDBObject object : fotos3) {
                                System.out.println(object);
                            }
                            if (fotos3.isEmpty()) {
                                vista.mensajeError("No se han encontrado fotos");
                            } else {
                                try {
                                    PanelFoto panelFotos = new PanelFoto();
                                    ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos3);
                                    panelFotos.controlador(controladorFoto);
                                    PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                    dialog.setContentPane(panelFotos);
                                    dialog.validate();
                                    dialog.repaint();
                                    dialog.setVisible(true);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }
                        }
                        break;
                    case 4:
                        String altoStr = vista.getAlto();
                        String anchoStr = vista.getAncho();
                        if (altoStr.isEmpty() || anchoStr.isEmpty()) {
                            vista.mensajeError("Existe algún campo sin rellenar");
                        } else {
                            try {
                                int alto = Integer.parseInt(altoStr);
                                int ancho = Integer.parseInt(anchoStr);
                                List<BasicDBObject> fotos4 = MongoDAO.AllFotosDimensiones(alto, ancho);
                                for (BasicDBObject object : fotos4) {
                                    System.out.println(object);
                                }
                                if (fotos4.isEmpty()) {
                                    vista.mensajeError("No se han encontrado fotos");
                                } else {
                                    try {
                                        PanelFoto panelFotos = new PanelFoto();
                                        ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos4);
                                        panelFotos.controlador(controladorFoto);
                                        PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                        dialog.setContentPane(panelFotos);
                                        dialog.validate();
                                        dialog.repaint();
                                        dialog.setVisible(true);
                                    } catch (IOException ex) {
                                        System.out.println("Error: " + ex.getMessage());
                                    }
                                }

                            } catch (Exception ex) {
                                vista.mensajeError("Los campos deben ser numéricos");
                            }

                        }
                        break;
                    case 5:
                        if (vista.isFlashNOSelected()) {
                            List<BasicDBObject> fotos5 = MongoDAO.AllFotosNoFlash();
                            for (BasicDBObject object : fotos5) {
                                System.out.println(object);
                            }
                            if (fotos5.isEmpty()) {
                                vista.mensajeError("No se han encontrado fotos");
                            } else {
                                try {
                                    PanelFoto panelFotos = new PanelFoto();
                                    ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos5);
                                    panelFotos.controlador(controladorFoto);
                                    PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                    dialog.setContentPane(panelFotos);
                                    dialog.validate();
                                    dialog.repaint();
                                    dialog.setVisible(true);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }

                        } else if (vista.isFlashSISelected()) {
                            List<BasicDBObject> fotos5 = MongoDAO.AllFotosFlash();
                            for (BasicDBObject object : fotos5) {
                                System.out.println(object);
                            }
                            if (fotos5.isEmpty()) {
                                vista.mensajeError("No se han encontrado fotos");
                            } else {
                                try {
                                    PanelFoto panelFotos = new PanelFoto();
                                    ControladorFoto controladorFoto = new ControladorFoto(panelFotos, fotos5);
                                    panelFotos.controlador(controladorFoto);
                                    PanelDialog dialog = new PanelDialog(vista.getPadre(), true);
                                    dialog.setContentPane(panelFotos);
                                    dialog.validate();
                                    dialog.repaint();
                                    dialog.setVisible(true);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            }

                        } else {
                            vista.mensajeError("No ha selecionado ninguna casilla");
                        }
                        break;
                    default:
                        break;
                }
                break;
            }
            case VistaBuscador.BotonCamara: {
                timo = false;
                vista.VaciarMarca();
                vista.VaciarModelo();
                List<String> marcas = MongoDAO.AllCamara();
                for (String marca : marcas) {
                    vista.rellenarMarca(marca);
                }
                String marca = vista.getMarca();
                List<String> modelos = MongoDAO.AllModelo(marca);
                for (String modelo : modelos) {
                    vista.rellenarModelo(modelo);
                }
                botonPulsado = 1;
                timo = true;
                break;
            }
            case VistaBuscador.BotonPhotoshop: {
                botonPulsado = 2;
                break;
            }
            case VistaBuscador.BotonFecha: {
                botonPulsado = 3;
                break;
            }
            case VistaBuscador.BotonTamanio: {
                botonPulsado = 4;
                break;
            }
            case VistaBuscador.BotonFlash: {
                botonPulsado = 5;
                break;
            }
            case VistaBuscador.BotonElegirMarca: {
                if (timo) {
                    vista.VaciarModelo();
                    String marca = vista.getMarca();
                    List<String> modelos = MongoDAO.AllModelo(marca);
                    for (String modelo : modelos) {
                        vista.rellenarModelo(modelo);
                    }
                }
                break;
            }
        }
    }

}
