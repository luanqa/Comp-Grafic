package computacaografica;

import java.util.ArrayList;
        
public class Transformacoes {
    
    public ArrayList<ArrayList<Integer>> translacao(int x, int y, ArrayList<ArrayList<Integer>> poligono) {
        
        ArrayList<ArrayList<Integer>> saida = new ArrayList();
        
        for (int i = 0; i < poligono.size(); i++) {
            ArrayList<Integer> ponto = new ArrayList();
            
            ponto.add(poligono.get(i).get(0)+x);
            ponto.add(poligono.get(i).get(1)+y);
            
            saida.add(ponto);
        }
        
        return saida;
    }
    
    public ArrayList<ArrayList<Integer>> escala(int x, int y, ArrayList<ArrayList<Integer>> poligono) {
        
        ArrayList<ArrayList<Integer>> saida = new ArrayList();
        
        for (int i = 0; i < poligono.size(); i++) {
            ArrayList<Integer> ponto = new ArrayList();
            
            ponto.add(poligono.get(i).get(0)*x);
            ponto.add(poligono.get(i).get(1)*y);
            
            saida.add(ponto);
        }
        
        return saida;
    }
}
