package phases;

import javax.swing.*;
import java.awt.*;

public class Shoot{
    private Image tile;
    private int x,y;
    private int width, height;
    private boolean isVisible;
    private static final int HEIGHT = 1200;
    private static int SPEED = 4;


    public Shoot(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    public void load() {
        ImageIcon ref = new ImageIcon("assets\\shoot.png");
        tile = ref.getImage();

        this.width = tile.getWidth(null);
        this.height = tile.getHeight(null);
    }

    public void update() {
        this.y -= SPEED;
            if(this.y > HEIGHT) {
                isVisible = false;
            }
    }

    public Image getTile() {
        return tile;
    }

    public void setTile(Image tile) {
        this.tile = tile;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public static void setSPEED(int SPEED) {
        Shoot.SPEED = SPEED;
    }
}


