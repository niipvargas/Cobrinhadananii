package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class TelaBase extends JFrame{
    
    public TelaBase(String title){
        setTitle(title);
        setSize(658, 521);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon("src/Assets/icon.png").getImage());
        setVisible(true);
        
    }
    
}
