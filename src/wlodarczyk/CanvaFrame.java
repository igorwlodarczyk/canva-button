package wlodarczyk;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CanvaFrame extends JFrame implements KeyListener {
    static int width1 = 1000;
    static int height1 = 1000;
    DrawPanel panel;
    CanvaButtonPanel panel2;

    public CanvaFrame() {
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(width1, height1);
        this.setResizable(false);
        this.setTitle("Canva");
        DrawPanel panel2 = new DrawPanel();
        this.panel = panel2;
        CanvaButtonPanel panel1 = new CanvaButtonPanel(this, panel2);
        this.panel2 = panel1;
        panel1.setBounds(800, 0, 200, 1000);
        panel2.setBounds(0, 0, 800, 1000);
        add(panel1);
        add(panel2);


        this.setFocusable(true);
        this.addKeyListener(this);

        this.requestFocus();

        this.setVisible(true);
    }

    public void bringFocus(){
        this.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '1':
                this.panel.setFigureType(0);
                panel2.setFigureType("Line");
                break;
            case '2':
                this.panel.setFigureType(1);
                panel2.setFigureType("Rectangle");
                break;
            case '3':
                this.panel.setFigureType(2);
                panel2.setFigureType("Oval");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
