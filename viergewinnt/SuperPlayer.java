package viergewinnt;

import java.util.Iterator;

public class SuperPlayer extends SimplePlayer
{
    private int searchdepth = 5;
    
    
  
        public Move findMove()
        {
          
            Configuration s=conf;
            Iterator it=new ModIntIterator(Board.SPALTE);
            MiniMaximizer<Move> minimax=new MiniMaximizer<Move>();
           
            
            Move move;
            Configuration t;
            while (it.hasNext())
            {
                move=new Move((int)(it.next()), playercol);
                t=s.copy();
                t.setMove(move);
                minimax.add(-eval(t, searchdepth-1), move);
            }
            return minimax.getMaxObj();
    }
    
    private double eval(Configuration s, int d)
    {
        Iterator<Integer> it=new ModIntIterator(d);
        MiniMaximizer<Move> minimax=new MiniMaximizer<Move>();
        Move move;
        Configuration t;
        
        
        if (d==0 || s.board.gameOver())
            return s.rate(); //gibt anzahl der bis dahin ausgeführten spielzüge
       
        
        while (it.hasNext()) //
        {
            move = new Move(it.next(), playercol);
            t=s.copy();
            t.setMove(move);
            minimax.add(-eval(t, d-1), move);
        }
        
        return minimax.getMaxVal();
    }
}

//    public Move findMove()
//    {
//        int searchdepth= 5;
//        Move move;
//        Configuration s=conf; //neue conf copy
//        Configuration t;
//        
//        ModIntIterator it=new ModIntIterator(0);
//        
//        MiniMaximizer<Move> minimax=new MiniMaximizer<Move>();
//        
//        
//        
//        
//        
//        
//        while (it.next() <= Board.ZEILE*Board.SPALTE) //gibt es einen nächten move?
//        {
//            
//            move=new Move(it.next(), playercol);
//            
//            t=s.copy();
//            t.setMove(move);
//            
//            minimax.add(-eval(t, searchdepth-1), move);
//        }
//        return minimax.getMaxObj();
//    }
//
//    // wertet einen Spielbaum einer Configuration in der übergebenen Tiefe d aus
//
//    private double eval(Configuration s, int d)
//    {
//        if (d==0||s.board.gameOver())
//        {
//           return s.rate();
//       }
//        
//        ModIntIterator it=new ModIntIterator(d);
//        MiniMaximizer<Move> minimax=new MiniMaximizer<Move>();
//        Move move;
//        Configuration t;
//        while (it.hasNext())
//        {
//            move=new Move (it.next(), playercol);
//            t=s.copy();
//            t.setMove(move);
//           minimax.add(-eval(t, d-1), move);
//        }
//        return minimax.getMaxVal();
//
//    }
//}
