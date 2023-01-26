import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    public IBag bag;
    public int waitTime;

    public AbstractGiveSurprises(String container, int waitTime) {
        this.bag = BagFactory.getInstance().makeBag(container);
        this.waitTime = waitTime;
    }

    public void put(ISurprise newSurprise) {
        this.bag.put(newSurprise);
    }

    public void put(IBag surprise) {
        this.bag.put(surprise);
    }

    public void give() {
        if (!this.bag.isEmpty()) {
            this.bag.takeOut().enjoy();
            giveWithPassion();
        }
    }

    public void giveAll() {
        while (!this.bag.isEmpty()) {
            give();
            try {
                TimeUnit.SECONDS.sleep(this.waitTime); // number of seconds to sleep
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    abstract void giveWithPassion();
}
