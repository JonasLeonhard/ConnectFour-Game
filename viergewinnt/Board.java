package viergewinnt;

// repräsentiert das Spielbrett (als Model im
// Model-View-Controller-Softwaremuster);
// das Model ist "Observable" - es wird vom View (dem "Observer") beobachtet;
// bei Änderungen wird mit notifyObservers die Methode update dsr Observers
// aufgerufen

public class Board extends Configuration
{

    public static final int ZEILE=6, SPALTE=7;
    public int[][] b; // Belegung des Spielbretts (-1 = frei, 0 = rot, 1= gelb)
    public int[] h; // Höhen der Säulen von Spielsteinen in den Spalten
    public int moves=0;
    public int haswon=-1;

    public Board()
    {

        b=new int[ZEILE][SPALTE];
        h=new int[SPALTE];

    }

    // Factory-Methode: liefert ein leeres Spielbrett
    public static Board emptyBoard()
    {

        Board board=new Board();
        board.clear();
        return board;

    }

    // leert das Spielbrett
    public void clear()
    {

        for (int i=0; i<ZEILE; i++)

            for (int j=0; j<SPALTE; j++)
                b[i][j]=-1;

        for (int j=0; j<SPALTE; j++)
            h[j]=0;

    }

    // liefert eine Kopie des Spielbretts
    public Board copy()
    {

        Board board=new Board();

        for (int i=0; i<ZEILE; i++)

            for (int j=0; j<SPALTE; j++)
                board.b[i][j]=b[i][j];

        for (int j=0; j<SPALTE; j++)
            board.h[j]=h[j];

        return board;

    }

    // führt den Spielzug move auf dem Spielbrett aus
    
    public void applyMove(Move move)
    {
        
        int j=move.s;
        int i=h[j];
        
        if (i<ZEILE)
        {
            b[ZEILE-i-1][j]=move.c;
            h[j]++;
            
           
        }
        moves++;

        if (fourInAnyDirection(new Position(ZEILE-i-1, j)))
        {
            haswon=move.c;
        }

        if (gameOver())
        {
            System.out.println("Spieler "+move.c+" hat gewonnen");
        }

    }

    @Override
    public String toString()
    {
        String s="";

        for (int i=0; i<ZEILE; i++)
        {
            for (int j=0; j<SPALTE; j++)
                s+=b[i][j]+" ";
            s+="\n";
        }

        return s;

    }

    // liefert true, wenn mindestens vier gleichfarbige
    // Spielsteine von der Position p des Spielbretts aus
    // gesehen in Richtung dir und in entgegengesetzter
    // Richtung dir.neg() zusammengenommen liegen
    public boolean fourInDirection(Position pos, Position dir)
    {
        int f=getColor(pos);
        int count=-1;

        for (int i=0; i<2; i++)
        {

            Position q=pos;

            while (isValidPosition(q)&&getColor(q)==f)
            {
                count++;
                q=q.add(dir);
                // System.out.println(q + "q");
                // System.out.println(count);
            }
            dir=dir.neg();
        }

        return count>=4;

    }

    private boolean isValidPosition(Position pos)
    {
        return pos.z<ZEILE&&pos.s<SPALTE&&pos.z>=0&&pos.s>=0;
    }

    
    //true wenn höhe der mov Spalte kleiner als gesamt spalte ist
    public boolean isValidMove(Move mov)
    {
        return h[mov.s]<SPALTE;
    }

    private int getColor(Position pos)
    {
        return b[pos.z][pos.s];
    }

    // liefert true, wenn von der Position p des Spielbretts
    // aus gesehen mindestens vier gleichfarbige Spielsteine
    // in irgendeiner Richtung liegen
    public boolean fourInAnyDirection(Position p)
    {
        return fourInDirection(p, new Position(1, 0))
                ||fourInDirection(p, new Position(0, 1))
                ||fourInDirection(p, new Position(1, 1))
                ||fourInDirection(p, new Position(1, -1));
    }

    public boolean gameOver()
    {
        return (haswon==0||haswon==1||moves==ZEILE*SPALTE);
    }

}
//public boolean isValidMove(Position pos)
// {
// return h[pos.z]<ZEILE;
// }