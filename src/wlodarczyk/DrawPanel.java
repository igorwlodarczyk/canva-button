package wlodarczyk;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    private int figureType = 2;
    private Color color = Color.BLACK;
    private int startX, startY, endX, endY;

    private ArrayList<Figure> figures = new ArrayList<>();

    public DrawPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(800, 1000));

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figure figure : figures) {
            g.setColor(figure.color);
            switch (figure.type) {
                case 0:
                    // Line
                    g.drawLine(figure.startX, figure.startY, figure.endX, figure.endY);
                    break;
                case 1:
                    // Rectangle
                    g.drawRect(Math.min(figure.startX, figure.endX), Math.min(figure.startY, figure.endY),
                            Math.abs(figure.startX - figure.endX), Math.abs(figure.startY - figure.endY));
                    break;
                case 2:
                    // Oval
                    g.drawOval(Math.min(figure.startX, figure.endX), Math.min(figure.startY, figure.endY),
                            Math.abs(figure.startX - figure.endX), Math.abs(figure.startY - figure.endY));
                    break;
            }
        }
    }

    public void setFigureType(int i){
        figureType = i;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    public void addFigure(int type, Color color, int startX, int startY, int endX, int endY) {
        Figure figure = new Figure(type, color, startX, startY, endX, endY);
        figures.add(figure);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();

        addFigure(figureType, color, startX, startY, endX, endY);

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void clearFigures(){
        figures.clear();
        repaint();
    }


    public void setColor(Color color){
        this.color = color;
    }
}