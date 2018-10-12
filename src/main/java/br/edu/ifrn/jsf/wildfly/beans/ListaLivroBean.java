/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.beans;

import br.edu.ifrn.jsf.wildfly.dao.LivroDAO;
import br.edu.ifrn.jsf.wildfly.model.Livro;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author joaon
 */
@Named
@RequestScoped
public class ListaLivroBean {
    @Inject
    private LivroDAO livroDAO;
    
    public List<Livro> listar(){
        return livroDAO.listar();
    }
    
    public String novo(){
        return "livros.xhtml?faces-redirect=true";
    }
    
}
