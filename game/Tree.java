package game;

import game.core.GameObject;
import game.images.ImageCollection;

import java.awt.image.BufferedImage;

public class Tree extends GameObject {
    public Tree(int posX, int posY, int height, int width) {
        super(posX, posY, height, width);
    }


    public BufferedImage getImage_() {
        return ImageCollection.tree;
    }

}
