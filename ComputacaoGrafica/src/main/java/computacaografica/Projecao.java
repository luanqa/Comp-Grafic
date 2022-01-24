/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacaografica;
import java.util.ArrayList;

public class Projecao {
    FrameBuffer framebuffer;
    PolilinhaAntigo polilinha;
    Bresenham bresenham;
    
    public int[][] geraCubo(int inicio, int tamanho){
        int [][]cubo = new int[][] { {inicio, inicio+tamanho, inicio+tamanho, inicio, inicio, inicio+tamanho, inicio+tamanho, inicio}, {inicio, inicio, inicio+tamanho, inicio+tamanho, inicio, inicio, inicio+tamanho, inicio+tamanho}, {-tamanho, -tamanho, -tamanho, -tamanho, -2*tamanho, -2*tamanho, -2*tamanho, -2*tamanho}, {1,1,1,1,1,1,1,1}};
        //System.out.println(matriz[0][1]);
        
        return cubo;
    }
    
    public void orto(int [][]cubo, FrameBuffer framebuffer){
        polilinha = new PolilinhaAntigo();
        //int matrizOrto[][] = new int[][] {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        
        //int [][]cubo = new int[][] {{1,3,0},{2,1,1}};
        //int [][]matrizOrto = new int[][] {{2,3},{4,6}};
        int matrizOrto[][] = new int[][] {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        int resultadoOrto[][] = new int[matrizOrto.length][cubo[0].length];
        
        for(int i=0; i<matrizOrto.length; i++){
            for(int j=0; j<cubo[0].length; j++) {
                for(int k=0; k<matrizOrto[0].length; k++) {
                    //for(int k=0; k<matrizOrto[0].length; k++){
                    resultadoOrto[i][j] += (matrizOrto[i][k] * cubo[k][j]);
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> listaDePontos1 = new ArrayList();
        ArrayList<ArrayList<Integer>> listaDePontos2 = new ArrayList();
        
        //primeiro quadrado
        for(int j=0; j<resultadoOrto[0].length/2; j++){
            //ponto.clear();
            ArrayList<Integer> ponto = new ArrayList();
            ponto.add(resultadoOrto[0][j]);
            ponto.add(resultadoOrto[1][j]);
            //System.out.println("RESULTADO "+resultadoOrto[0][j]);
            //System.out.println("PONTO "+ponto);
            listaDePontos1.add(ponto);
            //System.out.println("LISTA "+ponto);
        }
        
        //segundo quadrado
        for(int j=resultadoOrto[0].length/2; j<resultadoOrto[0].length; j++){
            //ponto.clear();
            ArrayList<Integer> ponto = new ArrayList();
            ponto.add(resultadoOrto[0][j]);
            ponto.add(resultadoOrto[1][j]);
            //System.out.println("RESULTADO "+resultadoOrto[0][j]);
            //System.out.println("PONTO "+ponto);
            listaDePontos2.add(ponto);
            //System.out.println("LISTA "+ponto);
        }
        
        polilinha.polilinhaantigo(listaDePontos1, true, framebuffer);
        polilinha.polilinhaantigo(listaDePontos2, true, framebuffer);
        //x1 y1 x2 y2
        System.out.println("LISTA "+listaDePontos1);
        System.out.println("LISTA "+listaDePontos2);
        bresenham = new Bresenham();
        bresenham.bresenham(listaDePontos1.get(0).get(0), listaDePontos1.get(0).get(1), listaDePontos2.get(0).get(0), listaDePontos2.get(0).get(1), framebuffer);

        bresenham = new Bresenham();
        bresenham.bresenham(listaDePontos1.get(1).get(0), listaDePontos1.get(1).get(1), listaDePontos2.get(1).get(0), listaDePontos2.get(1).get(1), framebuffer);

        bresenham = new Bresenham();
        bresenham.bresenham(listaDePontos1.get(2).get(0), listaDePontos1.get(2).get(1), listaDePontos2.get(2).get(0), listaDePontos2.get(2).get(1), framebuffer);

        bresenham = new Bresenham();
        bresenham.bresenham(listaDePontos1.get(3).get(0), listaDePontos1.get(3).get(1), listaDePontos2.get(2).get(0), listaDePontos2.get(3).get(1), framebuffer);

    }   

}
