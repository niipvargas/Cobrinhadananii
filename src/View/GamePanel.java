package View;

import Model.Snake;
import Model.Target;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

    public GamePanel() {
        this.snake = new Snake(20 * 5, 20 * 5, 20, 20);
        int x = (new Random().nextInt(19) + 1) * 20;
        int y = (new Random().nextInt(20) + 1) * 20;
        this.target = new Target(x, y);
        this.velocidade = 1000 / 300;
        this.timer = new Timer(velocidade, this);

    }

    private final Snake snake;
    private final Timer timer;
    private final int velocidade;
    private Target target;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(1, 1, 640, 480);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1, 1, 640, 480);
        getSnake().desenhar(g);
        target.desenhar(g);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    public synchronized Snake getSnake() {
        return snake;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}