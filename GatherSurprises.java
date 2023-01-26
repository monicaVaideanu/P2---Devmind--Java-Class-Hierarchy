import java.util.Random;

public final class GatherSurprises {
    private static GatherSurprises instance = new GatherSurprises();

    private GatherSurprises() {
    }

    public static ISurprise[] gather(int n) {
        ISurprise[] arraySurprises = new ISurprise[n];
        for (int i = 0; i < n; i++) {
            arraySurprises[i] = gather();
        }
        return arraySurprises;
    }

    public static ISurprise gather() {
        Random random = new Random();
        int m = random.nextInt(3);
        return methodToChose(m);
    }

    private static ISurprise methodToChose(int m) {
        return switch (m) {
            case 0 -> FortuneCookie.generate();
            case 1 -> Candies.generate();
            case 2 -> MinionToy.generate();
            default -> null;
        };
    }

    public static GatherSurprises getInstance() {
        return instance;
    }
}
