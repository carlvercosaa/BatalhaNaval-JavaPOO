package enity;

import java.util.Scanner;

public class jogador {
    private int [][] tabuleiro;
    private int NUMERODOJOGADOR;

public jogador(int numeroDoJogador, int[][] tabuleiroJogador) {
	this.tabuleiro = tabuleiroJogador;
	this.NUMERODOJOGADOR = numeroDoJogador;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getNUMERODOJOGADOR() {
        return NUMERODOJOGADOR;
    }

    public void setNUMERODOJOGADOR(int NUMERODOJOGADOR) {
        this.NUMERODOJOGADOR = NUMERODOJOGADOR;
    }

    
    public String toString() {
        return "Jogador-" + this.NUMERODOJOGADOR;
	}

	public boolean disparo(jogador jogador, Scanner scanner) {
	int coluna;
	int linha;
	System.out.println("----------------------------");
	System.out.println(this);
	System.out.println("Dispare contra o inimigo");
	System.out.print("digite a coluna: ");
	coluna = scanner.nextInt();
	System.out.print("digite a linha: ");
	linha = scanner.nextInt();

	return true;
    }
}
