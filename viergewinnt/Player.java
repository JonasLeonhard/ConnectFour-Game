package viergewinnt;

import java.util.Observer;

public interface Player extends Observer
{
    public void setColor(int k);
    public void setConfiguration(Configuration config);
    public void makeMove(Move move);
}
