/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacaografica;

import java.awt.Color;


public class FrameBuffer {
    
    Color[][] frame_buffer;

    public FrameBuffer(int x, int y) {
        frame_buffer = new Color[x][y];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                frame_buffer[i][j] = Color.WHITE;
            }
        }
    }
    
    
    public void setPixel(int x, int y, Color cor){
        frame_buffer[x][y] = cor;
    }
    
    public Color getPixel(int x, int y){
        return frame_buffer[x][y];
    }
}
