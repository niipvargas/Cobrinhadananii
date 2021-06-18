package View;

import Controller.TelaJogoController;

public class TelaJogo extends TelaBase {
    
    public GamePanel gamePanel;
    private TelaJogoController controle;
    
    
     public TelaJogo() {
        super("Jogo da Cobrinha - by Iani Linda");
        gamePanel = new GamePanel();
        gamePanel.setBounds(0,0,640,480);
        add(gamePanel);
        controle = new TelaJogoController(this);
        addKeyListener(controle);
        controle.inicializar();
        
        
        
    
     }   
}
