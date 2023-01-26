public class BagFactory implements IBagFactory {
    private static BagFactory instance = new BagFactory();

    private BagFactory() {
    }

    public static BagFactory getInstance() {
        return instance;
    }

    public IBag makeBag(String typeBag) {
        switch (typeBag) {
            case "RANDOM":
                return new RandomOutBag();
            case "LIFO":
                return new LIFOBag();
            case "FIFO":
                return new FIFOBag();
            default:
                return null;
        }
    }
}
