package batalhanaval;

import ExceptionsDaBatalha.PlotagemException;
import enity.Jogador;

public class BatalhaNaval {

	public static void main(String[] args) throws PlotagemException {
    	Jogador jogador1 = new Jogador(1);
    	jogador1.plotandoTodosNavios();
    	
    	Jogador jogador2 = new Jogador(2);
    	jogador2.plotandoTodosNavios();
    	
    	Jogador.trocandoDeTurno(jogador1, jogador2);
    }
    
}
