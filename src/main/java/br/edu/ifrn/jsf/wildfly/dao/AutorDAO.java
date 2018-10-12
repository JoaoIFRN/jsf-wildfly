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

/**
 *
 * @author joaon
 */
public class AutorDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Autor> listar(){
        return entityManager.createQuery("from Autor").getResultList();
    }
}
