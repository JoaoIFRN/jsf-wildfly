/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.beans;

import br.edu.ifrn.jsf.wildfly.dao.LivroDAO;
import br.edu.ifrn.jsf.wildfly.model.Livro;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author joaon
 */
@Model
public class ListaLivroBean {
    @Inject
    private LivroDAO livroDAO;    
    private List<Livro> livros;
    
    public List<Livro> listar(){
        if (livros == null){
            livros = livroDAO.listar();
        }
        return livros;
    }
    
    public String novo(){
        return "livros.xhtml?faces-redirect=true";
    }
    
    public void excluir(Livro livro){
        livroDAO.excluir(livro);
        livros = null;
    }
    
    public String atualizar(Integer id){
        return "livros.xhtml?id=" + String.valueOf(id);
    }
   
    
}
