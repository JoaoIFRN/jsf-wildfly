/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.beans;

import br.edu.ifrn.jsf.wildfly.dao.LivroDAO;
import br.edu.ifrn.jsf.wildfly.model.Livro;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author joaon
 */
@Model
public class DetalheLivroBean {

    private Integer id;
    private Livro livro;
    @Inject
    private LivroDAO livroDAO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void carregarLivro() {
        if (id != null) {
            Livro livro = livroDAO.buscar(id);
            if (livro != null) {
                this.livro = livro;
                return;
            }
        }
    }

}
