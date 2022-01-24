package computacaografica;

import java.util.ArrayList;

public class CohenSutherland {
    
    public static Bresenham bresenham;
    
    // Armazena globalmente as extremidades da reta e da malha
    int xInicial, xFinal, yInicial, yFinal;
    int xMinimo, xMaximo, yMinimo, yMaximo;
    
    public ArrayList<Integer> pontoBinario(int x, int y) {
        
        ArrayList<Integer> saida = new ArrayList();
        
        if ((yMaximo - y) >= 0) {saida.add(0);} else {saida.add(1);}
        if ((y - yMinimo) >= 0) {saida.add(0);} else {saida.add(1);}
        if ((xMaximo - x) >= 0) {saida.add(0);} else {saida.add(1);}
        if ((x - xMinimo) >= 0) {saida.add(0);} else {saida.add(1);}
        
        return saida;
    }
    


    
    public ArrayList<Integer> primeiraDiferenca(ArrayList<Integer> pB1, ArrayList<Integer> pB2) {
        
        ArrayList<Integer> saida = new ArrayList();
        
        int primeiroBitP1 = 4;
        int primeiroBitP2 = 4;
        
        for (int i = 0; i < 4; i++) {            
            if ( pB1.get(i) == 1) {                
                primeiroBitP1 = i;
                break;
            }
        }
        
        for (int i = 0; i < 4; i++) {            
            if ( pB2.get(i) == 1) {                
                primeiroBitP2 = i;
                break;
            }
        }
        
        if ( primeiroBitP1 < primeiroBitP2) {
            saida.add(1);
            saida.add(primeiroBitP1);
        }
        else {
            saida.add(2);
            saida.add(primeiroBitP2);
        }
        
        return saida;
    }
    

    
    public void calculaPonto(ArrayList<Integer> listaDeControle) {
        
        int x = 0;
        int y = 0;
        
        double m = (double)(yFinal - yInicial) / (xFinal - xInicial);
                
        switch (listaDeControle.get(1)) {
            case 0:
                y = yMaximo;
                x = (int)(xInicial + (y - yInicial)/m);
                break;
            case 1:
                y = yMinimo;
                x = (int)(xInicial + (y - yInicial)/m);
                break;
            case 2:
                x = xMaximo;
                y = (int)(yInicial + m*(x - xInicial));
                break;
            case 3:
                x = xMinimo;
                y = (int)(yInicial + m*(x - xInicial));
                break;
        }
        
        switch (listaDeControle.get(0)) {
            case 1:
                xInicial = x;
                yInicial = y;
                break;
            case 2:
                xFinal = x;
                yFinal = y;
                break;
        }
    }

    
    public boolean totalmenteDentro(ArrayList<Integer> pB1, ArrayList<Integer> pB2) {
        
        boolean saida = true;
        
        for (int i = 0; i < 4; i++) {
            
            if (pB1.get(i) == 1 || pB2.get(i) == 1) {
                saida = false;
                break;
            }
        }
        
        return saida;
    }

    
    public boolean totalmenteFora(ArrayList<Integer> pB1, ArrayList<Integer> pB2) {
        
        boolean saida = false;
        
        for (int i = 0; i < 4; i++) {
            
            if (pB1.get(i) == 1 && pB2.get(i) == 1) {
                saida = true;
                break;
            }
        }
        
        return saida;
    }

    public void cohensutherland(int x1, int y1, int x2, int y2, int xMin, int yMin, int xMax, int yMax, FrameBuffer framebuffer) {
        
        xMinimo = xMin; xMaximo = xMax;
        yMinimo = yMin; yMaximo = yMax;
        
        xInicial = x1; xFinal = x2;
        yInicial = y1; yFinal = y2;
        
        // Armazena os binários dos pontos de entrada
        ArrayList<Integer> pB1 = pontoBinario(xInicial, yInicial);
        ArrayList<Integer> pB2 = pontoBinario(xFinal, yFinal);
        
        if ( totalmenteDentro(pB1, pB2) == true ) {
            // Verifica se a reta está totalmente dentro da malha
            bresenham = new Bresenham();
            bresenham.bresenham(xInicial, yInicial, xFinal, yFinal, framebuffer);
        }
        else {
            // Verifica se a reta está totalmente fora da malha
            if ( totalmenteFora(pB1, pB2) == true ) {
                bresenham = null;
            }
            else {
                calculaPonto(primeiraDiferenca(pB1, pB2));
                cohensutherland(xInicial, yInicial, xFinal, yFinal, xMinimo, yMinimo, xMaximo, yMaximo, framebuffer);
            }
        }
    }
}
