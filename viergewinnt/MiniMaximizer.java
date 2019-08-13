package viergewinnt;
//minimaximizer vergleicht übergebene objekte und speichert Mindextwert und maximalwert
public class MiniMaximizer<Type>
{
    private double minval, maxval;
    private Type minobj, maxobj;
    private boolean empty;

    public MiniMaximizer()
    {
        reset();
    }

    public void reset()
    {
        minval=Double.POSITIVE_INFINITY; //weil wir werte vergleichen größter wert
        maxval=Double.NEGATIVE_INFINITY; // ""
        minobj=null;
        maxobj=null;
        empty=true;
    }

    //ersetzt min und max sofern < oder >
    public void add(double val, Type obj)
    {
        if (empty || val<minval) //kleiner als mindeswert
        {
            minval=val;
            minobj=obj;
        }
        if (empty || val>maxval) //größer als hochstwert
        {
            maxval=val;
            maxobj=obj;
        }
        empty=false;
    }

    // überladen für nur werte vergleichen
    public void add(double val)
    {
        add(val, null);
    }

    public double getMinVal()
    {
        return minval;
    }

    public Type getMinObj()
    {
        return minobj;
    }

    public double getMaxVal()
    {
        return maxval;
    }

    public Type getMaxObj()
    {
        return maxobj;
    }

    public boolean isEmpty()
    {
        return empty;
    }

} 
