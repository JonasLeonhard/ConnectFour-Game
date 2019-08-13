package viergewinnt;

import java.util.Observable;

public class Configuration extends Observable
{
    public Board board;
    public int moves=0, turn=0;

    public void reset()
    {
        this.board=Board.emptyBoard();
        this.turn=0;
        this.setChanged();
        this.notifyObservers();
    }

    public Configuration copy()
    {
        Configuration config=new Configuration();
        config.moves=moves;
        config.turn=turn;
        return config;
    }

    public void applyMove(Move move)
    {

        if (move.c==turn)
        {
            setMove(move);
            moves++;
            turn=1-turn; // turn umkehren zu 1 oder 0

            this.setChanged();
            this.notifyObservers();
        }

    }

    //ohne observer zu benachrichtigen
    public void setMove(Move move)
    {
        board.applyMove(move);
    }

    // bewertet die aktuelle spieltstellung
    // gibt die anzahl der ausgeführten züge bis haswon an.
    public double rate()
    {
        int maxmove=board.ZEILE*board.SPALTE;

        if (board.haswon==turn)
        {
            return (maxmove+1-board.moves);
        }
        else if (board.haswon==turn)
        {
            return -(maxmove+1-board.moves);
        }
        else
        {
            return 0;
        }

    }

}
// public static Configuration startConfiguration()
// {
//
// Configuration config=new Configuration();
// config.board=Board.emptyBoard();
// return config;
// }
