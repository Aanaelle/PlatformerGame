package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;



public class PanelGame extends JPanel 
{
    private MouseInputs mouseInputs;
    private Game        game;

    public PanelGame(Game game) 
    {
        this.game = game;
        // taille de la frame
        setPanelSize();

        // Inputs
        this.mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(this.mouseInputs);
        addMouseMotionListener(this.mouseInputs);


    }

    // gérer la taille de la frame par rapport à l'image
    private void setPanelSize() 
    {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);

        setPreferredSize(size);
        System.out.println("size : " + GAME_WIDTH + " : " +  GAME_HEIGHT);
    }

    public void updateGame() 
    {

    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        this.game.render(g);
    }

    public Game getGame()
    {
        return this.game;
    }

}
