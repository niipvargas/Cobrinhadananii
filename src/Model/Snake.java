package Model;

import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

    private ArrayList<Node> snake;
    
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public Snake(int x, int y, int largura, int altura) {
        this.snake = new ArrayList<>();
        SnakeBody cabeca = new SnakeBody(x, y);
        SnakeBody corpo = new SnakeBody(x, y);
        SnakeBody rabo = new SnakeBody(x, y);
        this.snake.add(cabeca);
        this.snake.add(corpo);
        this.snake.add(rabo);
    }

    public Snake(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void crescerSnake() {
        SnakeBody body = (SnakeBody) this.snake.get(this.snake.size() - 1);
        int x = body.getX();
        int y = body.getY();
        this.snake.add(new SnakeBody(x, y));
    }

    public void desenhar(Graphics g) {
        for (int i = 0; i < this.snake.size(); i++){
            this.snake.get(i).desenhar(g);
        }
    }

    public void atualizar(int direcao) {

        for (int i = this.snake.size() - 1; i > 0; i--) {
            this.snake.get(i).mover(this.snake.get(i - 1).getX(), this.snake.get(i - 1).getY());
        }

        switch (direcao) {
            case UP:
                this.snake.get(0).setY(this.snake.get(0).getY() - Node.TAMANHO);
                break;
            case DOWN:
                this.snake.get(0).setY(this.snake.get(0).getY() + Node.TAMANHO);
                break;
            case LEFT:
                this.snake.get(0).setX(this.snake.get(0).getX() - Node.TAMANHO);
                break;
            case RIGHT:
                this.snake.get(0).setX(this.snake.get(0).getX() + Node.TAMANHO);
                break;
        }
    }

    public ArrayList<Node> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Node> snake) {
        this.snake = snake;
    }

}