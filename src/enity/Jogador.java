package enity;

import java.util.Scanner;

import tabuleiro.Tabuleiro;

public class Jogador {
    private Tabuleiro tabuleiro;
    private NavioDe1Cano navioDe1Cano;
    private NavioDe2Canos navioDe2Canos;
    private NavioDe3Canos navioDe3Canos;
    private NavioDe4Canos navioDe4Canos;
    private PortaAvioes portaAvioes;
    private int numero;
    
    public Jogador(int numero){
    	this.tabuleiro = new Tabuleiro();
    	this.navioDe1Cano = new NavioDe1Cano(this);
    	this.navioDe2Canos = new NavioDe2Canos(this);
    	this.navioDe3Canos = new NavioDe3Canos(this);
    	this.navioDe4Canos = new NavioDe4Canos(this);
    	this.portaAvioes = new PortaAvioes(this);
    	this.numero = numero;
    }


	public boolean disparo(Jogador jogador, Scanner scanner) {
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

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}


	public NavioDe1Cano getNavioDe1Cano() {
		return navioDe1Cano;
	}


	public void setNavioDe1Cano(NavioDe1Cano navioDe1Cano) {
		this.navioDe1Cano = navioDe1Cano;
	}


	public NavioDe2Canos getNavioDe2Canos() {
		return navioDe2Canos;
	}


	public void setNavioDe2Canos(NavioDe2Canos navioDe2Canos) {
		this.navioDe2Canos = navioDe2Canos;
	}


	public NavioDe3Canos getNavioDe3Canos() {
		return navioDe3Canos;
	}


	public void setNavioDe3Canos(NavioDe3Canos navioDe3Canos) {
		this.navioDe3Canos = navioDe3Canos;
	}


	public NavioDe4Canos getNavioDe4Canos() {
		return navioDe4Canos;
	}


	public void setNavioDe4Canos(NavioDe4Canos navioDe4Canos) {
		this.navioDe4Canos = navioDe4Canos;
	}


	public PortaAvioes getPortaAvioes() {
		return portaAvioes;
	}


	public void setPortaAvioes(PortaAvioes portaAvioes) {
		this.portaAvioes = portaAvioes;
	}


	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	


}

