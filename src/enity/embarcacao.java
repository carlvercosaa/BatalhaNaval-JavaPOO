package enity;

import java.util.Scanner;
import tabuleiro.tabuleiro;

public class embarcacao {
    private int numeroJogador;
    private jogador jogador;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    

    public embarcacao(jogador jogador,int numeroJogador, int tamanho){
	super();
        this.jogador = jogador;
	this.numeroJogador = numeroJogador;
        this.tamanho = tamanho;
    }

    public void escolherPosicaoDaEmbarcacao(tabuleiro tabuleiro){
        Scanner scanner = new Scanner(System.in);
        
        int linha;
        int coluna;
        
	System.out.println("Jogador: " + jogador.getNUMERODOJOGADOR());
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

