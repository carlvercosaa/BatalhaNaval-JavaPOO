package tabuleiro;

import enity.Jogador;

public class TabuleiroDeAtaque extends Tabuleiro implements Grelhas {
	
	public void mostraGrelha(){
	 	System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
	 	System.out.println();
	 	for(int i=0 ; i < 10 ; i++ ){
            System.out.print((i)+"");
            for(int j = 0 ; j < 10 ; j++ ){
                if(super.getTabuleiroJogador()[i][j]== 1) {
                    System.out.print("\t"+".");
                }else if(super.getTabuleiroJogador()[i][j]== 2) {
                	System.out.print("\t"+"X");
                }else if(super.getTabuleiroJogador()[i][j]== -1) {
                	System.out.print("\t"+"~");
                }
            }
            System.out.println();
        }
	}
	
	public void setNovaPosicao(int linha, int coluna) {
		
		super.getTabuleiroJogador()[linha][coluna] = 2;
	}
	
	public void marcaNaGrelha(int linha, int coluna, Jogador adversario) {
		
		if(adversario.getTabuleiroDefesa().getTabuleiroJogador()[linha][coluna] == 1 || adversario.getTabuleiroDefesa().getTabuleiroJogador()[linha][coluna] == 2 || adversario.getTabuleiroDefesa().getTabuleiroJogador()[linha][coluna] == 3 || adversario.getTabuleiroDefesa().getTabuleiroJogador()[linha][coluna] == 4 || adversario.getTabuleiroDefesa().getTabuleiroJogador()[linha][coluna] == 5) {
			super.getTabuleiroJogador()[linha][coluna] = 2;
		}else {
			super.getTabuleiroJogador()[linha][coluna] = 1;
		}
	}
}