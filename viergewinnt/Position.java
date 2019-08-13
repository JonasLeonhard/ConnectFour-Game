package viergewinnt;

// repräsentiert eine Position auf dem Spielbrett
// bestehend aus Zeilenindex z und Spaltenindex s
public class Position
{
    public int z, s;

    // Konstruktor
    public Position(int z, int s)
    {
        this.z=z;
        this.s=s;
    }

    @Override
    public String toString()
    {
        return z+" "+s;
    }

    public Position add(Position dir)
    {
        return new Position(this.z+dir.z, this.s+dir.s);
    }

    public Position neg()
    {
        return new Position(-this.z, -this.s);
    }

}
