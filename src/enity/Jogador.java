package enity;

import java.util.Scanner;

import ExceptionsDaBatalha.DirecaoInvalidaException;
import ExceptionsDaBatalha.EixoInvalidoException;
import ExceptionsDaBatalha.ForaDoIndiceException;
import ExceptionsDaBatalha.ForaDosLimitesDoArrayException;
import ExceptionsDaBatalha.PlotagemException;
import logica.LogicaBatalhaNaval;

import java.util.Arrays;
import java.util.List;

import tabuleiro.TabuleiroDeAtaque;
import tabuleiro.TabuleiroDeDefesa;

public class Jogador {
    private static Object eixo;
	private static String direcao;
	private TabuleiroDeAtaque tabuleiroAtaque;
    private TabuleiroDeDefesa tabuleiroDefesa;
    private NavioDe1Cano navioDe1Cano;
    private NavioDe2Canos navioDe2Canos;
    private NavioDe3Canos navioDe3Canos;
    private NavioDe4Canos navioDe4Canos;
    private PortaAvioes portaAvioes;
    private int numero;
    private int vida;
    private int pontuacao = 0;
	
	    
    
    public Jogador(int numero){
    	this.tabuleiroAtaque = new TabuleiroDeAtaque();
    	this.tabuleiroDefesa = new TabuleiroDeDefesa();
    	this.navioDe1Cano = new NavioDe1Cano(this);
    	this.navioDe2Canos = new NavioDe2Canos(this);
    	this.navioDe3Canos = new NavioDe3Canos(this);
    	this.navioDe4Canos = new NavioDe4Canos(this);
    	this.portaAvioes = new PortaAvioes(this);
    	this.numero = numero;
    }


	public boolean disparo(Jogador adversario) {
		
		int coluna = 0;
		int linha = 0;
		String[] posicoes = new String[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.println("----------------------------");
			System.out.println("Jogador" + this.numero);
			System.out.println("Dispare contra o inimigo");
			try {
				coluna = LogicaBatalhaNaval.perguntarColuna();
			} catch (ForaDoIndiceException e1) {
				e1.getMessage();
				disparo(adversario);
			}
			try {
				linha = LogicaBatalhaNaval.perguntarLinha();
			} catch (ForaDoIndiceException e) {
				e.getMessage();
				disparo(adversario);
			}
			
			getTabuleiroAtaque().marcaNaGrelha(linha, coluna, adversario);
			
			posicoes[i] = adversario.getTabuleiroDefesa().verificaDisparo(linha, coluna, adversario);
			
		}
		
		for(int c = 0; c < 3; c++) {
			System.out.println(posicoes[c]);
		}
		
	
		return true;
    }

	public static void escolherPosicaoDaEmbarcacao(Embarcacao nomeDaEmbarcacao,Jogador jogador) throws PlotagemException, ForaDoIndiceException, ForaDosLimitesDoArrayException{
        
        int linha = 0;
        int coluna = 0;
        
        if(nomeDaEmbarcacao.getNomeDaEmbarcacao()==("Navio_De_1_Cano")){
        	jogador.tabuleiroDefesa.mostraGrelha();
            
        	System.out.println("Jogador: " + jogador.numero);
        	try {
        		coluna = LogicaBatalhaNaval.perguntarColuna();
        	}catch(ForaDoIndiceException e){
        		e.getMessage();
        		Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
        	}
            
        	try {
        		linha = LogicaBatalhaNaval.perguntarLinha();
        	}catch(ForaDoIndiceException e) {
        		e.getMessage();
        		Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
        	}
            
            try {
            	jogador.tabuleiroDefesa.verificarEPlotarHorizontalParaDireita(nomeDaEmbarcacao.getTamanho(), linha, coluna);
            }
            catch (PlotagemException e) {
				System.out.println(e.getMessage());
				Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
			}
            
            jogador.tabuleiroDefesa.mostraGrelha();
            
        }else{
        	try{
        		direcao = LogicaBatalhaNaval.perguntarDirecao();
			}catch (DirecaoInvalidaException e1) {
				e1.getMessage();
			}

            try {
            	coluna = LogicaBatalhaNaval.perguntarColuna();
            }catch(ForaDoIndiceException e){
            	e.getMessage();
            	Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
           	}
                
           	try {
           		linha = LogicaBatalhaNaval.perguntarLinha();
           	}catch(ForaDoIndiceException e) {
           		e.getMessage();
           		Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
           	}

                
           if(direcao.equals("BAIXO")) {        
                try {
                	jogador.tabuleiroDefesa.verificarEPlotarVerticalParaBaixo(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                	jogador.tabuleiroDefesa.mostraGrelha();
				}
                catch (PlotagemException e) {
                	System.out.println(e.getMessage());
                	Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
				}

           }
                
          else if(direcao.equals("CIMA")) {    
               	try {
               		jogador.tabuleiroDefesa.verificarEPlotarVerticalParaCima(nomeDaEmbarcacao.getTamanho(), linha, coluna);
               		jogador.tabuleiroDefesa.mostraGrelha();
               	} 
                catch (PlotagemException e) {
					System.out.println(e.getMessage());
					Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
				}
          }                
             
          else if(direcao.equals("DIREITA")) {        
        	 	try{
                	jogador.tabuleiroDefesa.verificarEPlotarHorizontalParaDireita(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                	jogador.tabuleiroDefesa.mostraGrelha();
				} 
                catch (PlotagemException e) {
					System.out.println(e.getMessage());
					Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
				}
                	
          }
          else if(direcao.equals("ESQUERDA")){
               	try {
               		jogador.tabuleiroDefesa.verificarEPlotarHorizontalParaEsquerda(nomeDaEmbarcacao.getTamanho(), linha, coluna);
               		jogador.tabuleiroDefesa.mostraGrelha();
				} 
               	catch (PlotagemException e) {
					System.out.println(e.getMessage());
					Jogador.escolherPosicaoDaEmbarcacao(nomeDaEmbarcacao, jogador);
				}
               	
               }
           }
            
       }
    
    public static boolean verificaMorte(Jogador jogador) {
    	if(jogador.getVida() > 0) {
    		return true;
    	}else {
    		return false;
    	}
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
	
    public TabuleiroDeAtaque getTabuleiroAtaque() {
		return tabuleiroAtaque;
	}


	public void setTabuleiroAtaque(TabuleiroDeAtaque tabuleiroAtaque) {
		this.tabuleiroAtaque = tabuleiroAtaque;
	}


	public TabuleiroDeDefesa getTabuleiroDefesa() {
		return tabuleiroDefesa;
	}


	public void setTabuleiroDefesa(TabuleiroDeDefesa tabuleiroDefesa) {
		this.tabuleiroDefesa = tabuleiroDefesa;
	}


	public int getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}

