import java.util.ArrayList;
import java.util.Random;

public class LIFOBag implements IBag {

    public ArrayList<ISurprise> surprises;

    public LIFOBag() {
        this.surprises = new ArrayList<ISurprise>();
    }

    public void put(ISurprise newSurprise) {
        this.surprises.add(newSurprise);
    }

    public void put(IBag bagOfSurprises) {
        while (!bagOfSurprises.isEmpty()) {
            surprises.add(bagOfSurprises.takeOut());
        }
    }

    public ISurprise takeOut() {
        if (!this.surprises.isEmpty()) {
            ISurprise surprise = surprises.get(surprises.size() - 1);
            surprises.remove(surprise);
            return surprise;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.surprises.isEmpty();
    }

    public int size() {
        return this.surprises.size();
    }
}
