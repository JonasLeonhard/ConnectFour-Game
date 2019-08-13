package viergewinnt;

import java.util.Observable;

public class SimplePlayer implements Player
{

    int playercol;
    Configuration conf;

    @Override
    public void update(Observable o, Object arg)
    {
        makeMove(FindMove());
    }

    
    private Move FindMove()
    {
        
        int random=(int)(Math.random()*7);

        while (!conf.board.isValidMove(new Move(random, playercol)))
        {
            random=(int)(Math.random()*7);
        }

        return new Move(random, playercol);
        
        
    }

    @Override
    public void setColor(int k)
    {
        playercol=k;
    }

    @Override
    public void setConfiguration(Configuration config)
    {
        this.conf=config;
        conf.addObserver(this);
    }

    @Override
    
    public void makeMove(Move move) {  


    if(!conf.board.gameOver()){

    conf.applyMove(move);

    }

    }
}
//int zeile=(int)(Math.random()*6);
// int spalte=(int)(Math.random()*7);
//
// Position p=new Position(zeile, spalte);
//
// Move r=new Move(spalte, this.playercol);
//
// while (!conf.board.isValidMove(p)) // move wird so lange verändert
// bis
// // true
// {
//
// r.s=(int)(Math.random()*7);
//
// }
