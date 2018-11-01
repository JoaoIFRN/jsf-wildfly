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

    private List<Autor> autores;

    
    public String salvar(){           
        String mensagem = "";
        if (livro.getId() != null){
            livroDAO.atualizar(livro);
            mensagem = "Livro atualizado com sucesso";
        }else{
            livroDAO.salvar(livro);
            mensagem = "Livro salvo com sucesso";
        }
        
        livro = new Livro();        
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(mensagem));
        return "lista-livros.xhtml?faces-redirect=true";
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public List<Autor> listarAutores(){
        if (autores == null)
            autores = autorDAO.listar();
        return autores;
    }
    
    public String editar(Livro livro){
        this.livro = livro;
        return "livros.xhtml";
    }
    
}
