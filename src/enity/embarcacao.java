package enity;

import java.util.Scanner;
import tabuleiro.tabuleiro;

public class embarcacao {
    private jogador jogador;
    private String nomeDaEmbarcacao;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public String getNomeDaEmbarcacao() {
    	return this.nomeDaEmbarcacao;
    }

    public embarcacao(jogador jogador, String nomeDaEmbarcacao, int tamanho) {
    	
        this.jogador = jogador;
        this.tamanho = tamanho;
        this.nomeDaEmbarcacao = nomeDaEmbarcacao;
    }

    public void escolherPosicaoDaEmbarcacao(tabuleiro tabuleiro){
        Scanner scanner = new Scanner(System.in);
        
        int linha;
        int coluna;
        
        System.out.println("Jogador: " + jogador);
        System.out.println("Escolha o eixo(vertical ou horizontal)" );
        String eixo = scanner.next().toUpperCase();
    
        if(eixo.equals("VERTICAL")){
            System.out.print("digite a coluna: ");
            coluna = scanner.nextInt();
            System.out.print("digite a linha: ");
            linha = scanner.nextInt();
            tabuleiro.verificarEPlotarVertical(this.getTamanho(), linha, coluna);
        }
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public void setNumeroJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
    }

    public jogador getJogador() {
        return jogador;
    }

    public void setJogador(jogador jogador) {
        this.jogador = jogador;
    }



}

