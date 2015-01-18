/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.model.Post;
import java.util.List;

/**
 *
 * @author inftel07
 */
public class BusquedaView extends PaginatedView {
    
    private List<ResumenPost> resultadosBusqueda;
    private TipoBusqueda tipoBusqueda;
    private String valor;

    public BusquedaView() {
    }

    public List<ResumenPost> getResultadosBusqueda() {
        return resultadosBusqueda;
    }

    public void setResultadosBusqueda(List<ResumenPost> resultadosBusqueda) {
        this.resultadosBusqueda = resultadosBusqueda;
    }

    public TipoBusqueda getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(TipoBusqueda tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
