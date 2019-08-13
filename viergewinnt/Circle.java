package viergewinnt;

import java.awt.Color;
import java.awt.Graphics;

// repräsentiert einen Kreis auf dem Bildschirm
// mit Koordinaten x und y sowie Durchmesser d
public class Circle
{
    // Attribute
    public int left, top, diameter;
    public Color fill=Color.WHITE;   // Initialisierung des Attributs fill

    // Konstruktor
    public Circle(int l, int t, int d)
    {
        left=l;
        top=t;
        diameter=d;
    }

    // Farbe festlegen
    public void setFill(Color f)
    {
        fill=f;
    }

    // liefert true, wenn die Klick-Koordinaten x und y innerhalb des
    // den Kreis umschließenden Quadrats liegen
    public boolean clicked(int x, int y)
    {
        return x>=left && x<=left+diameter && y>=top && y<=top+diameter;
    }

    // gefüllten Kreis zeichnen
    public void draw(Graphics gr)
    {
        gr.setColor(fill);
        gr.fillOval(left, top, diameter, diameter);
    }

}