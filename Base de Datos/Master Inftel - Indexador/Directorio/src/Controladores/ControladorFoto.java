/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaFoto;
import com.mongodb.BasicDBObject;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loubna
 */
public class ControladorFoto implements ActionListener {

    private final VistaFoto vista;
    List<BasicDBObject> lista;
    private int pos = 0;
    private int l = 0;

    public ControladorFoto(VistaFoto vista, List<BasicDBObject> listaobj) {
        this.vista = vista;
        this.lista = listaobj;
        l = lista.size();
        vista.rellenarCampos(lista.get(pos), pos, l);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case VistaFoto.BotonMas: {

                calculaMas();
                vista.rellenarCampos(lista.get(pos), pos, l);

                break;
            }
            case VistaFoto.BotonMenos: {

                calculaMenos();
                vista.rellenarCampos(lista.get(pos), pos, l);

                break;
            }
            case VistaFoto.BotonMapa: {
                if (lista.get(pos).getString("latitud") != null) {
                    String latitud = lista.get(pos).getString("latitud");
                    String latitudRef = lista.get(pos).getString("latitudRef");
                    String longitud = lista.get(pos).getString("longitud");
                    String longitudRef = lista.get(pos).getString("longitudRef");
                    String url = "http://www.google.es/maps/place/" + latitud
                            + "''" + latitudRef + "+" + longitud + "''" + longitudRef;
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ControladorFoto.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException | URISyntaxException ex) {
                        Logger.getLogger(ControladorFoto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    vista.mensajeError("No existe ubicación gps");
                }
                break;
            }
            case VistaFoto.BotonFoto: {
                String ruta = lista.get(pos).getString("ruta");
                String nombre = lista.get(pos).getString("nombre");
                String rutaCompleta = ruta + "\\" + nombre;
                File f = new File(rutaCompleta);
                if (f.isFile()) {
                    try {
                        Desktop.getDesktop().open(f);
                    } catch (IOException ex) {
                        Logger.getLogger(ControladorFoto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    vista.mensajeError("El archivo no se ha encontrado");
                }

                break;
            }
        }
    }

    public void calculaMas() {

        if (pos == l - 1) {
            pos = 0;
        } else {
            pos++;
        }

    }

    public void calculaMenos() {

        if (pos == 0) {
            pos = l - 1;
        } else {
            pos--;
        }
    }
}
