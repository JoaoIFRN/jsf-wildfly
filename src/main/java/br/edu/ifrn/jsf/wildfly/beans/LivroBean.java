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
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

/**
 *
 * @author joaon
 */
@Model
public class LivroBean {
    
    @Inject
    private LivroDAO livroDAO;
    @Inject
    private AutorDAO autorDAO;
    @Inject
    private Livro  livro;
    @Inject
    private FacesContext facesContext;     
    private Part capaLivro;
    private Integer id;
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
        
        String path = "/livros/" + capaLivro.getSubmittedFileName();
        try {
            capaLivro.write(path);
        } catch (IOException ex) {
            Logger.getLogger(LivroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(path);
        
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
    
    public void carregarLivro(){
        if (id != null){
            Livro livro = livroDAO.buscar(id);
            if (livro != null){
                this.livro = livro;
                return;
            }
        }             
    }

    public Part getCapaLivro() {
        return capaLivro;
    }

    public void setCapaLivro(Part capaLivro) {
        this.capaLivro = capaLivro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

}
