package tabuleiro;

public abstract class Tabuleiro {
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
    
    public void destroiParteDaEmbarcacao(int linha, int coluna) {
    	this.tabuleiroJogador[linha][coluna] = -1;
    }


	public int[][] getTabuleiroJogador() {
        return this.tabuleiroJogador;
    }

}