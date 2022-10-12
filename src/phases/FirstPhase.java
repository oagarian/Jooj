package phases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
public class FirstPhase extends JPanel implements ActionListener {
    private Image background;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width;
    private int height = screenSize.height;
    private Player player;
    private Timer timer;
    public FirstPhase(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon refference = new ImageIcon("assets\\background.png");
        background = refference.getImage();
        player = new Player();
        player.load();
        addKeyListener(new KeyboardAdapter());
        timer = new Timer(5, this);
        timer.start();


    }

    public void paint(Graphics graph) {
        Graphics2D graphic = (Graphics2D) graph;
        graphic.drawImage(background, 0, 0, width, height, null);
        graphic.drawImage(player.getTile(), player.getX(), player.getY(), this);
        List<Shoot> shoots = player.getShoots();
        for(int i = 0; i < shoots.size(); i++) {
            Shoot s = shoots.get(i);
            s.load();
            graphic.drawImage(s.getTile(), s.getX(), s.getY(), this);
        }
        graph.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Shoot> shoots = player.getShoots();

        for(int i = 0; i < shoots.size(); i++) {
            Shoot s = shoots.get(i);
            if(s.isVisible()) {
                s.update();
            } else {
                shoots.remove(i);

            }
        }
        repaint();
    }

    private class KeyboardAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRelease(e);
        }
    }
}
