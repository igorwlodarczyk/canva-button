package wlodarczyk;

import java.awt.*;

public class Figure {
    // Fields to store the figure type, color, start point, and end point
    public int type;
    public Color color;
    public int startX, startY, endX, endY;

    public Figure(int type, Color color, int startX, int startY, int endX, int endY) {
        this.type = type;
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}