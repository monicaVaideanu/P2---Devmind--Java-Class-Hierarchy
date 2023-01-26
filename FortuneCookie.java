import java.util.Random;

public class FortuneCookie implements ISurprise {
    private String mesage;

    public FortuneCookie(String mesage) {
        this.mesage = mesage;
    }

    private final static String[] say = {"And into the forest I go, to lose my mind and find my soul.\" John Muir\"",
            "Vulnerability sounds like faith and looks like courage.\" Brenee Brown\"",
            "Do it scared.\" Ruth Soukup\"", "Little by little one travels far. \" J.R.R. Tolkien\"",
            "I can't go back to yesterday because I was different person then. \" Lewis Carroll\"",
            "She lives the poetry she cannot write.\" Oscar Wilde\"", "Don't let yesterday take up too much of today." +
            "\" Will Rogers\"", "I never dream about success.I worked for it.\" Estee Lauder\"",
            "If you want the rainbow, you gotta put up with the rain.\" Dolly Parton\"",
            "Loving yourself isn't vanity.It's sanity.\" Andre Gide\"", "Lead with love and kindness." +
            "\" Ashley Graham\"", "The most effective way to do it, is to do it.\" Amelia Earhart\"",
            "To the world, you're one person. But to one person, you're the world.\" Dr. Seus\"",
            "Fashion fades, only style remains the same.\" Coco Chanel\"", "Imagination creates reality." +
            "\" Richard Wagner\"", "Never break a promise to yourself.\" Rachel Hollis\"",
            "Your victory is right around the corner. Don't give up.\" Nicki Minaj\"",
            "Every year on your birthday you get a change to start new.\" Sammy Hager\"",
            "When in doubt, slay.\" Demi Lovato\"", "Happy people are beautiful.\" Drew Barrymore\""
    };

    @Override
    public void enjoy() {
        System.out.println(mesage);
    }

    public static FortuneCookie generate() {
        return new FortuneCookie(say[random.nextInt(say.length)]);
    }

}
