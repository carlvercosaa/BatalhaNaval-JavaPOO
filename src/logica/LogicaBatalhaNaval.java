package logica;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ExceptionsDaBatalha.DirecaoInvalidaException;
import ExceptionsDaBatalha.EixoInvalidoException;
import ExceptionsDaBatalha.ForaDoIndiceException;
import ExceptionsDaBatalha.ForaDosLimitesDoArrayException;
import ExceptionsDaBatalha.PlotagemException;
import enity.Embarcacao;
import enity.Jogador;

public abstract class LogicaBatalhaNaval {
	
	public static void inicializaJogo() throws PlotagemException, ForaDoIndiceException, ForaDosLimitesDoArrayException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--------------");
		System.out.println("     MENU     ");
		System.out.println("--------------");
		System.out.println("1- Jogar");
		System.out.println("3- Sair");
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		
		int escolha = scanner.nextInt();
		
		if(escolha == 1) {
		
			System.out.println("-----------------------");
	    	System.out.println("     CONFIGURAÇÕES     ");
	    	System.out.println("-----------------------");
	    	System.out.println("1- Modo normal");
	    	System.out.println("2- Modo custom");
	    	System.out.println("-----------------------");
	    	System.out.println("Digite qual modo você quer jogar: ");
	    	
	    	int modo = scanner.nextInt();
	    	
	    	
			if(modo == 1) {
				Jogador jogador1 = new Jogador(1);
				jogador1.setVida(25);
		    	LogicaBatalhaNaval.plotandoTodosNavios(jogador1);
		    	
		    	Jogador jogador2 = new Jogador(2);
		    	jogador2.setVida(25);
		    	LogicaBatalhaNaval.plotandoTodosNavios(jogador2);
		    	
		    	LogicaBatalhaNaval.trocandoDeTurno(jogador1, jogador2);
		    }else if(modo == 2) {
		    	Jogador jogador1 = new Jogador(1);
		    	LogicaBatalhaNaval.plotandoTodosNaviosCustom(jogador1);
		    		
		    	Jogador jogador2 = new Jogador(2);
		    	LogicaBatalhaNaval.plotandoTodosNaviosCustom(jogador2);
		    	
		    	LogicaBatalhaNaval.trocandoDeTurno(jogador1, jogador2);
			}
		}else if(escolha == 2) {
			
		}
	}
	
	public static void plotandoTodosNavios(Jogador jogador) throws PlotagemException, ForaDoIndiceException, ForaDosLimitesDoArrayException {
    	List<Embarcacao> embarcacoes = Arrays.asList(jogador.getNavioDe1Cano(), jogador.getNavioDe2Canos(), jogador.getNavioDe3Canos(), jogador.getNavioDe4Canos(), jogador.getPortaAvioes());
    	int y = 3;
    	for(int i = 0; i < embarcacoes.size(); i++) {
    		Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(i),jogador);
    		for(int x = 0; x < y; x++) {
    			System.out.println(y);
    			System.out.printf("plotando navio de %d cano \n", i+1);
    			Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(i),jogador);
    		}
    		y = y - 1;
    		if(y == 0) {
    			Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(3),jogador);
    			Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(4),jogador);
    			return;
    		}

    	}
    }
	
	public static void plotandoTodosNaviosCustom(Jogador jogador) throws PlotagemException, ForaDoIndiceException, ForaDosLimitesDoArrayException{
    	List<Embarcacao> embarcacoes = Arrays.asList(jogador.getNavioDe1Cano(), jogador.getNavioDe2Canos(), jogador.getNavioDe3Canos(), jogador.getNavioDe4Canos(), jogador.getPortaAvioes());
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Jogador " + jogador.getNumero() + " plotando navios...");

    	for(int i = 0; i < embarcacoes.size(); i++) {
    		if(i == 4) {
    			System.out.println("Digite a quantidade de Porta-Aviões: ");
    			int quantidade = scanner.nextInt();
    			jogador.setVida(jogador.getVida() + ((i+1) * quantidade));
    			for(int x = 0; x < quantidade; x++) {
    	    		System.out.printf("plotando Porta-Aviões \n");
    	    		try {
						Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(i),jogador);
					} catch (PlotagemException e) {
						e.getMessage();
						Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(i),jogador);
					}
    	    	}
    		}else {
    			System.out.printf("Digite a quantidade de navios de %d canos: ", i+1);
    	        int quantidade = scanner.nextInt();
    	        jogador.setVida(jogador.getVida() + ((i+1) * quantidade));
    	        for(int x = 0; x < quantidade; x++) {
    	    		System.out.printf("plotando navio de %d canos \n", i+1);
    	    		try {
						Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(i),jogador);
					} catch (PlotagemException e) {
						e.getMessage();
						Jogador.escolherPosicaoDaEmbarcacao(embarcacoes.get(i),jogador);
					}
    	        }
    		}
    	}
    }
	
	public static void vencedorDaPartida(Jogador jogador) {
		System.out.println("Parabéns, o Jogador " + jogador.getNumero() + " VENCEU a partida!");
		jogador.setPontuacao(jogador.getPontuacao() + 1);
	}
	
    public static void trocandoDeTurno(Jogador jogador1, Jogador jogador2) throws PlotagemException, ForaDoIndiceException, ForaDosLimitesDoArrayException {
    	while(Jogador.verificaMorte(jogador1)) {
    		jogador1.getTabuleiroAtaque().mostraGrelha();
    		jogador1.disparo(jogador2);
    		jogador1.getTabuleiroAtaque().mostraGrelha();
    		if(Jogador.verificaMorte(jogador2)) {
    			jogador2.getTabuleiroAtaque().mostraGrelha();
    			jogador2.disparo(jogador1);
    			jogador2.getTabuleiroAtaque().mostraGrelha();
    		}else {
    			vencedorDaPartida(jogador1);
    			LogicaBatalhaNaval.inicializaJogo();
    		}
    	}
    	vencedorDaPartida(jogador2);
    	LogicaBatalhaNaval.inicializaJogo();
    }
    
    public static int perguntarLinha() throws ForaDoIndiceException {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Digite a linha: ");
        int linha = scanner.nextInt();
        if(linha < 0 || linha > 9) {
        	throw new ForaDoIndiceException("Não é possivel plotar o navio nessa posição!... tente plotar novamente.");
        }
        return linha;
    }
    
    public static int perguntarColuna() throws ForaDoIndiceException {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Digite a coluna: ");
        int coluna = scanner.nextInt();
        if(coluna < 0 || coluna > 9) {
        	throw new ForaDoIndiceException("Não é possivel plotar o navio nessa posição!... tente plotar novamente.");
        }
        
        return coluna;
    }
    
    public static String perguntarDirecao() throws DirecaoInvalidaException {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Escolha a direcao que a embarcação será plotada(BAIXO,CIMA,DIREITA OU ESQUERDA). : " );
    	
    	String direcao = scanner.next();
    	
    	direcao = direcao.toUpperCase();
    	
    	if(direcao.equals("BAIXO") || direcao.equals("CIMA") || direcao.equals("DIREITA") || direcao.equals("ESQUERDA")) {
    		return direcao;
    	}else {
    		perguntarDirecao();
    		throw new DirecaoInvalidaException("Direção inexistente!... tente plotar novamente.");
    	}
    }
}
