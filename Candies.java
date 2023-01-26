import java.util.Random;

public class Candies implements ISurprise {
    private final static String[] candies = {"chocolate", "jelly", "fruits", "vanilla"};
    private String tipeOfCandies;
    private int numberOfCandies;

    public Candies(int numberOfCandies, String tipeOfCandies) {
        this.numberOfCandies = numberOfCandies;
        this.tipeOfCandies = tipeOfCandies;
    }

    @Override
    public void enjoy() {
        System.out.println("Ati primit " + this.tipeOfCandies + " in numar de: " + this.numberOfCandies + ".");
    }

    public static Candies generate() {
        int nr = 0;
        while (nr == 0) {
            nr = random.nextInt(50);
        }
        return new Candies(nr, candies[random.nextInt(candies.length)]);
    }
}
