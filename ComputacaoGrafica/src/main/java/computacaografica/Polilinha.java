package computacaografica;

import java.util.ArrayList;

public class Polilinha {
    
    public static CohenSutherland cohensutherland;

    
    public void polilinha(ArrayList<ArrayList<Integer>> vertices, FrameBuffer framebuffer) {
        
        int vx1, vy1, vx2, vy2;
        
        for ( int i = 0; i < (vertices.size() - 1) ; i++ ) {
            // Armazena o primeiro ponto da lista como o início da reta
            vx1 = vertices.get(i).get(0);
            vy1 = vertices.get(i).get(1);
            vx2 = vertices.get(i+1).get(0);
            vy2 = vertices.get(i+1).get(1);
            
            cohensutherland = new CohenSutherland();
            cohensutherland.cohensutherland(vx1, vy1, vx2, vy2, 0, 0, 50, 50, framebuffer);
        }
    }
}
