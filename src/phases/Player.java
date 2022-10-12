package phases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int x, y;
    private int dx, dy;
    private Image tile;

    private List<Shoot> shoots;

    private int width, height;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    public Player() {
        this.x = 450;
        this.y = 850;

        shoots = new ArrayList<Shoot>();


    }

    public void load(){
        ImageIcon ref = new ImageIcon("assets\\spaceship.png");
        tile = ref.getImage().getScaledInstance(128, 128, 1);

        this.height = tile.getHeight(null);
        this.width = tile.getWidth(null);
        System.out.println("Height: "+screenHeight);
        System.out.println("Width: "+screenWidth);

    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void simpleShoot() {
        this.shoots.add(new Shoot(x+(width+20), y+height-15));
    }

    public void keyPressed(KeyEvent input) {
        int keyCode = input.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE) {
            simpleShoot();
        }
        if(keyCode == KeyEvent.VK_UP) {

            if(y <= 0) {
                y = 0;
                dy = 0;
            } else {
                dy = -2;
            }
        }
        if(keyCode == KeyEvent.VK_DOWN) {
            if(y >= screenHeight) {
                y = screenHeight;
                dy = 0;
            } else {
                dy = 2;
            }

        }
        if(keyCode == KeyEvent.VK_LEFT) {
            if(x <= 0) {
                x = 0;
                dx = 0;
            } else {
                dx = -2;
            }
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            if(x >= screenWidth) {
                x = screenWidth;
                dx = 0;
            } else {
                dx = 2;
            }
        }

        System.out.println("X: " + x);
        System.out.println("Y: " + y);


    }

    public void keyRelease(KeyEvent input) {
        int keyCode = input.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Image getTile() {
        return tile;
    }

    public void setTile(Image tile) {
        this.tile = tile;
    }

    public List<Shoot> getShoots() {
        return shoots;
    }

    public void setShoots(List<Shoot> shoots) {
        this.shoots = shoots;
    }
}


