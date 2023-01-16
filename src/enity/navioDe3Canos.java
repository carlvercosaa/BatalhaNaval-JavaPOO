package enity;
import java.util.Scanner;
import tabuleiro.tabuleiro;

public class navioDe3Canos extends embarcacao{
    
    public navioDe3Canos(jogador jogador) {
        super(jogador, "navio De 3 Canos", 3);
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