public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double legC = (legA) ^ 2 + (legB) ^ 2;
        double sqrt = Math.sqrt(legC);
        return sqrt;
    }
}
