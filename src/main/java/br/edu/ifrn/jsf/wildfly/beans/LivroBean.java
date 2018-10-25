/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.beans;

import br.edu.ifrn.jsf.wildfly.dao.AutorDAO;
import br.edu.ifrn.jsf.wildfly.dao.LivroDAO;
import br.edu.ifrn.jsf.wildfly.model.Autor;
import br.edu.ifrn.jsf.wildfly.model.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author joaon
 */
@Named
@RequestScoped
public class LivroBean {
    
    @Inject
    private LivroDAO livroDAO;
    @Inject
    private AutorDAO autorDAO;
    @Inject
    private Livro  livro;
    @Inject
    private FacesContext facesContext;
    
    private List<Integer> autoresId = new ArrayList();
    
    public String salvar(){
        for (Integer idAutor : autoresId){
            livro.getAutores().add(new Autor(idAutor));
        }
        livroDAO.salvar(livro);
        livro = new Livro();
        autoresId = new ArrayList();
        
        
        
        //Habilita o escopo de flash
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage("Livro salvo com sucesso."));
        return "lista-livros.xhtml?faces-redirect=true";
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public List<Autor> listarAutores(){
        return autorDAO.listar();
    }

    public List<Integer> getAutoresId() {
        return autoresId;
    }

    public void setAutoresId(List<Integer> autoresId) {
        this.autoresId = autoresId;
    }
    
    
}
