/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.dao;

import br.edu.ifrn.jsf.wildfly.model.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author joaon
 */
public class LivroDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void salvar(Livro livro){
        entityManager.persist(livro);
    }
    
    public List<Livro> listar(){
        String jpql = "select distinct(l) from Livro l join fetch l.autores";
        return entityManager.createQuery(jpql, Livro.class).getResultList();
    }
}
