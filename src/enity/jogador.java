package enity;

import java.util.Scanner;

public class jogador {
    private tabuleiro tabuleiro;
    private int NUMERODOJOGADOR;
    private navioDe1Cano navioDe1Cano;
    private navioDe2Canos navioDe2Canos;
    private navioDe3Canos navioDe3Canos;
    private navioDe4Canos navioDe4Canos;
    private portaAvioes portaAvioes;

public jogador(int numeroDoJogador) {

	this.tabuleiro = new tabuleiro(this);
	this.navioDe1Cano = new navioDe1Cano(this);
	this.navioDe2Canos = new navioDe2Cano(this);
	this.navioDe3Canos = new navioDe3Cano(this);
	this.navioDe4Canos = new navioDe4Cano(this);
	this.portaAvioes = new portaAvioes(this);
	this.NUMERODOJOGADOR = numeroDoJogador;
	
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

