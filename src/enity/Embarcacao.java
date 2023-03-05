package enity;

import java.util.Scanner;

import tabuleiro.Tabuleiro;

public class Embarcacao {
    private Jogador jogador;
    private String nomeDaEmbarcacao;
    private int tamanho;
    

    public Embarcacao(Jogador jogador, String nomeDaEmbarcacao, int tamanho) {
        this.jogador = jogador;
        this.tamanho = tamanho;
        this.nomeDaEmbarcacao = nomeDaEmbarcacao;
    }
    
    
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public String getNomeDaEmbarcacao() {
    	return this.nomeDaEmbarcacao;
    }


    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }



}

