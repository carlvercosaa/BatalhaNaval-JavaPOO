package enity;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import tabuleiro.Tabuleiro;

public class Jogador {
    private Tabuleiro tabuleiro;
    private NavioDe1Cano navioDe1Cano;
    private NavioDe2Canos navioDe2Canos;
    private NavioDe3Canos navioDe3Canos;
    private NavioDe4Canos navioDe4Canos;
    private PortaAvioes portaAvioes;
    private int numero;
    private int vida = 25;

    
    
    public Jogador(int numero){
    	this.tabuleiro = new Tabuleiro();
    	this.navioDe1Cano = new NavioDe1Cano(this);
    	this.navioDe2Canos = new NavioDe2Canos(this);
    	this.navioDe3Canos = new NavioDe3Canos(this);
    	this.navioDe4Canos = new NavioDe4Canos(this);
    	this.portaAvioes = new PortaAvioes(this);
    	this.numero = numero;
    }


	public boolean disparo(Jogador adversario) {
		Scanner scanner = new Scanner(System.in);
		
		int coluna;
		int linha;
		String[] posicoes = new String[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.println("----------------------------");
			System.out.println("Jogador" + this.numero);
			System.out.println("Dispare contra o inimigo");
			System.out.print("digite a coluna: ");
			coluna = scanner.nextInt();
			System.out.print("digite a linha: ");
			linha = scanner.nextInt();
			
			posicoes[i] = adversario.getTabuleiro().verificaDisparo(linha, coluna, adversario);
			
		}
		
		for(int c = 0; c < 3; c++) {
			System.out.println(posicoes[c]);
		}
		
	
		return true;
    }
	
    public void escolherPosicaoDaEmbarcacao(Embarcacao nomeDaEmbarcacao){
        Scanner scanner = new Scanner(System.in);
        
        int linha;
        int coluna;
        String direcao;
        
        if(nomeDaEmbarcacao.getNomeDaEmbarcacao()==("Navio_De_1_Cano")){
        	this.tabuleiro.mostraGrelhaDeDefesa();
            
        	System.out.println("Jogador: " + this.numero);
        	
        	System.out.print("digite a coluna: ");
            coluna = scanner.nextInt();
            
            System.out.print("digite a linha: ");
            linha = scanner.nextInt();
            
            this.tabuleiro.verificarEPlotarHorizontalParaDireita(nomeDaEmbarcacao.getTamanho(), linha, coluna);
            
            this.tabuleiro.mostraGrelhaDeDefesa();
            
        }else{
            System.out.println("Escolha o eixo(vertical ou horizontal)" );
            String eixo = scanner.next().toUpperCase();
            
            if(eixo.equals("VERTICAL")){
            	this.tabuleiro.mostraGrelhaDeDefesa(); 
                System.out.print("digite a coluna: ");
                coluna = scanner.nextInt();
                
                System.out.print("digite a linha: ");
                linha = scanner.nextInt();
                
                System.out.println("Escolha a direcao(BAIXO ou CIMA)" );
                direcao = scanner.next().toUpperCase();
                
                if(direcao.equals("BAIXO")) {        
                	this.tabuleiro.verificarEPlotarVerticalParaBaixo(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                	this.tabuleiro.mostraGrelhaDeDefesa();

                }
                
                else if(direcao.equals("CIMA")) {    
                	this.tabuleiro.verificarEPlotarVerticalParaCima(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                	this.tabuleiro.mostraGrelhaDeDefesa();
                }
            }
            else if(eixo.equals("HORIZONTAL")){
            	this.tabuleiro.mostraGrelhaDeDefesa(); 
                System.out.print("digite a coluna: ");
                coluna = scanner.nextInt();
                
                System.out.print("digite a linha: ");
                linha = scanner.nextInt();
                
                System.out.println("Escolha a direcao(DIREITA ou ESQUERDA)" );
                direcao = scanner.next().toUpperCase();
                
                if(direcao.equals("DIREITA")) {        
                	this.tabuleiro.verificarEPlotarHorizontalParaDireita(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                	this.tabuleiro.mostraGrelhaDeDefesa();
                }
                else if(direcao.equals("ESQUERDA")){
                	this.tabuleiro.verificarEPlotarHorizontalParaEsquerda(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                	this.tabuleiro.mostraGrelhaDeDefesa();
                }
            }
            
        }
       }
    
    public void plotandoTodosNavios() {
    	List<Embarcacao> embarcacoes = Arrays.asList(getNavioDe1Cano(), getNavioDe2Canos(), getNavioDe3Canos(), getNavioDe4Canos(), getPortaAvioes());
    	int y = 4;
    	for(int i = 0; i < embarcacoes.size(); i++) {
    		for(int x = 0; x < y; x++) {
    			System.out.println(y);
    			System.out.printf("plotando navio de %d cano \n", i+1);
    			escolherPosicaoDaEmbarcacao(embarcacoes.get(i));
    		}
    		y = y - 1;
    		if(y == 0) {
    			escolherPosicaoDaEmbarcacao(embarcacoes.get(4));
    		}

    	}
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


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}
}

