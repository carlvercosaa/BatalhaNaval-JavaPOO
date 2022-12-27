package enity;
import tabuleiro.tabuleiro;

public class navioDe1Cano extends embarcacao{
    protected int tamanho = 1;
    
    public navioDe1Cano(jogador jogador, int numeroJogador) {
        super(jogador, numeroJogador, 1);
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
