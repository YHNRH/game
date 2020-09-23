package game;

import game.core.GameObject;
import game.images.ImageCollection;

import java.awt.image.BufferedImage;

public class Player extends GameObject implements AbleToMove {
    private int animNumber = 0;
    private int direction = 0;
    private int moveCount = 0;
    private int hp = 100;
    private int energy = 500;
    private int coins = 0;
    private int ableToTake = 0; // Не может ничего поднять
    public void setATT(int a)
    {
	this.ableToTake = a;
    }
    public int getATT()
    {
	return this.ableToTake;
    }
    public void incCoins(int a)
    {
	this.coins += a;
    }
    public int getCoins()
    {
	return this.coins;
    }
    public int getHP()
    {
	return this.hp;
    }

    public int getEnergy()
    {
	return this.energy;
    }
    
    public Player(int posX, int posY, int width, int height)
    {
        super(posX, posY, height, width);
    }
    
    public BufferedImage getImage_() {
        return ImageCollection.man[direction][animNumber];
    }
    
    public void setAnimNumber(int a)
    {
	this.animNumber = a;
    }
    // Это устаревший метод
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

    public void move (int direction)
    {
	if (this.direction == direction)
	    moveCount++;
	else
	    {
		this.direction = direction;
		moveCount = 0;
	    }
	if (moveCount>=4)
	    {
		moveCount = 0;
		animNumber++;
		energy-=1;
	    }
	if (this.animNumber == 4)
	    {
		this.animNumber = 0;
	    }
    }
    public void setmoveCount(int a)
    {
	this.moveCount = a;
    }
    
    
    
    public void move(int deltax, int deltay, boolean isJump) {
        setPosx(deltax);
        setPosy(deltay);
        // Какой-то код с реализацией прыжка
    }
}
