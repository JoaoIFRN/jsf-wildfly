/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.dao;

import br.edu.ifrn.jsf.wildfly.model.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author joaon
 */
public class AutorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Autor> listar() {
        return entityManager.createQuery("from Autor").getResultList();
    }
    
    @Transactional
    public void atualizar(Autor autor){
        entityManager.merge(autor);
    }

    @Transactional
    public void excluir(Autor autor) {
        entityManager.remove(entityManager.find(Autor.class, autor.getId()));
    }
    
    @Transactional
    public void salvar(Autor autor){
        entityManager.persist(autor);
    }
    
}
