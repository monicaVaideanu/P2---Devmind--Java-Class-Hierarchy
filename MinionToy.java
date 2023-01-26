import java.util.Random;

public class MinionToy implements ISurprise {
    private static int counter = 0;
    private final static String[] minionsName = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
    private String nameMinion;

    public MinionToy(String nameMinion) {
        this.nameMinion = nameMinion;
    }

    @Override
    public void enjoy() {
        System.out.println("Ati primit un minion pe nume : " + this.nameMinion);
    }

    public static MinionToy generate() {
        MinionToy minion = new MinionToy(minionsName[counter]);
        if (counter == minionsName.length - 1) {
            counter = 0;
        } else counter++;
        return minion;
    }
}
