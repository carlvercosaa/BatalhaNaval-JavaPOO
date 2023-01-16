package enity;
import java.util.Scanner;
import tabuleiro.tabuleiro;

public class navioDe2Canos extends embarcacao{
    
    public navioDe2Canos(jogador jogador) {
        super(jogador, "navio De 2 Canos", 2);
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