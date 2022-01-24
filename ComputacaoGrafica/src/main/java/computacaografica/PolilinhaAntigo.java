package computacaografica;

import java.util.ArrayList;

public class PolilinhaAntigo {
    
    public static CohenSutherland cohensutherland = new CohenSutherland();

    public void polilinhaantigo(ArrayList<ArrayList<Integer>> vertices, boolean poligono, FrameBuffer framebuffer) {
        
        int vx1, vy1, vx2, vy2;
        
        for ( int i = 0; i < vertices.size(); i++ ) {
            // Armazena o primeiro ponto da lista como o início da reta
            vx1 = vertices.get(i).get(0);
            vy1 = vertices.get(i).get(1);
            
            // Procura o segundo ponto da lista para completar a reta
            if ( i < (vertices.size() - 1) ) {
                // Verifica se a lista chegou ao último ponto
                // Em caso negativo, armazena o próximo ponto
                vx2 = vertices.get(i+1).get(0);
                vy2 = vertices.get(i+1).get(1);
            }
            else {
                // A lista chegou ao último vértice
                if (poligono == true) {
                    // Verifica se a figura é um polígono
                    // Em caso positivo, rearmazena o primeiro ponto
                    vx2 = vertices.get(0).get(0);
                    vy2 = vertices.get(0).get(1);
                }
                else {
                    // Em caso negativo, encerra a repetição
                    break;
                }
            }
            
            cohensutherland.cohensutherland(vx1, vy1, vx2, vy2, 0, 0, 50, 50, framebuffer);
        }
    }
}