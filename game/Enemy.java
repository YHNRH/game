package game;
import game.core.GameObject;
import game.images.ImageCollection;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

public class Enemy extends GameObject 
{
    private int animNumber = 0;
    private int direction = 0;
    private int moveCount = 0;
    private int hp = 100;
    private int state = 0; //0 -- walk, 1 -- attack
    private CopyOnWriteArrayList<GameObject> gameObjects;
    private Player player;
    //    private int b = 99;
    private int direct = (int) (Math.random()*4) ;
    private int steps  = (int) (Math.random()+40*2);
    public int getHP()
    {
	return this.hp;
    }
    public Enemy(int posX, int posY, int width, int height, CopyOnWriteArrayList<GameObject> gameObjects, Player pl)
    {
        super(posX, posY, height, width);
	this.gameObjects = gameObjects;
	player = pl;
	live();
    }

    protected void live()
    {
	Thread tr = new Thread(
		  ()->
		  {
		      while (true)
			  {
			      checking();
			      moveing();
			      try
				  {
				      Thread.sleep(50);
				  }
			      catch (InterruptedException e)
				  {
				      System.out.println("InterruptedException in class Enemy");
				  }
			  }
		  });
	tr.start();
    }

        public void move(int deltax, int deltay)
    {
        super.move(deltax, deltay);
	   if (Math.abs(deltax) > Math.abs(deltay)) {
            if (deltax >= 0) {
                direction = 3;
            } else {
                direction = 2;
            }
        } else {
            if (deltay >= 0) {
                direction = 0;
            } else {
                direction = 1;
            }
        }

	moveCount++;
	if (moveCount >= 4)
	    {
		moveCount =0;
		animNumber++;
	    }
            if (animNumber == 4) {
		animNumber = 0;
	    }
    }
    
    public void moveing()
    {
	  /*
				int a = (int) (Math.random()*4);
				switch (a)
				{
				case (0):break;
				move(5,0);
				break;
				case (1):
				      move(-5,0);
				      break;
				  case (2):
				      move(0,5);
				      break;
				  case (3):
				      move(0,-5);
				      break;
				  }
			      */
			      
			      /*
			      if (b >=75 && Stopper.rBotCheck(gameObjects, this)!=0)
				  {
				      move(0,5);
				      b--;
				      System.out.println(b);
				  }
			      else if (b >=50 && Stopper.rRightCheck(gameObjects, this)!=0)
				  {
				      move(5,0);
				      b--;
				  }
			      
			      else if (b >=25 && Stopper.rTopCheck(gameObjects, this)!=0)
				  {
				      move(0,-5);
				      b--;
				  }
			      
			      else if (b >=0 && Stopper.rLeftCheck(gameObjects, this)!=0)
				  {
				      move(-5,0);
				      b--;
				  }
			      else
				  b=99;
			      */

			      switch(direct)  // 0 -- up 1 -- right 2 -- down 3 -- left
			      {
				  case(0):
				  if (Stopper.rTopCheck(gameObjects,this)==5 && steps!=0)
				      {
					  move(0,-5);
					  steps--;
					  System.out.println(steps +" "+ direct);
				      }
				  else
				      {
					  direct = (int) (Math.random()*4);
					  steps  = (int) (Math.random()+40*2);
				      }
				  break;
				  case(1):
				  if (Stopper.rRightCheck(gameObjects,this)==5 && steps!=0)
				      {
					  move(5,0);
					  steps--;
					  System.out.println(steps +" "+ direct);
				      }
				  else
				      {
					  direct = (int) (Math.random()*4);
					  steps  = (int) (Math.random()+40*2);
				      }
				  break;
				  case(2):
				  if (Stopper.rBotCheck(gameObjects,this)==5 && steps!=0)
				      {
					  move(0,5);
					  steps--;
					  System.out.println(steps +" "+ direct);
				      }
				  else
				      {
					  direct = (int) (Math.random()*4);
					  steps  = (int) (Math.random()+40*2);
				      }
				  break;
				  case(3):
				  if (Stopper.rLeftCheck(gameObjects,this)==5 && steps!=0)
				      {
					  move(-5,0);
					  steps--;
					  System.out.println(steps +" "+ direct);
				      }
				  else
				      {
					  direct = (int) (Math.random()*4);
					  steps  = (int) (Math.random()+40*2);
				      }
				  break;
			      }
    }

    public void checking()
    {
	if((this.getPosx()-player.getPosx()<=200 && player.getPosx()-this.getPosx()<=200)
	   &&
	   (this.getPosy()-player.getPosy()<=233 && player.getPosy()-this.getPosy()<=233))
	    {
		state = 1;
		System.out.println("I'm ANGRY!!");
	    }
	else
	    {
		state = 0;
		System.out.println("Just walking around!");
	    }
	
    }


    public BufferedImage getImage_()
    {
        return ImageCollection.enemy[direction][animNumber];
    }
    
    
}
