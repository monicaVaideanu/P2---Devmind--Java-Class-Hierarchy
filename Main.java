import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        FortuneCookie f = FortuneCookie.generate();
        FortuneCookie f1 = FortuneCookie.generate();
        FortuneCookie f2 = FortuneCookie.generate();
        FortuneCookie g = FortuneCookie.generate();
        Candies c = Candies.generate();
        Candies c1 = Candies.generate();
        Candies c2 = Candies.generate();
        MinionToy m1 = MinionToy.generate();
        MinionToy m2 = MinionToy.generate();
        MinionToy m3 = MinionToy.generate();
        /*RandomOutBag r2 = new RandomOutBag();
        r2.put(g);
        r2.put(m1);
        RandomOutBag randomBag = new RandomOutBag();
        randomBag.put(f);
        randomBag.put(c);
        randomBag.put(m2);
        System.out.println("Lista initiala");
        for (int i = 0; i < randomBag.surprises.size(); i++) {
            randomBag.surprises.get(i).enjoy();
        }
        randomBag.put(r2);
        System.out.println("Lista finala");
        for (int i = 0; i < randomBag.surprises.size(); i++) {
            randomBag.surprises.get(i).enjoy();
        }
        LIFOBag lB = new LIFOBag();
        lB.put(m1);
        lB.put(m2);
        lB.put(m3);
        System.out.println("Lista initiala");
        for (int i = 0; i < lB.size(); i++) {
            lB.surprises.get(i).enjoy();
        }
        lB.takeOut();
        System.out.println("Lista finala");
        for (int i = 0; i < lB.size(); i++) {
            lB.surprises.get(i).enjoy();
        }
        FIFOBag fb = new FIFOBag();
        fb.put(m1);
        fb.put(m2);
        fb.put(m3);
        System.out.println("Lista initiala");
        for (int i = 0; i < fb.size(); i++) {
            fb.surprises.get(i).enjoy();
        }
        fb.takeOut();
        System.out.println("lista finala");
        for (int i = 0; i < fb.size(); i++) {
            fb.surprises.get(i).enjoy();
        }
    */
      /*  GatherSurprises gs = GatherSurprises.getInstance();
        GatherSurprises gs1 = GatherSurprises.getInstance();
        ISurprise [] as = GatherSurprises.gather(5);
        for(int i = 0; i < as.length;i++){
            as[i].enjoy();
        } */

        GiveSurpriseAndHug hg = new GiveSurpriseAndHug("FIFO", 2);
        hg.bag.put(c);
        hg.bag.put(c1);
        System.out.println("Bag hg " + (hg.bag.isEmpty() ? "is empty" : "is not empty"));
        GiveSurpriseAndSing hs = new GiveSurpriseAndSing("RANDOM", 2);
        hs.bag.put(m1);
        hs.bag.put(m2);
        hs.bag.put(m3);
        hg.bag.put(hs.bag);
        hg.bag.takeOut();
        hg.giveAll();
        GiveSurpriseAndApplause ha = new GiveSurpriseAndApplause("LIFO", 1);
        ha.bag.put(hg.bag);
        ha.bag.put(hs.bag);
        ha.giveAll();
        System.out.println(ha.bag.isEmpty());
        System.out.println(hg.bag.isEmpty());

        ISurprise[] newG = GatherSurprises.gather(25);
        for (int i = 0; i < newG.length/2; i++) {
            newG[i].enjoy();
            ha.bag.put(newG[i]);
        }
        for(int i = newG.length/2;i < newG.length; i++){
            newG[i].enjoy();
            hs.put(newG[i]);
        }
        System.out.println("-----------");
        ha.giveAll();
        hs.giveAll();

    }
}

