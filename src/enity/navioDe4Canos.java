package enity;
import java.util.Scanner;
import tabuleiro.tabuleiro;

public class navioDe4Canos extends embarcacao{
    
    public navioDe4Canos(jogador jogador) {
        super(jogador, "navio De 4 Canos", 4);
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