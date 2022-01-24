package computacaografica;

import java.awt.Color;
import java.util.ArrayList;

public class Bresenham {
    
    // Armazenam globalmente as coordenados dos pontos
    int x, y, x1, y1, x2, y2;
    
    // Armazenam globalmente as operações de troca
    boolean trocaX, trocaY, trocaXY;

  
    
    public void reflexao(int rx1, int ry1, int rx2, int ry2) {
        
        x1 = rx1;
        y1 = ry1;
        x2 = rx2;
        y2 = ry2;
        
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        double m = deltaY / deltaX;
        
        // Verifica se M está fora do intervalo [-1 ; +1]
        // Inverte as coordenadas de P1 e P2 em caso positivo
        if (m > 1 || m < -1) {
            int aux = x1;
            x1 = y1;
            y1 = aux;
            
            aux = x2;
            x2 = y2;
            y2 = aux;
            
            trocaXY = true;
        }
        
        // Verifica se o X inicial é maior que o X final
        if (x1 > x2) {
            x1 = -x1;
            x2 = -x2;
            trocaX = true;
        }
        
        // Verifica se o Y inicial é maior que o Y final
        if (y1 > y2) {
            y1 = -y1;
            y2 = -y2;
            trocaY = true;            
        }
    }
    

    
    public ArrayList<Integer> reflexaoInversa(int rix, int riy) {
        
        ArrayList<Integer> ponto = new ArrayList();
        
        // Verifica se Y sofreu troca de octante e reverte
        if (trocaY == true) {
            riy = -riy;
        }
        
        // Verifica se X sofreu troca de octante e reverte
        if (trocaX == true) {
            rix = -rix;
        }
        
        // Verifica se X e Y foram invertidos e desfaz a troca
        if (trocaXY == true) {
            int aux = rix;
            rix = riy;
            riy = aux;
        }
        
        ponto.add(rix);
        ponto.add(riy);
        
        return ponto;
    }
    

    public void bresenham(int bx1, int by1, int bx2, int by2, FrameBuffer framebuffer) {
        
        if ( bx1 == bx2 && by1 == by2) {
            // Verifica se os pontos P1 e P2 são iguais
            // Em caso positivo, imprime P1 no frame
            framebuffer.setPixel(bx1, by1, Color.BLACK);
        }
        else {
            // Reflete a reta para o primeiro octante        
            reflexao(bx1, by1, bx2, by2);
            
            x = x1;
            y = y1;
            
            double deltaX = x2 - x1;
            double deltaY = y2 - y1;
            double m = deltaY / deltaX;
            double e = m - 0.5;
            
            framebuffer.setPixel(bx1, by1, Color.BLACK);
            
            // Lista que receberá o ponto calculado depois da reflexão inversa
            ArrayList<Integer> ponto;
            
            while( x < x2 ) {
                
                if (e >= 0) {
                    y = y + 1;
                    e = e - 1;                
                }
                
                x = x + 1;
                e = e + m;
                
                ponto = reflexaoInversa(x, y);
                framebuffer.setPixel(ponto.get(0), ponto.get(1), Color.BLACK);
            }
        }
    }
}
