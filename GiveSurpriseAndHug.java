public class GiveSurpriseAndHug extends AbstractGiveSurprises {

    public GiveSurpriseAndHug(String container, int waitTime) {
        super(container, waitTime);
    }

    @Override
    public void giveWithPassion() {
        System.out.println("Warm wishes and a big hug!");
    }
}
