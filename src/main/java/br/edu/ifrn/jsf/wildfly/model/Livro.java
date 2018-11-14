/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.jsf.wildfly.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joaon
 */
@Entity
public class Livro implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "O título do livro é necessário")
    @Size(min = 1, max = 50, message = "No mínimo 1 caractere e no máximo 50")
    private String nome;
    @Lob
    @Size(min = 1)
    @NotNull(message = "Descrição necessária")
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Calendar dataPublicacao = Calendar.getInstance();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Autor> autores = new ArrayList();
    
    public Livro(){        
    }
    
    public Livro(Integer id){
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataPublicacao=" + dataPublicacao + ", autores=" + autores + '}';
    }

    
}
