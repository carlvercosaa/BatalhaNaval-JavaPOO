package enity;

import java.util.Scanner;

import ExceptionsDaBatalha.PlotagemException;

import java.util.Arrays;
import java.util.List;

import tabuleiro.TabuleiroDeAtaque;
import tabuleiro.TabuleiroDeDefesa;

public class Jogador {
    private TabuleiroDeAtaque tabuleiroAtaque;
    private TabuleiroDeDefesa tabuleiroDefesa;
    private NavioDe1Cano navioDe1Cano;
    private NavioDe2Canos navioDe2Canos;
    private NavioDe3Canos navioDe3Canos;
    private NavioDe4Canos navioDe4Canos;
    private PortaAvioes portaAvioes;
    private int numero;
    private int vida = 25;
	
	    
    
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
			
			getTabuleiroAtaque().marcaNaGrelha(linha, coluna, adversario);
			
			posicoes[i] = adversario.getTabuleiroDefesa().verificaDisparo(linha, coluna, adversario);
			
		}
		
		for(int c = 0; c < 3; c++) {
			System.out.println(posicoes[c]);
		}
		
	
		return true;
    }

	public void escolherPosicaoDaEmbarcacao(Embarcacao nomeDaEmbarcacao) throws PlotagemException{
        Scanner scanner = new Scanner(System.in);
        
        int linha;
        int coluna;
        String direcao;
        
        if(nomeDaEmbarcacao.getNomeDaEmbarcacao()==("Navio_De_1_Cano")){
        	this.tabuleiroDefesa.mostraGrelha();
            
        	System.out.println("Jogador: " + this.numero);
        	
        	System.out.print("digite a coluna: ");
            coluna = scanner.nextInt();
            
            System.out.print("digite a linha: ");
            linha = scanner.nextInt();
            
            try {
            	this.tabuleiroDefesa.verificarEPlotarHorizontalParaDireita(nomeDaEmbarcacao.getTamanho(), linha, coluna);
            }
            catch (PlotagemException e) {
				System.out.println(e.getMessage());
			}
            
            this.tabuleiroDefesa.mostraGrelha();
            
        }else{
            System.out.println("Escolha o eixo que a embarcação será plotada(VERTICAL ou HORIZONTAL). : " );
            String eixo = scanner.next().toUpperCase();
            
            if(eixo.equals("VERTICAL")){
            	this.tabuleiroDefesa.mostraGrelha(); 
                System.out.print("Digite a coluna: ");
                coluna = scanner.nextInt();
                
                System.out.print("Digite a linha: ");
                linha = scanner.nextInt();
                
                System.out.println("Escolha a direcao que a embarcação será plotada(BAIXO ou CIMA). : " );
                direcao = scanner.next().toUpperCase();
                
                if(direcao.equals("BAIXO")) {        
                	try {
                		this.tabuleiroDefesa.verificarEPlotarVerticalParaBaixo(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                    	this.tabuleiroDefesa.mostraGrelha();
					}
                	catch (PlotagemException e) {
                		System.out.println(e.getMessage());
					}

                }
                
                else if(direcao.equals("CIMA")) {    
                	try {
                		this.tabuleiroDefesa.verificarEPlotarVerticalParaCima(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                    	this.tabuleiroDefesa.mostraGrelha();
					} 
                	catch (PlotagemException e) {
						System.out.println(e.getMessage());
					}
                }
            }
            else if(eixo.equals("HORIZONTAL")){
            	this.tabuleiroDefesa.mostraGrelha(); 
                System.out.print("Digite a coluna: ");
                coluna = scanner.nextInt();
                
                System.out.print("Digite a linha: ");
                linha = scanner.nextInt();
                
                System.out.println("Escolha a direcao em que a embarcação será plotada(DIREITA ou ESQUERDA). : " );
                direcao = scanner.next().toUpperCase();
                
                if(direcao.equals("DIREITA")) {        
                	try {
                		this.tabuleiroDefesa.verificarEPlotarHorizontalParaDireita(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                    	this.tabuleiroDefesa.mostraGrelha();
					} 
                	catch (PlotagemException e) {
						System.out.println(e.getMessage());
					}
                	
                }
                else if(direcao.equals("ESQUERDA")){
                	try {
                		this.tabuleiroDefesa.verificarEPlotarHorizontalParaEsquerda(nomeDaEmbarcacao.getTamanho(), linha, coluna);
                    	this.tabuleiroDefesa.mostraGrelha();
					} 
                	catch (PlotagemException e) {
						System.out.println(e.getMessage());
					}
                	
                }
            }
            
        }
       }
    
    public void plotandoTodosNavios() throws PlotagemException{
    	List<Embarcacao> embarcacoes = Arrays.asList(getNavioDe1Cano(), getNavioDe2Canos(), getNavioDe3Canos(), getNavioDe4Canos(), getPortaAvioes());
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Jogador " + this.numero + " plotando navios...");

    	for(int i = 0; i < embarcacoes.size(); i++) {
    		if(i == 4) {
    			System.out.println("Digite a quantidade de Porta-Aviões: ");
    			int quantidade = scanner.nextInt();
    			for(int x = 0; x < quantidade; x++) {
    	    		System.out.printf("plotando Porta-Aviões \n");
    	    		escolherPosicaoDaEmbarcacao(embarcacoes.get(i));
    	    	}
    		}else {
    			System.out.printf("Digite a quantidade de navios de %d canos: ", i+1);
    	        int quantidade = scanner.nextInt();
    	        for(int x = 0; x < quantidade; x++) {
    	    		System.out.printf("plotando navio de %d cano \n", i+1);
    	    		escolherPosicaoDaEmbarcacao(embarcacoes.get(i));
    	        }
    		}
    	}
    }
    
    public boolean verificaMorte(Jogador jogador) {
    	if(jogador.getVida() > 0) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public static void trocandoDeTurno(Jogador jogador1, Jogador jogador2) {
    	while(jogador1.getVida() > 0 || jogador2.getVida() > 0) {
    		jogador1.disparo(jogador2);
    		jogador1.getTabuleiroAtaque().mostraGrelha();
    		if(jogador1.verificaMorte(jogador2)) {
    			jogador2.disparo(jogador1);
    			jogador2.getTabuleiroAtaque().mostraGrelha();
        		jogador2.verificaMorte(jogador1);
    		}else {
    			break;
    		}
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

}

