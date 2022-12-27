package enity;
import tabuleiro.tabuleiro;

public class navioDe4Canos extends embarcacao{
    protected int tamanho = 4;
   
    public navioDe4Canos(enity.jogador jogador, int numeroJogador) {
        super(jogador, numeroJogador, 4);
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
