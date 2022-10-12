package main;
import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private Image background;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width;
    private int height = screenSize.height;
    public Menu(){
        ImageIcon refference = new ImageIcon("assets\\background.png");
        background = refference.getImage();
    }

    public void paint(Graphics graph) {
        Graphics2D graphic = (Graphics2D) graph;
        graphic.drawImage(background, 0, 0, width, height, null);
        graph.dispose();
    }
}
