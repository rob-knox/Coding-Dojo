import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB){
        double legs = (legA * legA) + (legB * legB);
        return Math.sqrt(legs);
    }
}