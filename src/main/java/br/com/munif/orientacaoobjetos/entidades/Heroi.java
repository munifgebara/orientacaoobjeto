package br.com.munif.orientacaoobjetos.entidades;

import java.util.Collections;
import java.util.Set;

public class Heroi {

    private String nome;
    private Lugar posicao;
    private Integer energia;
    private Set<Coisa> sacola;
    private Arma armaEmUso;

    public Heroi() {
        setEnergia(10);
        setArmaEmUso(new Pistola());
    }

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
        if (this.posicao != null) {
            this.posicao.getConteudo().remove(this);
        }
        this.posicao = posicao;
        this.posicao.getConteudo().add(this);
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
        String resposta = "Aqui tem";
        for (Object coisa : posicao.getConteudo()) {
            resposta = resposta + " " + coisa;
        }
        resposta = resposta + "\nVocê pode ir para ";
        for (Lugar destino : posicao.getDestinos()) {
            resposta = resposta + destino.getNome() + " ";
        }
        return resposta;
    }

    public void vaPara(String ondeOCaraQuerIr) {
        Lugar novoLugar = null;
        for (Lugar destino : posicao.getDestinos()) {
            if (destino.getNome().equalsIgnoreCase(ondeOCaraQuerIr)) {
                novoLugar = destino;
                break;
            }
        }
        if (novoLugar != null) {
            setPosicao(novoLugar);
        } else {
            throw new RuntimeException("Impossível ir para " + ondeOCaraQuerIr);
        }
    }

    @Override
    public String toString() {
        return nome;
    }

    public String atiraEm(String outro) {
        if(armaEmUso.getQuantidadeMunicao()<1){
            return "Sem munição";
        } else {
            armaEmUso.diminuiMunicao();
        }
        String resultado = "";
        for (Object obj : getPosicao().getConteudo()) {
            if (obj instanceof Heroi) {
                Heroi outroHeroi = (Heroi) obj;
                if (outroHeroi.getNome().toLowerCase().equals(outro.toLowerCase())) {
                    outroHeroi.tiraEnergia(armaEmUso.getDano());
                    resultado = "Você acertou o " + outroHeroi.getNome();
                }
            }
        }

        return resultado;
    }

    public void tiraEnergia(Integer dano) {
        energia = energia - dano;
        if (energia<1 ){
            nome=nome+" morto";
            posicao.getConteudo().addAll(sacola);
            posicao.getConteudo().add(armaEmUso);
            armaEmUso=new Arma();
            sacola=Collections.EMPTY_SET;
        }
    }

}
