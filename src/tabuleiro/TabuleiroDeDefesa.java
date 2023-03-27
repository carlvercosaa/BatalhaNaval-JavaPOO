package tabuleiro;

import enity.Jogador;

public class TabuleiroDeDefesa extends Tabuleiro implements Grelhas {
	
	

	public void mostraGrelha(){
        System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
        System.out.println();
        
        for(int linha=0 ; linha < 10 ; linha++ ){
            System.out.print((linha)+"");
            for(int coluna=0 ; coluna < 10 ; coluna++ ){
                if(super.getTabuleiroJogador()[linha][coluna]== -1){
                    System.out.print("\t"+"~");
                }else if(super.getTabuleiroJogador()[linha][coluna]== 1 || super.getTabuleiroJogador()[linha][coluna]== 2 || super.getTabuleiroJogador()[linha][coluna]== 3 || super.getTabuleiroJogador()[linha][coluna]== 4 ){
                    System.out.print("\t"+"N");
                }else if(super.getTabuleiroJogador()[linha][coluna]== 5) {
                	System.out.print("\t"+"P");
                }
                
            }
            System.out.println();
        }

	}
	
	public void verificarEPlotarVerticalParaBaixo(int tamanho, int  linha, int  coluna){
        int contador = 0;
        
        if(tamanho == 5) {
    		for(int c = 0; c < 3; c++){
                if(super.getTabuleiroJogador()[linha+c][coluna] == -1){
                    contador += 1;
                }
                if(c == 2) {
                	if(super.getTabuleiroJogador()[linha+c][coluna-1] == -1){
                        contador += 1;
                    }
                	if(super.getTabuleiroJogador()[linha+c][coluna+1] == -1) {
                		contador += 1;
                	}
                }
    		}
        }else {
        	for(int c = 0; c < tamanho; c++){
                if(super.getTabuleiroJogador()[linha+c][coluna] == -1){
                    contador += 1;
                }
            }
        }
        
        
        	if(contador == tamanho && tamanho == 1){
                for(int c = 0; c < tamanho; c++){
                	super.getTabuleiroJogador()[linha+c][coluna] = 1;
                }
            }
            else if(contador == tamanho && tamanho == 2){
                for(int c = 0; c < tamanho; c++){
                	super.getTabuleiroJogador()[linha+c][coluna] = 2;
                }
        	}
        	else if(contador == tamanho && tamanho == 3){
                for(int c = 0; c < tamanho; c++){
                	super.getTabuleiroJogador()[linha+c][coluna] = 3;
                }
        	}
        	else if(contador == tamanho && tamanho == 4){
                for(int c = 0; c < tamanho; c++){
                	super.getTabuleiroJogador()[linha+c][coluna] = 4;
                }
        	}
        	else if(contador == tamanho && tamanho == 5){
                for(int c = 0; c < 3; c++){
                	super.getTabuleiroJogador()[linha+c][coluna] = 5;
                    if(c == 2) {
                    	super.getTabuleiroJogador()[linha+c][coluna-1] = 5;
                    	super.getTabuleiroJogador()[linha+c][coluna+1] = 5;
                    }
                }
        	}
        	else{
        		throw new RuntimeException("Nao e possivel plotar nessa direcao(ja existem navios presentes).");
        	}
        }
    
    public void verificarEPlotarVerticalParaCima(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	if(tamanho == 5) {
    		for(int c = 0; c < 3; c++){
                if(super.getTabuleiroJogador()[linha-c][coluna] == -1){
                    contador += 1;
                }
                if(c == 2) {
                	if(super.getTabuleiroJogador()[linha-c][coluna-1] == -1){
                        contador += 1;
                    }
                	if(super.getTabuleiroJogador()[linha-c][coluna+1] == -1) {
                		contador += 1;
                	}
                }
    		}
        }else {
        	for(int c = 0; c < tamanho; c++){
                if(super.getTabuleiroJogador()[linha-c][coluna] == -1){
                    contador += 1;
                }
            }
        }
    	if(contador == tamanho && tamanho == 1){
    		for(int c = 0; c < tamanho; c++){
    			super.getTabuleiroJogador()[linha-c][coluna] = 1;
        	}
        }
        else if(contador == tamanho && tamanho == 2){
        	for(int c = 0; c < tamanho; c++){
        		super.getTabuleiroJogador()[linha-c][coluna] = 2;
            }
        }
        else if(contador == tamanho && tamanho == 3){
        	for(int c = 0; c < tamanho; c++){
        		super.getTabuleiroJogador()[linha-c][coluna] = 3;
            }
        }
        else if(contador == tamanho && tamanho == 4){
        	for(int c = 0; c < tamanho; c++){
        		super.getTabuleiroJogador()[linha-c][coluna] = 4;
            }
        }
     	else if(contador == tamanho && tamanho == 5){
     		for(int c = 0; c < 3; c++){
     			super.getTabuleiroJogador()[linha-c][coluna] = 5;
                if(c == 2) {
                	super.getTabuleiroJogador()[linha-c][coluna+1] = 5;
                	super.getTabuleiroJogador()[linha-c][coluna-1] = 5;
                }
            }
     	}
        else{
        	throw new RuntimeException("Nao e possivel plotar nessa direcao(ja existem navios presentes).");
        }
	}
    
