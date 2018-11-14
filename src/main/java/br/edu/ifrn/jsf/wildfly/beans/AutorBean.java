/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.beans;

import br.edu.ifrn.jsf.wildfly.dao.AutorDAO;
import br.edu.ifrn.jsf.wildfly.model.Autor;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


/**
 *
 * @author joaon
 */
@Model
public class AutorBean {
    
    @Inject
    private Autor autor;
    private List<Autor> autores;
    @Inject
    private FacesContext facesContext;
    @Inject
    private AutorDAO autorDAO;

    public Autor getAutor() {                
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public List<Autor> listar(){
        if (autores == null){
            autores = autorDAO.listar();
        }
        return autores;                
    }
    
    public void excluir(Autor autor){
        autorDAO.excluir(autor);
        autores = null;
    }
    
    public void salvar(){           
        String mensagem = "";
        if (autor.getId() != null){
            autorDAO.atualizar(autor);
            mensagem = "Autor atualizado com sucesso";
        }else{
            autorDAO.salvar(autor);
            mensagem = "Autor salvo com sucesso";
        }        
        
        autor = new Autor();        
        autores = null;        
        facesContext.addMessage(null, new FacesMessage(mensagem));        
    }
    
    public void editar(Autor autor){
        this.autor = autor;
    }
        
}
