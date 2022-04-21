package knights;

import graphs.Graph;

public class Square {
    private final int r;
    private final int c;

    public Square(int r, int c){
        this.r = r;
        this.c = c;
    }
    public Square(String r, String c){this(Integer.parseInt(r), Integer.parseInt(c));}
    public int getC() {return c;}
    public int getR() {return r;}

    @Override
    public int hashCode(){return r * 100 + c;}
    @Override
    public String toString(){return "(" + r + ", " + c + ")";}
    @Override
    public boolean equals(Object o){
        if(o instanceof Square){
            Square other = (Square) o;
            return this.r == other.r && this.c == other.c;
        }
        else{
            return false;
        }
    } 
}
