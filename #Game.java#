import game.Player;
import game.Tree;
import game.Stopper;
import game.World;
import game.Coin;
import game.Enemy;
import game.core.GameObject;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
public class Game {
        
    public static CopyOnWriteArrayList<GameObject> gameObjects = new CopyOnWriteArrayList<GameObject>();
    //    public static ArrayList<GameObject> gameObjectsNR = new ArrayList<GameObject>();
    public static CopyOnWriteArrayList<GameObject> coins = new CopyOnWriteArrayList<GameObject>();
    public static CopyOnWriteArrayList<GameObject> enemies = new CopyOnWriteArrayList<GameObject>();

    
    public static void main(String[] args) {
     
        Player player = new Player(
				   467,
				   450,
				   67,
				   100
				   );
	
	 Enemy enemy = new Enemy(
				   300,
				   170,
				   67,
				   100,
				   gameObjects,
				   player
				   );
	
        for (int i = 0; i < 100; i+=3) {
            Tree tree = new Tree(
				 i*60,
				 i*60,
				 60,
				 60
				 );
            gameObjects.add(tree);
        }

	for (int i = 0; i < 100; i+=10) {
            Coin coin = new Coin(
				 i*25,
				 i*10,
				 30,
				 30
				 );
            coins.add(coin);
        }
        enemies.add(enemy);
	//	gameObjectsNR.add(player);

        JFrame window = new JFrame("Game");
        World world = new World(gameObjects, /*gameObjectsNR,*/ coins, enemies,  player);
	
        window.setContentPane(world);
        
	window.setSize(1000, 1000);
        window.setVisible(true);
        window.addKeyListener(
			      new KeyListener() {
				  public void keyPressed(KeyEvent e) {
				      int key = e.getKeyCode();
				      if (key == 69) // E
					  {
					      for (GameObject obj : coins)
						  if (Stopper.fullCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), obj.getWidth(),  player.getWidth(),player.getHeight(), obj.getHeight())==1)
						      {
							  coins.remove(obj);
							  player.incCoins(1);
							  player.setATT(0);
							  
						      }
					  }
				      
				      if (key == 65) // A
					  {
					      player.setATT(0);
					      int c = Math.min
						  (Stopper.rLeftCheck(gameObjects, player),
						   Stopper.rLeftCheck(enemies, player));
					      
					      if (c != 0)
						  {
						      for (GameObject obj : gameObjects)
							  obj.setPosx(c);
						      player.move(2);
						      for (GameObject obj : coins)
							  obj.setPosx(c);
						      for (GameObject obj : enemies)
							  obj.setPosx(c);
						  }
					      for (GameObject obj : coins)
						  if (Stopper.fullCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), obj.getWidth(),  player.getWidth(),player.getHeight(), obj.getHeight())==1) player.setATT(1); 
					  }
				      else if (key == 68) // D
					  {
					      player.setATT(0);
					      int c = Math.min
						  (Stopper.rRightCheck(gameObjects, player),
						   Stopper.rRightCheck(enemies, player));
					      
					      if (c != 0)
						  {
						      player.move(3);
						      for (GameObject obj : gameObjects)
							  obj.setPosx(-c);
						      for (GameObject obj : coins)
							  obj.setPosx(-c);
						      for (GameObject obj : enemies)
							  obj.setPosx(-c);
						  }
					      for (GameObject obj : coins)
						  if (Stopper.fullCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), obj.getWidth(),  player.getWidth(),player.getHeight(), obj.getHeight())==1) player.setATT(1);
					  }
				      else if (key == 87) { // W
					  player.setATT(0);

					  int c = Math.min
					      (Stopper.rTopCheck(gameObjects, player),
					       Stopper.rTopCheck(enemies, player));
					  
					  if (c != 0)
					      {
						  player.move(1);
						  for (GameObject obj : gameObjects)
						      obj.setPosy(c);
						  for (GameObject obj : coins)
						      obj.setPosy(c);
						  for (GameObject obj : enemies)
						      obj.setPosy(c);
					      }
					  for (GameObject obj : coins)
					      if (Stopper.fullCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), obj.getWidth(),  player.getWidth(),player.getHeight(), obj.getHeight())==1) player.setATT(1);
				      }
		    
				      else if (key == 83) // S
					  {
					      player.setATT(0);

					      	  int c = Math.min
					      (Stopper.rBotCheck(gameObjects, player),
					       Stopper.rBotCheck(enemies, player));
					  
				
					      if (c != 0)
						  {
						      for (GameObject obj : gameObjects)
							  obj.setPosy(-c);
						      for (GameObject obj : coins)
							  obj.setPosy(-c);
						      for (GameObject obj : enemies)
							  obj.setPosy(-c);
						      player.move(0);
						  }
					      for (GameObject obj : coins)
						  if (Stopper.fullCheck(player.getPosx(),player.getPosy(), obj.getPosx(), obj.getPosy(), obj.getWidth(),  player.getWidth(),player.getHeight(), obj.getHeight())==1) player.setATT(1); 
					  }
				      window.repaint();
				      try {Thread.sleep(5);}
				      catch(Exception exc){}
		   
				  }

				  public void keyReleased(KeyEvent e) {
				      int key = e.getKeyCode();
				      if (key == 65) {
					  player.setmoveCount(4);
					  player.setAnimNumber(0);
				      } else if (key == 68) {
					  player.setmoveCount(4);
					  player.setAnimNumber(1);
				      } else if (key == 87) {
					  player.setmoveCount(4);
					  player.setAnimNumber(0);
				      } else if (key == 83) {
					  player.setmoveCount(4);
					  player.setAnimNumber(0);
				      }
				      window.repaint();
				  }

				  public void keyTyped(KeyEvent e) {
				  }
			      }
			      );
	while (true)
	    {
		window.repaint();
		try
		    {
			Thread.sleep(50);
		    }
		catch (InterruptedException e)
		    {
			System.out.println("InterruptedException in class Enemy");
		    }
	    }
    }
}
