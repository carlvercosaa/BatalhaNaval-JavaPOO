package batalhanaval;

import ExceptionsDaBatalha.ForaDoIndiceException;
import ExceptionsDaBatalha.ForaDosLimitesDoArrayException;
import ExceptionsDaBatalha.PlotagemException;
import logica.LogicaBatalhaNaval;

public class BatalhaNaval{
	public static void main(String[] args) throws PlotagemException, ForaDoIndiceException, ForaDosLimitesDoArrayException {
		LogicaBatalhaNaval.inicializaJogo();
	}
}
