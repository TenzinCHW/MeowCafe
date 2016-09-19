package BeanGrinder.Week2;

/**
 * Created by HanWei on 19/9/2016.
 */
public class Octagon implements Comparable<Octagon> {
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon o){
        if (o.getSide() == this.getSide()){
            return 0;
        }
        else if (o.getSide() > this.getSide()){
            return -1;
        }
        else{
            return 1;
        }
    }
}
