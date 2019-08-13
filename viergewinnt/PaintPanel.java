package viergewinnt;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.JPanel;

// Zeichenfläche zur Darstellung des Spielbretts (der View),
// reagiert auf Mausklicks sowie als Observer auf Änderungen
// des Models (des Boards).
public class PaintPanel extends JPanel implements MouseListener, Player
{
    /**
     * 
     */
    private static final long serialVersionUID=1L;
    // Attribute: View und Model
    private CircleGrid circlegrid;
    private Board board;
    private int mycolor;
    private Configuration conf;

    // Konstruktor
    public PaintPanel()
    {
        board=Board.emptyBoard();
        circlegrid=new CircleGrid(Board.ZEILE, Board.SPALTE);
        board.addObserver(this); // als Observer beim Observable board anmelden
        addMouseListener(this);
        mycolor=0;
    }

    @Override
    public void paint(Graphics gr)
    {
        super.paint(gr);
        circlegrid.draw(gr);
    }

    @Override
    public void mouseClicked(MouseEvent arg0)
    {
    }

    @Override
    public void mouseEntered(MouseEvent arg0)
    {
    }

    @Override
    public void mouseExited(MouseEvent arg0)
    {
    }

    // angeklickten Kreis ermitteln und Spielzug auf dem Board ausführen
    @Override
    public void mousePressed(MouseEvent evt)
    {
        int x=evt.getX();
        int y=evt.getY();
        Position p=circlegrid.clicked(x, y);
        if (p!=null)
            conf.applyMove(new Move(p.s, mycolor));
    }

    @Override
    public void mouseReleased(MouseEvent arg0)
    {
    }

    // diese Methode wird immer dann automatisch ausgeführt,
    // wenn sich auf dem Board etwas geändert hat; dann
    // aktualisieren wir das CircleGrid entsprechend und
    // zeichnen es neu
    @Override
    public void update(Observable arg0, Object arg1)
    {
        circlegrid.display(conf.board);
        repaint();
    }

    @Override
    public void setColor(int k)
    {
        mycolor=k;
    }

    @Override
    public void setConfiguration(Configuration config)
    {
        conf=config;
        config.addObserver(this);
    }

    @Override
    public void makeMove(Move move)
    {

    }

}