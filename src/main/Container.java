package main;

import phases.FirstPhase;

import javax.swing.JFrame;
import java.awt.*;

public class Container extends JFrame{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width;
    private int height = screenSize.height;

    public Container() {
        add(new FirstPhase());
        setTitle("Janela");
        setSize(new Dimension(width-900, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);


    }
}
