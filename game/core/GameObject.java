package game.core;

import java.awt.image.BufferedImage;

public abstract class GameObject {
    private String image = "";
    private int posX = 0;
    private int posY = 0;
    private int height = 0;
    private int width = 0;

    public GameObject(int posX, int posY, int height, int width) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
    }

    public int getPosx() {
        return this.posX;
    }

    public int getPosy() {
        return this.posY;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setPosx(int deltax) {
        this.posX += deltax;
    }

    public void setPosy(int deltay) {
        this.posY += deltay;
    }

    public void move(int deltax, int deltay) {
        setPosx(deltax);
        setPosy(deltay);
    }


    public abstract BufferedImage getImage_();
}
