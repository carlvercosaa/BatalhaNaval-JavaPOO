package tabuleiro;

import enity.Jogador;

public class Tabuleiro {
    private int[][] tabuleiroJogador = new int[10][10];

    public Tabuleiro() {
    	this.inicializaGrelha();
    }
    
    
    public void inicializaGrelha(){
            for(int linha=0 ; linha < 10 ; linha++ ){
                for(int coluna=0 ; coluna < 10 ; coluna++ ){
                    this.tabuleiroJogador[linha][coluna]=-1;
                }
            }
        }
        
	 public void mostraGrelhaDeDefesa(){
	        System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
	        System.out.println();
	        
	        for(int linha=0 ; linha < 10 ; linha++ ){
	            System.out.print((linha)+"");
	            for(int coluna=0 ; coluna < 10 ; coluna++ ){
	                if(this.tabuleiroJogador[linha][coluna]==-1){
	                    System.out.print("\t"+"~");
	                }else if(this.tabuleiroJogador[linha][coluna]==1 || this.tabuleiroJogador[linha][coluna]==2 || this.tabuleiroJogador[linha][coluna]==3 || this.tabuleiroJogador[linha][coluna]==4 ){
	                    System.out.print("\t"+"N");
	                }else if(this.tabuleiroJogador[linha][coluna]==1){
	                    System.out.print("\t"+"X");
	                }
	                
	            }
	            System.out.println();
	        }

    }

    public void verificarEPlotarVerticalParaBaixo(int tamanho, int  linha, int  coluna){
        int contador = 0;
        for(int c = 0; c < tamanho; c++){
            if(this.tabuleiroJogador[linha+c][coluna] == -1){
                contador += 1;
            }
        }
        if(contador == tamanho && tamanho == 1){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha+c][coluna] = 1;
            }
        }
        else if(contador == tamanho && tamanho == 2){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha+c][coluna] = 2;
            }
    	}
    	else if(contador == tamanho && tamanho == 3){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha+c][coluna] = 3;
            }
    	}
    	else if(contador == tamanho && tamanho == 4){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha+c][coluna] = 4;
            }
    	}
    	else if(contador == tamanho && tamanho == 5){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha+c][coluna] = 5;
            }
    	}
    }
    
    public void verificarEPlotarVerticalParaCima(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	for(int c = 0; c < tamanho; c++){
            if(this.tabuleiroJogador[linha-c][coluna] == -1){
                contador += 1;
            }
        }
    	if(contador == tamanho && tamanho == 1){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha-c][coluna] = 1;
            }
        }
    	else if(contador == tamanho && tamanho == 2){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha-c][coluna] = 2;
            }
    	}
    	else if(contador == tamanho && tamanho == 3){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha-c][coluna] = 3;
            }
    	}
    	else if(contador == tamanho && tamanho == 4){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha-c][coluna] = 4;
            }
    	}
    	else if(contador == tamanho && tamanho == 5){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha-c][coluna] = 5;
            }
    	}
    }
    
    public void verificarEPlotarHorizontalParaDireita(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	for(int c = 0; c < tamanho; c++){
            if(this.tabuleiroJogador[linha][coluna+c] == -1){
                contador += 1;
            }
        }
    	if(contador == tamanho && tamanho == 1){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna+c] = 1;
            }
        }
    	else if(contador == tamanho && tamanho == 2){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna+c] = 2;
            }
    	}
    	else if(contador == tamanho && tamanho == 3){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna+c] = 3;
            }
    	}
    	else if(contador == tamanho && tamanho == 4){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna+c] = 4;
            }
    	}
    	else if(contador == tamanho && tamanho == 5){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna+c] = 5;
            }
    	}
    }
 
    public void verificarEPlotarHorizontalParaEsquerda(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	for(int c = 0; c < tamanho; c++){
            if(this.tabuleiroJogador[linha][coluna-c] == -1){
                contador += 1;
            }
        }
    	if(contador == tamanho && tamanho ==1){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna-c] = 1;
            }
        }
    	else if(contador == tamanho && tamanho == 2){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna-c] = 2;
            }
    	}
    	else if(contador == tamanho && tamanho == 3){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna-c] = 3;
            }
    	}
    	else if(contador == tamanho && tamanho == 4){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna-c] = 4;
            }
    	}
    	else if(contador == tamanho && tamanho == 5){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna-c] = 5;
            }
    	}
    }
    public void destroiParteDaEmbarcacao(int linha, int coluna) {
    	this.tabuleiroJogador[linha][coluna] = -1;
    }
    
    public String verificaDisparo(int linha, int coluna, Jogador adversario) {
    	if(this.tabuleiroJogador[linha][coluna]== 1) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiro().destroiParteDaEmbarcacao(linha, coluna);
    		return "Afundou o meu Navio-de-1-cano na posição "+ linha + "-" + coluna;
    	}
    	else if(this.tabuleiroJogador[linha][coluna] == 2) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiro().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Navio-De-2-Canos na posição "+ linha + "-" + coluna;
    	}
    	else if(this.tabuleiroJogador[linha][coluna]== 3) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiro().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Navio-De-3-Canos na posição "+ linha + "-" + coluna;
    	}
    	else if(this.tabuleiroJogador[linha][coluna]== 4) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiro().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Navio-De-4-Canos na posição "+ linha + "-" + coluna;
    	}
    	else if(this.tabuleiroJogador[linha][coluna]== 5) {
    		adversario.setVida(adversario.getVida()-1);
    		adversario.getTabuleiro().destroiParteDaEmbarcacao(linha, coluna);
    		return "Acertou o Porta-Aviões na posicao "+ linha + "-" + coluna;
    	}
    	else if(this.tabuleiroJogador[linha][coluna]== -1) {
    		return "Acertou água na posição "+ linha + "-" + coluna;
    	}
    	else {
    		return null;
    	}
    }


    public int[][] getTabuleiroJogador() {
        return this.tabuleiroJogador;
    }

}