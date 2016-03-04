package br.com.munif.orientacaoobjetos;

import br.com.munif.orientacaoobjetos.entidades.Heroi;
import br.com.munif.orientacaoobjetos.entidades.Mapa;
import java.util.Scanner;

public class Programa {

    public static void main(String args[]) {
        Scanner leitor = new Scanner(System.in);
        Mapa mapa = new Mapa();
        Heroi heroi = new Heroi();
        heroi.setPosicao(mapa.getInicioHerois());

        System.out.println("Qual é seu nome heroi?");
        heroi.setNome(leitor.nextLine());

        while (true) {
            System.out.println(heroi.getNome() + ", você está na(o) " + heroi.getPosicao());
            System.out.println("O que você quer fazer?");
            String acao = leitor.nextLine();
            try {
                if (acao.toLowerCase().equals("observe")) {
                    System.out.println(heroi.observe());
                }
                if (acao.startsWith("va para ")) {
                    heroi.vaPara(acao.replaceFirst("va para ", ""));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