    public void verificarEPlotarHorizontalParaDireita(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	
    	if(tamanho == 5) {
    		for(int c = 0; c < 3; c++){
                if(super.getTabuleiroJogador()[linha][coluna+c] == -1){
                    contador += 1;
                }
                if(c == 2) {
                	if(super.getTabuleiroJogador()[linha+1][coluna+c] == -1){
                        contador += 1;
                    }
                	if(super.getTabuleiroJogador()[linha-1][coluna+c] == -1) {
                		contador += 1;
                	}
                }
    		}
        }
    	else{
    		try {
    			contador = calculandoContador(tamanho, linha, coluna, contador);
			}
    		catch (RuntimeException e) {
				System.out.println(e.getMessage());
				return;
    		}
        }
    	if(contador == tamanho && tamanho == 1){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna+c] = 1;
            }
        }
    	else if(contador == tamanho && tamanho == 2){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna+c] = 2;
            }
    	}
    	else if(contador == tamanho && tamanho == 3){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna+c] = 3;
            }
    	}
    	else if(contador == tamanho && tamanho == 4){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna+c] = 4;
            }
    	}
    	else if(contador == tamanho && tamanho == 5){
            for(int c = 0; c < 3; c++){
            	super.getTabuleiroJogador()[linha][coluna+c] = 5;
                if(c == 2) {
                	super.getTabuleiroJogador()[linha-1][coluna+c] = 5;
                	super.getTabuleiroJogador()[linha+1][coluna+c] = 5;
                }
            }
    	}
    	else{
    		throw new RuntimeException("Nao e possivel plotar nessa direcao(ja existem navios presentes).");
    	}
    }
 
    public void verificarEPlotarHorizontalParaEsquerda(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	
    	if(tamanho == 5) {
    		for(int c = 0; c < 3; c++){
                if(super.getTabuleiroJogador()[linha][coluna-c] == -1){
                    contador += 1;
                }
                if(c == 2) {
                	if(super.getTabuleiroJogador()[linha+1][coluna-c] == -1){
                        contador += 1;
                    }
                	if(super.getTabuleiroJogador()[linha-1][coluna-c] == -1) {
                		contador += 1;
                	}
                }
    		}
        }else {
        	for(int c = 0; c < tamanho; c++){
                if(super.getTabuleiroJogador()[linha][coluna-c] == -1){
                    contador += 1;
                }
        	}
        }
    	if(contador == tamanho && tamanho ==1){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna-c] = 1;
            }
        }
    	else if(contador == tamanho && tamanho == 2){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna-c] = 2;
            }
    	}
    	else if(contador == tamanho && tamanho == 3){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna-c] = 3;
            }
    	}
    	else if(contador == tamanho && tamanho == 4){
            for(int c = 0; c < tamanho; c++){
            	super.getTabuleiroJogador()[linha][coluna-c] = 4;
            }
    	}
    	else if(contador == tamanho && tamanho == 5){
            for(int c = 0; c < 3; c++){
            	super.getTabuleiroJogador()[linha][coluna-c] = 5;
                if(c == 2) {
                	super.getTabuleiroJogador()[linha-1][coluna-c] = 5;
                	super.getTabuleiroJogador()[linha+1][coluna-c] = 5;
                }
            }
    	}
    	else{
    		throw new RuntimeException("Nao e possivel plotar nessa direcao(ja existem navios presentes).");
    	}
    }
    
    public String verificaDisparo(int linha, int coluna, Jogador adversario) {
    	if(super.getTabuleiroJogador()[linha][coluna]== 1) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiroDefesa().destroiParteDaEmbarcacao(linha, coluna);
    		return "Afundou o meu Navio-de-1-cano na posição "+ linha + "-" + coluna;
    	}
    	else if(super.getTabuleiroJogador()[linha][coluna] == 2) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiroDefesa().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Navio-De-2-Canos na posição "+ linha + "-" + coluna;
    	}
    	else if(super.getTabuleiroJogador()[linha][coluna]== 3) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiroDefesa().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Navio-De-3-Canos na posição "+ linha + "-" + coluna;
    	}
    	else if(super.getTabuleiroJogador()[linha][coluna]== 4) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiroDefesa().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Navio-De-4-Canos na posição "+ linha + "-" + coluna;
    	}
    	else if(super.getTabuleiroJogador()[linha][coluna]== 5) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiroDefesa().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Porta-Aviões na posicao "+ linha + "-" + coluna;
    	}
    	else if(super.getTabuleiroJogador()[linha][coluna]== -1) {
    		return "Acertou água na posição "+ linha + "-" + coluna;
    	}
    	else {
    		return null;
    	}
    }

    public int calculandoContador(int tamanho, int linha, int coluna, int contador) {
    	for(int c = 0; c < tamanho; c++){
            if(super.getTabuleiroJogador()[linha][coluna+c] == -1){
                contador += 1;
            }
            else
            {
            	throw new RuntimeException("Nao e possivel plotar nessa direcao(ja existem navios presentes).");
            }
        }
    	return contador;
    }
}
