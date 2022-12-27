package batalhanaval;

import enity.embarcacao;
import enity.jogador;
import enity.navioDe1Cano;
import enity.navioDe2Canos;
import tabuleiro.tabuleiro;

public class BatalhaNaval {

    public static void main(String[] args) {
        tabuleiro tabuleiro1 = new tabuleiro();
        tabuleiro tabuleiro2 = new tabuleiro();
        
        
        int[][] tabuleiroJogador1 = tabuleiro1.inicializaGrelha();
        int[][] tabuleiroJogador2 = tabuleiro2.inicializaGrelha();
    
        jogador jogador1 = new jogador(1, tabuleiroJogador1);
        jogador jogador2 = new jogador(2, tabuleiroJogador2);
   
        
        navioDe1Cano naviode1cano = new navioDe1Cano(jogador1,jogador1.getNUMERODOJOGADOR());
        navioDe2Canos naviode2canos = new navioDe2Canos(jogador1, jogador1.getNUMERODOJOGADOR());
        
        embarcacao embarcacao1 = new embarcacao(jogador1, jogador1.getNUMERODOJOGADOR(), naviode1cano.getTamanho());
        embarcacao embarcacao2 = new embarcacao(jogador1, jogador1.getNUMERODOJOGADOR(),naviode2canos.getTamanho());
        
        embarcacao1.escolherPosicaoDaEmbarcacao(tabuleiro1);
        embarcacao2.escolherPosicaoDaEmbarcacao(tabuleiro1);
        
        tabuleiro.mostraGrelhaDeAtaque(tabuleiroJogador1);
    
    }
    
}
