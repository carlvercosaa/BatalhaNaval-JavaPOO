package tabuleiro;

public class Tabuleiro {
    private static int[][] tabuleiroJogador = new int[10][10];

    public static int[][] getTabuleiroJogador() {
        return tabuleiroJogador;
    }

    public static int[][] inicializaGrelha(){
            for(int linha=0 ; linha < 10 ; linha++ ){
                for(int coluna=0 ; coluna < 10 ; coluna++ ){
                    Tabuleiro.tabuleiroJogador[linha][coluna]=-1;
                }
            }
            return Tabuleiro.tabuleiroJogador;
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

    public void verificarEPlotarVerticalParaBaixo(int tamanho, int  linha, int  coluna){
        int contador = 0;
        for(int c = 0; c < tamanho; c++){                       //Verifica se pode colocar
            if(this.tabuleiroJogador[linha+c][coluna] == -1){
                contador += 1;
            }
        }
        if(contador == tamanho){
            for(int c = 0; c < tamanho; c++){                 //Coloca o navio no tabuleiro
                this.tabuleiroJogador[linha+c][coluna] = 0;
            }
        }
    }
    
    public void verificarEPlotarVerticalParaCima(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	for(int c = 0; c < tamanho; c++){                       //Verifica se pode colocar
            if(this.tabuleiroJogador[linha-c][coluna] == -1){
                contador += 1;
            }
        }
    	if(contador == tamanho){
            for(int c = 0; c < tamanho; c++){                 //Coloca o navio no tabuleiro
                this.tabuleiroJogador[linha-c][coluna] = 0;
            }
        }
    }
    
    public void verificarEPlotarHorizontalParaDireita(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	for(int c = 0; c < tamanho; c++){                       //Verifica se pode colocar
            if(this.tabuleiroJogador[linha][coluna+c] == -1){
                contador += 1;
            }
        }
    	if(contador == tamanho){
            for(int c = 0; c < tamanho; c++){                 //Coloca o navio no tabuleiro
                this.tabuleiroJogador[linha][coluna+c] = 0;
            }
        }
    }
 
    public void verificarEPlotarHorizontalParaEsquerda(int tamanho, int linha, int coluna) {
    	int contador = 0;
    	for(int c = 0; c < tamanho; c++){                       //Verifica se pode colocar
            if(this.tabuleiroJogador[linha][coluna-c] == -1){
                contador += 1;
            }
        }
    	if(contador == tamanho){
            for(int c = 0; c < tamanho; c++){                 //Coloca o navio no tabuleiro
                this.tabuleiroJogador[linha][coluna-c] = 0;
            }
        }
    }
}