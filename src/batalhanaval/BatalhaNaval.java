package batalhanaval;

import ExceptionsDaBatalha.ForaDoIndiceException;
import ExceptionsDaBatalha.PlotagemException;
import enity.Jogador;
import logica.LogicaBatalhaNaval;

public class BatalhaNaval {
	public static void main(String[] args) throws PlotagemException, ForaDoIndiceException {
		LogicaBatalhaNaval.inicializaJogo();
	}
}
