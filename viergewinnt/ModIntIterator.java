package viergewinnt;

import java.util.Iterator;

public class ModIntIterator implements Iterator<Integer>
{

    private int n, i=0;

    public ModIntIterator(int n)
    {
        this.n=n;

    }

    @Override
    public boolean hasNext()
    {

        return i<n;

    }

    // gibt von null aus die nächste zahl aus.
    @Override
    public Integer next()
    {
        int ret=0;
        ret=i;
        i++;
        return ret;
    }

}