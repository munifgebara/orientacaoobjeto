package br.com.munif.orientacaoobjetos.entidades;

import java.util.Set;

public class Heroi {

    private String nome;
    private Lugar posicao;
    private Integer energia;
    private Set<Coisa> sacola;
    private Arma armaEmUso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lugar getPosicao() {
        return posicao;
    }

    public void setPosicao(Lugar posicao) {
        this.posicao = posicao;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer novo) {
        if (novo >= 0) {
            this.energia = novo;
        } else {
            throw new RuntimeException("A energia não pode ser negativa");
        }
    }

    public Set<Coisa> getSacola() {
        return sacola;
    }

    public void setSacola(Set<Coisa> sacola) {
        this.sacola = sacola;
    }

    public Arma getArmaEmUso() {
        return armaEmUso;
    }

    public void setArmaEmUso(Arma armaEmUso) {
        this.armaEmUso = armaEmUso;
    }

    public String observe() {
        String resposta = "Você pode ir para ";
        for (Lugar destino : posicao.getDestinos()) {
            resposta = resposta + destino.getNome() + " ";
        }
        return resposta;
    }

    public void vaPara(String ondeOCaraQuerIr) {
        Lugar novoLugar=null;
        for (Lugar destino : posicao.getDestinos()) {
            if (destino.getNome().equals(ondeOCaraQuerIr)){
                novoLugar=destino;
                break;
            }
        }
        if (novoLugar!=null){
            posicao=novoLugar;
        }
        else{
            throw new RuntimeException("Impossível ir para "+ondeOCaraQuerIr);
        }
    }

}
