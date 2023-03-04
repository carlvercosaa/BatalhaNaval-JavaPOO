package enity;

import java.util.Scanner;

import tabuleiro.Tabuleiro;

public class Embarcacao {
    private Jogador jogador;
    private String nomeDaEmbarcacao;
    private int tamanho;
    

    public Embarcacao(Jogador jogador, String nomeDaEmbarcacao, int tamanho) {
        this.jogador = jogador;
        this.tamanho = tamanho;
        this.nomeDaEmbarcacao = nomeDaEmbarcacao;
    }
    
    
    public void escolherPosicaoDaEmbarcacao(Tabuleiro tabuleiro){
        Scanner scanner = new Scanner(System.in);
        
        int linha;
        int coluna;
        String direcao;
        
        if(nomeDaEmbarcacao.equals("Navio_De_1_Cano")){
        	jogador.getTabuleiro().mostraGrelhaDeDefesa();
            
        	System.out.println("Jogador: " + jogador.getNumero());
        	
        	System.out.print("digite a coluna: ");
            coluna = scanner.nextInt();
            
            System.out.print("digite a linha: ");
            linha = scanner.nextInt();
            
            jogador.getTabuleiro().verificarEPlotarHorizontalParaDireita(this.tamanho, linha, coluna);
            
            jogador.getTabuleiro().mostraGrelhaDeDefesa();
            
        }else{
            System.out.println("Escolha o eixo(vertical ou horizontal)" );
            String eixo = scanner.next().toUpperCase();
            
            if(eixo.equals("VERTICAL")){
            	jogador.getTabuleiro().mostraGrelhaDeDefesa(); 
                System.out.print("digite a coluna: ");
                coluna = scanner.nextInt();
                
                System.out.print("digite a linha: ");
                linha = scanner.nextInt();
                
                System.out.println("Escolha a direcao(BAIXO ou CIMA)" );
                direcao = scanner.next().toUpperCase();
                
                if(direcao.equals("BAIXO")) {        
                	jogador.getTabuleiro().verificarEPlotarVerticalParaBaixo(this.tamanho, linha, coluna);
                	jogador.getTabuleiro().mostraGrelhaDeDefesa();

                }
                
                else if(direcao.equals("CIMA")) {    
                	jogador.getTabuleiro().verificarEPlotarVerticalParaCima(this.tamanho, linha, coluna);
                	jogador.getTabuleiro().mostraGrelhaDeDefesa();
                }
            }
            else if(eixo.equals("HORIZONTAL")){
            	jogador.getTabuleiro().mostraGrelhaDeDefesa(); 
                System.out.print("digite a coluna: ");
                coluna = scanner.nextInt();
                
                System.out.print("digite a linha: ");
                linha = scanner.nextInt();
                
                System.out.println("Escolha a direcao(DIREITA ou ESQUERDA)" );
                direcao = scanner.next().toUpperCase();
                
                if(direcao.equals("DIREITA")) {        
                	jogador.getTabuleiro().verificarEPlotarHorizontalParaDireita(this.tamanho, linha, coluna);
                	jogador.getTabuleiro().mostraGrelhaDeDefesa();
                }
                else if(direcao.equals("ESQUERDA")){
                	jogador.getTabuleiro().verificarEPlotarHorizontalParaEsquerda(this.tamanho, linha, coluna);
                	jogador.getTabuleiro().mostraGrelhaDeDefesa();
                }
            }
            
        }
       }
    
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public String getNomeDaEmbarcacao() {
    	return this.nomeDaEmbarcacao;
    }


    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }



}

