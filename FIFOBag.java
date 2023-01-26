import java.util.ArrayList;

public class FIFOBag implements IBag {

    public ArrayList<ISurprise> surprises;

    public FIFOBag() {
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
            ISurprise surprise = surprises.get(0);
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
