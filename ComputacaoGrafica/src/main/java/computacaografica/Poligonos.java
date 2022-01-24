package computacaografica;

import java.util.ArrayList;

public class Poligonos {
    
    /** Ponto:
     * 
     * @param x: coordenada X
     * @param y: coordadena Y
     * @return : lista que representa o ponto
     */
    
    public ArrayList<Integer> ponto(int x, int y) {
        ArrayList<Integer> saida = new ArrayList();
        saida.add(x); saida.add(y);
        return saida;        
    }
    
    /** Quadrado:
     * 
     * @param lado: recebe a medida do lado.
     * @param qx: recebe a coordenada x do vértice no canto inferior esquerdo
     * @param qy: recebe a coordenada y do vértive no canto inferior esquerdo
     * @param framebuffer: desenha o quadrado
     * @return : retorna uma lista de vértices
     */
    
    public ArrayList<ArrayList<Integer>> quadrado(int lado, int qx, int qy) {
        
        // Monta a lista de vértices do quadrado
        ArrayList<Integer> v1 = ponto(qx, qy);
        ArrayList<Integer> v2 = ponto(qx, qy+lado);
        ArrayList<Integer> v3 = ponto(qx+lado, qy+lado);
        ArrayList<Integer> v4 = ponto(qx+lado, qy);
        
        // Agrupa todos os vértices na mesma lista        
        ArrayList<ArrayList<Integer>> vertices = new ArrayList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v1);
        
        return vertices;
    }
    
    /** Losango:
     * 
     * @param lado: recebe a medida do lado
     * @param lx: recebe a coordenada x do vértice no canto inferior
     * @param ly: recebe a coordenada y do vértive no canto inferior
     * @param framebuffer: desenha o losango
     * @return : retorna uma lista de vértices
     */
    
    public ArrayList<ArrayList<Integer>> losango(int lado, int lx, int ly) {
        
        // Monta a lista de vértices do losango
        ArrayList<Integer> v1 = ponto(lx, ly);
        ArrayList<Integer> v2 = ponto(lx-lado, ly+lado);
        ArrayList<Integer> v3 = ponto(lx, ly+2*lado);
        ArrayList<Integer> v4 = ponto(lx+lado, ly+lado);
                
        // Agrupa todos os vértices na mesma lista
        ArrayList<ArrayList<Integer>> vertices = new ArrayList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v1);
        
        return vertices;
    }
    
    /** Retângulo:
     * 
     * @param base: recebe a medida da base
     * @param altura: recebe a medida da altura
     * @param rx: recebe a coordenada x do vértice no canto inferior esquerdo
     * @param ry: recebe a coordenada y do vértice no canto inferior esquerdo
     * @param framebuffer: desenha o retângulo
     * @return : retorna uma lista de vértices
     */
    
    public ArrayList<ArrayList<Integer>> retangulo(int base, int altura, int rx, int ry) {
        
        // Monta a lista de vértices do retângulo
        ArrayList<Integer> v1 = ponto(rx, ry);
        ArrayList<Integer> v2 = ponto(rx, ry+altura);
        ArrayList<Integer> v3 = ponto(rx+base, ry+altura);
        ArrayList<Integer> v4 = ponto(rx+base, ry);
        
        // Agrupa todos os vértices na mesma lista
        ArrayList<ArrayList<Integer>> vertices = new ArrayList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v1);
        
        return vertices;
    }
    
    /** Triângulo equilátero:
     * 
     * @param lado: recebe a medida do lado
     * @param tex: recebe a coordenada x do vértice no canto inferior esquerdo
     * @param tey: recebe a coordenada y do vértice no canto inferior esquerdo
     * @param framebuffer: desenha o triângulo equilátero
     * @return : retorna uma lista de vértices
     */
    
    public ArrayList<ArrayList<Integer>> trianguloEquilatero(int lado, int tex, int tey) {
        
        // Calcula o ponto médio do lado e a altura, respectivamente
        int medio = (int)((tex+lado)/2);
        int altura = (int)(((tey+lado)*1.732)/2);
        
        // Monta a lista de vértices do triângulo equilátero
        ArrayList<Integer> v1 = ponto(tex, tey);
        ArrayList<Integer> v2 = ponto(tex+lado, tey);
        ArrayList<Integer> v3 = ponto(medio, altura);
        
        // Agrupa todos os vértices na mesma lista
        ArrayList<ArrayList<Integer>> vertices = new ArrayList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v1);
        
        return vertices;
    }
    
    /** Triângulo retângulo:
     * 
     * @param base: recebe a medida da base
     * @param altura: recebe a medida da altura
     * @param tRx: recebe a coordenada x do vértice no canto inferior esquerdo
     * @param tRy: recebe a coordenada y do vértice no canto inferior esquerdo
     * @param framebuffer: desenha o triângulo retângulo
     * @return : retorna uma lista de vértices
     */
    
    public ArrayList<ArrayList<Integer>> trianguloRetangulo(int base, int altura, int tRx, int tRy) {
        
        // Monta a lista de vértices do triângulo equilátero
        ArrayList<Integer> v1 = ponto(tRx, tRy);
        ArrayList<Integer> v2 = ponto(tRx, tRy+altura);
        ArrayList<Integer> v3 = ponto(tRx+base, tRy);
        
        // Agrupa todos os vértices na mesma lista
        ArrayList<ArrayList<Integer>> vertices = new ArrayList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v1);
        
        return vertices;
    }
}
