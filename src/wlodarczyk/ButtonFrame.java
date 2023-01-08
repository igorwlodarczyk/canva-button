package wlodarczyk;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.geom.Point2D;



public class ButtonFrame extends JFrame implements MouseMotionListener, ActionListener {
    JButton clickMeButton = new JButton("Click me!");
    int buttonWidth = 100;
    int buttonHeight = 30;
    static int width1 = 1000;
    static int height1 = 1000;
    int buttonX = width1 / 2 - buttonWidth / 2;
    int buttonY = height1 / 2 - buttonHeight / 2;

    public ButtonFrame() {
        this.setLayout(null);
        addMouseMotionListener(this);
        FrameBorder panel1 = new FrameBorder();
        FrameBorder panel2 = new FrameBorder();
        FrameBorder panel3 = new FrameBorder();
        FrameBorder panel4 = new FrameBorder();
        panel1.setBounds(0, 0, width1, 60);
        panel2.setBounds(0, 0, 60, height1);
        panel3.setBounds(0, height1 - 90, width1, 60);
        panel4.setBounds(width1 - 60, 0, 60, height1);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(width1, height1);
        this.setResizable(false);
        this.setTitle("Running button");
        clickMeButton.addActionListener(this);
        clickMeButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        this.add(clickMeButton);
        this.setVisible(true);
    }

    // Implementation of the MouseMotionListener interface
    public void mouseDragged(MouseEvent e) {
        // This method is called when the mouse is dragged
    }

    public void mouseMoved(MouseEvent e) {
        Point mousePoint = getCursorPosition();
        if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX, buttonY) < 130){
            int newX = buttonX;
            int newY = buttonY;
            double maxDistance = 0;

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX + 5, buttonY) > maxDistance)
            {
                newX = buttonX + 5;
                newY = buttonY;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX + 5, buttonY);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX + 5, buttonY + 5) > maxDistance)
            {
                newX = buttonX + 5;
                newY = buttonY + 5;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX + 5, buttonY + 5);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX - 5, buttonY) > maxDistance)
            {
                newX = buttonX - 5;
                newY = buttonY;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX - 5, buttonY);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX - 5, buttonY - 5) > maxDistance)
            {
                newX = buttonX - 5;
                newY = buttonY - 5;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX - 5, buttonY - 5);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX + 5, buttonY - 5) > maxDistance)
            {
                newX = buttonX + 5;
                newY = buttonY - 5;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX + 5, buttonY - 5);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX - 5, buttonY + 5) > maxDistance)
            {
                newX = buttonX - 5;
                newY = buttonY + 5;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX - 5, buttonY + 5);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX, buttonY - 5) > maxDistance)
            {
                newX = buttonX;
                newY = buttonY - 5;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX, buttonY - 5);
            }

            if(Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX, buttonY + 5) > maxDistance)
            {
                newX = buttonX;
                newY = buttonY + 5;
                maxDistance = Point2D.distance(mousePoint.getX(), mousePoint.getY(), buttonX, buttonY + 5);
            }

            buttonX = newX;
            buttonY = newY;
            if(buttonX < 60){
                buttonX = 60;
            }

            if(buttonX > width1 - buttonWidth - 60){
                buttonX = width1 - buttonWidth - 60;
            }

            if(buttonY < 60){
                buttonY = 60;
            }

            if(buttonY > height1 - buttonHeight * 2 - 60){
                buttonY = height1 - buttonHeight * 2 - 60;
            }

            clickMeButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        }

    }

    public Point getCursorPosition() {
        return getMousePosition();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickMeButton){
            dispose();
            new MainFrame();
        }
    }
}
