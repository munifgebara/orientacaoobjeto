package br.com.munif.orientacaoobjetos.entidades;

import java.util.HashSet;
import java.util.Set;

public class Lugar {

    private String nome;
    private String descricao;
    private Set<Lugar> destinos;
    private Set<Object> conteudo;

    public Lugar() {
        destinos=new HashSet<>();
        conteudo=new HashSet<>();
    }

    public Lugar(String nome) {
        destinos=new HashSet<>();
        conteudo=new HashSet<>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Lugar> getDestinos() {
        return destinos;
    }

    public void setDestinos(Set<Lugar> destinos) {
        this.destinos = destinos;
    }

    public Set<Object> getConteudo() {
        return conteudo;
    }

    public void setConteudo(Set<Object> conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return  nome;
    }
    
    

}
