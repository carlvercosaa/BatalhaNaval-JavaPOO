package tabuleiro;

import enity.jogador;

public class tabuleiro {
    jogador jogador;
    private static int[][] tabuleiroJogador = new int[10][10];
 
    
    public jogador getJogador() {
        return jogador;
    }

    public void setJogador(jogador jogador) {
        this.jogador = jogador;
    }

    public static int[][] getTabuleiroJogador() {
        return tabuleiroJogador;
    }

    public static void setTabuleiroJogador(int[][] tabuleiroJogador1) {
        tabuleiro.tabuleiroJogador = tabuleiroJogador1;
    }

    public static int[][] inicializaGrelha(){
            for(int linha=0 ; linha < 10 ; linha++ ){
                for(int coluna=0 ; coluna < 10 ; coluna++ ){
                    tabuleiro.tabuleiroJogador[linha][coluna]=-1;
                }
            }
            return tabuleiro.tabuleiroJogador;
        }
	
        
	 public static void mostraGrelhaDeAtaque(int[][] tabuleiro){
	        System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
	        System.out.println();
	        
	        for(int linha=0 ; linha < 10 ; linha++ ){
	            System.out.print((linha)+"");
	            for(int coluna=0 ; coluna < 10 ; coluna++ ){
	                if(tabuleiro[linha][coluna]==-1){
	                    System.out.print("\t"+"~");
	                }else if(tabuleiro[linha][coluna]==0){
	                    System.out.print("\t"+"*");
	                }else if(tabuleiro[linha][coluna]==1){
	                    System.out.print("\t"+"X");
	                }
	                
	            }
	            System.out.println();
	        }

    }

    public void verificarEPlotarVertical(int tamanho, int  linha, int  coluna){
        int contador = 0;
        for(int c = 0; c < tamanho; c++){
            if(this.tabuleiroJogador[linha][coluna+c] == -1){
                contador += 1;
            }
        }
        
        if(contador == tamanho){
            for(int c = 0; c < tamanho; c++){
                this.tabuleiroJogador[linha][coluna+c] = 0;
            }
        }
        
    }
}
