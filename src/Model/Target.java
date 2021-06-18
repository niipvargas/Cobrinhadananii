package Model;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Target extends Node {

    private ImageIcon iani;

    public Target(int x, int y) {
        super(x, y);
        this.iani = new ImageIcon("src/Assets/vida.png");
    }

    @Override
    public void desenhar(Graphics g) {
        g.drawImage(iani.getImage(), getX(), getY(), TAMANHO, TAMANHO, null);
        g.setColor(Color.BLACK);
    }

}