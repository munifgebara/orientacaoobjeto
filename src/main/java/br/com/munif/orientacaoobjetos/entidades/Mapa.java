package br.com.munif.orientacaoobjetos.entidades;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mapa {

    private Set<Lugar> lugares;
    private Lugar inicioHerois;
    private Lugar inicioViloes;

    public Mapa() {
        lugares=new HashSet<>();
        Lugar hos = new Lugar("Hospital");
        Lugar basH = new Lugar("Base dos Herois");
        Lugar rio1 = new Lugar("Comeco do Rio");
        Lugar rio2 = new Lugar("Meio do Rio");
        Lugar rio3 = new Lugar("Foz do Rio");
        Lugar cac = new Lugar("Cachoeira");
        Lugar est1 = new Lugar("Inicio da Estrada");
        Lugar pont = new Lugar("Ponte");
        Lugar est2 = new Lugar("Fim da Estrada");
        Lugar basV = new Lugar("Base dos Viloes");

        hos.getDestinos().add(basH);
        basH.getDestinos().addAll(Arrays.asList(new Lugar[]{hos, rio1, est1}));
        rio1.getDestinos().addAll(Arrays.asList(new Lugar[]{rio2, basH}));
        rio2.getDestinos().addAll(Arrays.asList(new Lugar[]{rio1, rio3}));
        rio3.getDestinos().addAll(Arrays.asList(new Lugar[]{rio2, cac}));
        cac.getDestinos().addAll(Arrays.asList(new Lugar[]{basV}));
        est1.getDestinos().addAll(Arrays.asList(new Lugar[]{basH, pont}));
        pont.getDestinos().addAll(Arrays.asList(new Lugar[]{rio2, est1, est2}));
        est2.getDestinos().addAll(Arrays.asList(new Lugar[]{pont, basV}));
        basV.getDestinos().addAll(Arrays.asList(new Lugar[]{cac, est2}));
        inicioHerois = basH;
        inicioViloes = basV;
    }

    public Lugar getInicioHerois() {
        return inicioHerois;
    }

    public Lugar getInicioViloes() {
        return inicioViloes;
    }

    public Set<Lugar> getLugares() {
        return lugares;
    }

}
