package Controller;

import Model.Node;
import Model.Snake;
import View.TelaJogo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaJogoController implements KeyListener, Runnable {

    private TelaJogo tela;
    private Thread loop;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean pausado;

    public TelaJogoController(TelaJogo tela) {
        
        this.tela = tela;
        up = false;
        down = false;
        left = false;
        right = true;
        pausado = true;
        loop = new Thread(this);
    }
    
    public void inicializar(){
        this.tela.gamePanel.getSnake().getSnake().get(0).mover(200, 200);
        pausado = false;
        this.tela.gamePanel.getTimer().start();
        loop.start();
    }
    
    private void AtualizarTela() {
            if (up) {
                this.tela.gamePanel.getSnake().atualizar(Snake.UP);
            }else if(down){
                this.tela.gamePanel.getSnake().atualizar(Snake.DOWN);
            }else if(up){
                this.tela.gamePanel.getSnake().atualizar(Snake.LEFT);
            }else if(right){
                this.tela.gamePanel.getSnake().atualizar(Snake.RIGHT);
            }else if(left){
                this.tela.gamePanel.getSnake().atualizar(Snake.LEFT);
            }
            
    }
    
    private void HoraDaPapinha (Node a, Node b) {
        if (a.getX() == b.getX() && a.getY() == b.getY()) {
            tela.gamePanel.getSnake().crescerSnake();
            tela.gamePanel.getTarget().mover((new Random().nextInt(19) + 1) * 20, (new Random().nextInt(20) + 1) * 20);
        }
    }
    private void BateuNaParedinha(Node a) {
        if (a.getX() == 0 || a.getX() == (20 * 31) || a.getY() == 0 || a.getY() == (20 * 23)) {
           pausado = true;
           loop.interrupt();
        }
    }
    
    public void CobrinhaComeuCobrinha (Snake a){
        ArrayList<Node> b = a.getSnake();
        for(int i = 1; i < a.getSnake().size()-1; i ++){
            if (b.get(0).getX()==b.get(i).getX()&& b.get(0).getY()==b.get(i).getY()){
                pausado = true;
                loop.interrupt();
                
            }
            
        }
    }
    public void reiniciar (){
        this.tela.gamePanel.getSnake().getSnake().get(0).mover(10*20,5*20);
        pausado = false;
        this.tela.gamePanel.getTimer().start();
        up = false;
        down = false;
        left = false;
        right = true;
        
    }
    
     @Override
    public void run() {
        while(pausado == false){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TelaJogoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.AtualizarTela();
                 HoraDaPapinha(this.tela.gamePanel.getSnake().getSnake().get(0), this.tela.gamePanel.getTarget());
                 BateuNaParedinha(this.tela.gamePanel.getSnake().getSnake().get(0));
                 CobrinhaComeuCobrinha(this.tela.gamePanel.getSnake());
        }
        
    }
    
  
    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_UP && !this.down){
            this.up =  true;
            this.left = false;
            this.right = false;
       } else if (e.getKeyCode() == KeyEvent.VK_DOWN && !this.up){
            this.down = true;
            this.left = false;
            this.right = false;
       } else if (e.getKeyCode() == KeyEvent.VK_LEFT && !this.right){
            this.left = true;
            this.up = false;
            this.down = false;
       } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && !this.left){
            this.right = true;
            this.up = false;
            this.down = false;
        }else if (e.getKeyCode() == KeyEvent.VK_C && this.pausado == true){
            this.reiniciar();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) {
         
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        
    }

}
