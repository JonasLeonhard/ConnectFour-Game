package viergewinnt;

import java.awt.Color;
import java.awt.Graphics;


// repräsentiert eine mxn-Matrix von Kreisen
public class CircleGrid
{
    public int m, n;
    public int left=40, top=20, diameter=40, space=10;
    public Circle[][] grid;

    // Konstruktor
    public CircleGrid(int m, int n)
    {
        this.m=m;
        this.n=n;
        grid=new Circle[m][n];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                grid[i][j]=new Circle(j*(space+diameter)+left, i*(space+diameter)+top, diameter);
    }

    // zeichnet das CircleGrid this
    public void draw(Graphics gr)
    {
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                grid[i][j].draw(gr);
    }

    // liefert die Position (Zeile und Spalte) eines angeklickten Kreises
    // innerhalb des CircleGrids, bzw. null, wenn danebengeklickt wurde
    public Position clicked(int x, int y)
    {
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j].clicked(x, y))
                        return new Position(i, j);
        return null;
    }

    // setzt die Füllfarbe des Kreises an Position (i, j) auf die Farbe f
    public void fill(int i, int j, Color f)
    {
        grid[i][j].setFill(f);
    }
    public void fill(Position p, Color f)
    {
        fill(p.z, p.s, f);
    }

    // überführt die datenmäßige Darstellung des Spielbretts (das Board)
    // in die Bildschirmdarstellung als CircleGrid
    public void display(Board board)
    {
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                fill(i, j, color(board.b[i][j]));
    }

    // übersetzt 0, 1 und -1 in entsprechende Farben 
    private Color color(int i)
    {
        if (i==0)
            return Color.RED;
        if (i==1)
            return Color.YELLOW;
        return Color.WHITE;
    }

}