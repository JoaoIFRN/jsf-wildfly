/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.conversores;

import br.edu.ifrn.jsf.wildfly.model.Autor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joaon
 */
@FacesConverter("conversorAutor")
public class ConversorAutor implements Converter{

    @Override
    public Object getAsObject(FacesContext context, 
            UIComponent component, String value) {
        if (value == null || value.isEmpty())
            return null;
        Autor autor = new Autor();
        autor.setId(Integer.valueOf(value));
        return autor;
    }

    @Override
    public String getAsString(FacesContext context, 
            UIComponent component, Object value) {
        if (value == null)
            return null;
        Autor autor = (Autor) value;
        return autor.getId().toString();
    }
    
}
