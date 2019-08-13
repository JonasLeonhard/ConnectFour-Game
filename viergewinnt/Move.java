package viergewinnt;

//repräsentiert einen Spielzug des Spiels "Vier gewinnt" durch
//Angabe der Spalte s, in die der Spielstein geworfen wird, und
//der Farbe c des Spielsteins
public class Move
{
 public int s;   // Spalte
 public int c;   // Farbe

 // Konstruktor
 public Move(int s, int c)
 {
     this.s=s;
     this.c=c;
 }

 @Override
 public String toString()
 {
     return s+" "+c;
 }

}