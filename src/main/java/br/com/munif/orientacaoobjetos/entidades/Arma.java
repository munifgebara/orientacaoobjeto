package br.com.munif.orientacaoobjetos.entidades;

public class Arma extends Coisa {

    private Integer quantidadeMunicao;

    private Integer dano;

    public Arma() {
    }

    public Integer getQuantidadeMunicao() {
        return quantidadeMunicao;
    }

    public void setQuantidadeMunicao(Integer quantidadeMunicao) {
        this.quantidadeMunicao = quantidadeMunicao;
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

}
