package game.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCollection {
    public static final BufferedImage tree;

    public static final BufferedImage backGround;

    public static final BufferedImage coin;

    public static final BufferedImage[][] man = new BufferedImage[4][4];

    public static final BufferedImage[][] enemy = new BufferedImage[4][4];
    
    static {
        BufferedImage _tree;
        try {
            _tree = ImageIO.read(new File("res/tree.png"));
        } catch (IOException e) {
            e.printStackTrace();
            _tree = null;
        }
        tree = _tree;

	
        BufferedImage _coin;
        try {
            _coin = ImageIO.read(new File("res/coin.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            _coin = null;
        }
        coin = _coin;


	BufferedImage _backGround;
        try {
            _backGround = ImageIO.read(new File("res/backGround.png"));
        } catch (IOException e) {
            e.printStackTrace();
            _backGround = null;
        }
        backGround = _backGround;
	
        BufferedImage man_full;
        try {
            man_full = ImageIO.read(new File("res/man.png"));
        } catch (IOException e) {
            e.printStackTrace();
            man_full = null;
        }
        for (int dir = 0; dir < 4; dir++) {
            for (int anim = 0; anim < 4; anim++) {
                man[dir][anim] = man_full.getSubimage(
		    400 * anim,
                    599 * dir,
                    400,
                    600
                );
            }
        }
	
	BufferedImage enemy_full;
        try {
            enemy_full = ImageIO.read(new File("res/enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
            enemy_full = null;
        }
        for (int dir = 0; dir < 4; dir++) {
            for (int anim = 0; anim < 4; anim++) {
                enemy[dir][anim] = enemy_full.getSubimage(
		    400 * anim,
                    599 * dir,
                    400,
                    600
                );
            }
        }
    }
}
