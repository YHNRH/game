package game;

import game.core.GameObject;
import game.images.ImageCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class World extends JPanel {
    private CopyOnWriteArrayList<GameObject> gameObjects;
    //    private ArrayList<GameObject> gameObjectsNR;
    private CopyOnWriteArrayList<GameObject> coins;
    private CopyOnWriteArrayList<GameObject> enemies;
    private static Player player;
    public World(CopyOnWriteArrayList<GameObject> gameObjects,/* ArrayList<GameObject> gameObjectsNR, */ CopyOnWriteArrayList<GameObject> coins, CopyOnWriteArrayList<GameObject> enemies, Player player) {
        this.gameObjects = gameObjects;
	//	this.gameObjectsNR = gameObjectsNR;
	this.player = player;
	this.coins = coins;
	this.enemies = enemies;
    }

  
    private void drawBack(Graphics g)
    {
	super.paintComponent(g);
	BufferedImage img = ImageCollection.backGround;
        for (int i = 0; i<1000; i=i+32)
	    {
		for (int j = 0; j<1000; j = j + 32)
		g.drawImage(img, i, j, 32, 32, null);
	    }
    }

    protected void paintComponent(Graphics g)
    {

	super.paintComponent(g);
        drawBack(g);
	for (GameObject obj : gameObjects)
	    {
		BufferedImage img = obj.getImage_();
		g.drawImage(img, obj.getPosx(), obj.getPosy(), obj.getWidth(), obj.getHeight(), null);
	    }
	for (GameObject obj : coins)
	    {
		BufferedImage img = obj.getImage_();
		g.drawImage(img, obj.getPosx(), obj.getPosy(), obj.getWidth(), obj.getHeight(), null);
	    }
	for (GameObject obj : enemies)
	    {
		BufferedImage img = obj.getImage_();
		g.drawImage(img, obj.getPosx(), obj.getPosy(), obj.getWidth(), obj.getHeight(), null);
	    }
	BufferedImage imgP = player.getImage_();
	g.drawImage(imgP, player.getPosx(), player.getPosy(), player.getWidth(), player.getHeight(), null);
	Interface.drawInterface(g);
    }



public static class Interface extends JPanel
{
    public static void drawInterface(Graphics g)
    {
	//	g.drawOval(0,0,100,100);
	Color gray = new Color(192, 192, 192, 150);
	Color black = new Color(0, 0, 0);
	    g.setColor(gray);
	g.fillRect(0,0,100,100);
	g.setColor(black);
	g.drawRect(0,0,100,100);
	g.drawString("HP "+ player.getHP(), 5 ,20);
	g.drawString("Energy "+ player.getEnergy(), 5,40);
	g.drawString("Coins "+ player.getCoins(), 5,60);
	if (player.getATT()==1)
	    {
		g.drawString("Press E", 475 ,440);
	    }
	
    }
    
}

}
