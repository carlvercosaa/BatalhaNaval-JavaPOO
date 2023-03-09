package tabuleiro;

public class TabuleiroDeAtaque extends Tabuleiro {
	
	public void mostraGrelhaDeAtaque(){
	 	System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
	 	System.out.println();
	 	for(int i=0 ; i < 10 ; i++ ){
            System.out.print((i)+"");
            for(int j=0 ; j < 10 ; j++ ){
                if(super.getTabuleiroJogador()[i][j]== 3){
                    System.out.print("\t"+"A");
                }else if(super.getTabuleiroJogador()[i][j]== 1) {
                    System.out.print("\t"+"N");
                }else if(super.getTabuleiroJogador()[i][j]== 2) {
                	System.out.print("\t"+"P");
                }
                
            }
            System.out.println();
        }
	}
}