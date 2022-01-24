/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacaografica;

import java.awt.Color;

/**

 */
public class PreenchimentoRecursivo {
    FrameBuffer frameBuffer; 
    
    public void preenchimentoRecursivo(int x, int y, Color novaCor, Color corBorda, FrameBuffer framebuffer){
        Color atual = framebuffer.getPixel(x, y);
        if(atual != corBorda && atual !=novaCor){
            framebuffer.setPixel(x, y, novaCor);
            preenchimentoRecursivo(x+1,y,novaCor,corBorda,framebuffer);
            preenchimentoRecursivo(x,y+1,novaCor,corBorda,framebuffer);
            preenchimentoRecursivo(x-1,y,novaCor,corBorda,framebuffer);
            preenchimentoRecursivo(x,y-1,novaCor,corBorda,framebuffer);
        }
    }
}