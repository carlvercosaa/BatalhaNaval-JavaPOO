package enity;
import java.util.Scanner;
import tabuleiro.tabuleiro;

public class navioDe1Cano extends embarcacao{
    
    public navioDe1Cano(jogador jogador) {
        super(jogador, "navio De 1 Cano", 1);
    }

    @Override
	public String getnomeDaEmbarcacao() {
		return super.getNomeDaEmbarcacao();
	}

	@Override
	public int getTamanho() {
		return super.getTamanho();
	}
   
    public void escolherPosicaoDaEmbarcacao(tabuleiro  tabuleiro) {
        super.escolherPosicaoDaEmbarcacao(tabuleiro);
    }   
}