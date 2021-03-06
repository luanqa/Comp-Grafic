

package computacaografica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

public class Monitor extends javax.swing.JFrame {

    private static FrameBuffer framebuffer;
    private static int sizex = 51;
    private static int sizey = 51;
    private static int sizep = 8;
    
    /**
     * Creates new form Monitor
     */
    public Monitor() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        //g.fillRect(100, 100, 10, 10);
        //g.drawRect(50, 10, 50, 50);
        
        for(int i=0; i<sizex; i++){
            for(int j=0; j<sizey; j++){
                g.setColor(framebuffer.getPixel(i, j));
                //Esse (49-j) inverte a coordenada Y. Agora o pixel zero começa em baixo.
                g.fillRect(i*(sizep+1) + 25, (49-j)*(sizep+1) + 100, sizep, sizep);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(567, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(496, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        framebuffer.setPixel(25, 25, Color.YELLOW);
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        framebuffer = new FrameBuffer(sizex,sizey);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                Scanner resposta = new Scanner(System.in);

                System.out.println("Escolha a opção:");
                System.out.println("1  - Linhas");
                System.out.println("2  - Poligonos");
                System.out.println("3  - Translação");
                System.out.println("4  - Escala");
                System.out.println("5 - Preenchimento recursivo");
                System.out.println("6 - Projeção Ortogonal");
                
                int escolha = resposta.nextInt();
                
                switch (escolha) {
                    case 1:
                        CohenSutherland cohensutherland = new CohenSutherland();
                        ArrayList<Integer> pontosBresenham = new ArrayList();
                        
                        for (int i = 0; i < 4; i++) {
                            switch (i) {
                                case 0: System.out.println("-> X1:"); break;
                                case 1: System.out.println("-> Y1:"); break;
                                case 2: System.out.println("-> X2:"); break;
                                case 3: System.out.println("-> Y2:"); break;                                  
                            }
                                    
                            int ponto = resposta.nextInt();
                            pontosBresenham.add(ponto);
                        }
                        
                        cohensutherland.cohensutherland(pontosBresenham.get(0), pontosBresenham.get(1), pontosBresenham.get(2), pontosBresenham.get(3), 0, 0, 50, 50, framebuffer);
                        break;


                    case 2:
                        Polilinha polPoligonos = new Polilinha();
                        Poligonos poligonos = new Poligonos();

                        System.out.println("-> Escolha o poligono:");
                        System.out.println("1  - Quadrado");
                        System.out.println("2  - Losango");
                        System.out.println("3  - Retangulo");
                        System.out.println("4  - Triangulo");

                        int poligono = resposta.nextInt();

                        switch (poligono) {
                            case 1:
                                ArrayList<Integer> dadosQuadrado = new ArrayList();

                                System.out.println("-> Lado:"); dadosQuadrado.add(resposta.nextInt());
                                System.out.println("-> Base X:"); dadosQuadrado.add(resposta.nextInt());
                                System.out.println("-> Base Y:"); dadosQuadrado.add(resposta.nextInt());

                                polPoligonos.polilinha(poligonos.quadrado(dadosQuadrado.get(0), dadosQuadrado.get(1), dadosQuadrado.get(2)), framebuffer);
                                break;
                        }
                        break;



                    case 3:
                        Polilinha polTransQN = new Polilinha();
                        Polilinha polTransQT = new Polilinha();
                        Poligonos poligonosTrans = new Poligonos();
                        Transformacoes translacao = new Transformacoes();

                        System.out.println("-> Escolha o poligono:");
                        System.out.println("1  - Quadrado");
                        System.out.println("2  - Losango");
                        System.out.println("3  - Retangulo");
                        System.out.println("4  - Triangulo");

                        int poligonoTrans = resposta.nextInt();

                        switch (poligonoTrans) {
                            case 1:
                                ArrayList<Integer> dQTrans = new ArrayList();

                                System.out.println("-> Lado:"); dQTrans.add(resposta.nextInt());
                                System.out.println("-> Base X:"); dQTrans.add(resposta.nextInt());
                                System.out.println("-> Base Y:"); dQTrans.add(resposta.nextInt());

                                System.out.println("-> Deslocamento X:");
                                int desX = resposta.nextInt();

                                System.out.println("-> Deslocamento X:");
                                int desY = resposta.nextInt();

                                ArrayList<ArrayList<Integer>> quadrado = poligonosTrans.quadrado(dQTrans.get(0), dQTrans.get(1), dQTrans.get(2));
                                ArrayList<ArrayList<Integer>> qTrans = translacao.translacao(desX, desY, quadrado);
                                polTransQN.polilinha(quadrado, framebuffer);
                                polTransQT.polilinha(qTrans, framebuffer);
                                break;
                        }
                        break;

                    case 4:
                        Polilinha polEscQN = new Polilinha();
                        Polilinha polEscQT = new Polilinha();
                        Poligonos poligonosEsc = new Poligonos();
                        Transformacoes escala = new Transformacoes();

                        System.out.println("-> Escolha o poligono:");
                        System.out.println("1  - Quadrado");
                        System.out.println("2  - Losango");
                        System.out.println("3  - Retangulo");
                        System.out.println("4  - Triangulo");

                        int poligonoEsc = resposta.nextInt();

                        switch (poligonoEsc) {
                            case 1:
                                ArrayList<Integer> dQEsc = new ArrayList();

                                System.out.println("-> Lado:"); dQEsc.add(resposta.nextInt());
                                System.out.println("-> Base X:"); dQEsc.add(resposta.nextInt());
                                System.out.println("-> Base Y:"); dQEsc.add(resposta.nextInt());

                                System.out.println("-> Fator de Escala X:");
                                int escX = resposta.nextInt();

                                System.out.println("-> Fator de Escala Y:");
                                int escY = resposta.nextInt();

                                ArrayList<ArrayList<Integer>> quadrado = poligonosEsc.quadrado(dQEsc.get(0), dQEsc.get(1), dQEsc.get(2));
                                ArrayList<ArrayList<Integer>> qEsc = escala.escala(escX, escY, quadrado);
                                polEscQN.polilinha(quadrado, framebuffer);
                                polEscQT.polilinha(qEsc, framebuffer);
                                break;
                        }
                        break;

                    case 5:
                        Poligonos polPreenchimento = new Poligonos();
                        Polilinha poliPreenchimento = new Polilinha();

                        ArrayList<ArrayList<Integer>> pontosTriangulo = polPreenchimento.trianguloEquilatero(30, 3, 3);
                        poliPreenchimento.polilinha(pontosTriangulo, framebuffer);

                        PreenchimentoRecursivo preenchimentoRecursivo = new PreenchimentoRecursivo();
                        preenchimentoRecursivo.preenchimentoRecursivo(6,5, Color.RED, Color.BLACK, framebuffer);
                        break;
                        
                    case 6:
                        Projecao projecao = new Projecao();
                        int [][]cubo = projecao.geraCubo(5,11);
                        projecao.orto(cubo, framebuffer);
                        break;
                }
                
                new Monitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
