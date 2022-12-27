package enity;

import tabuleiro.tabuleiro;

public class navioDe2Canos extends embarcacao{
    protected int tamanho = 2;
   
    public navioDe2Canos(enity.jogador jogador, int numeroJogador) {
        super(jogador, numeroJogador, 2);
    }

    @Override
    public String toString() {
        return "navioDe1Cano{" + '}';
    }
   
    public void escolherPosicaoDaEmbarcacao(tabuleiro  tabuleiro) {
		// TODO Auto-generated method stub
        super.escolherPosicaoDaEmbarcacao(tabuleiro);
    }
    
}
