import java.util.Random;

public class Hogwarts {
    private final static Random rand = new Random();
    private static GryffindorStudent potter =
            new GryffindorStudent("Harry Potter", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static GryffindorStudent granger =
            new GryffindorStudent("Hermione Granger", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static GryffindorStudent weasley =
            new GryffindorStudent("Ron Weasley", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static SlytherinStudent malfoy =
            new SlytherinStudent("Draco Malfoy", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100));
    private static SlytherinStudent montague =
            new SlytherinStudent("Graham Montague", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100));
    private static SlytherinStudent goyle =
            new SlytherinStudent("Gregory Goyle", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100));
    private static HufflepuffStudent smith =
            new HufflepuffStudent("Zachary Smith", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static HufflepuffStudent finch =
            new HufflepuffStudent("Justin Finch-Fletchley", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static HufflepuffStudent diggory =
            new HufflepuffStudent("Cedric Diggory", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static RavenclawStrudent chang =
            new RavenclawStrudent("Cho Chang", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static RavenclawStrudent patil =
            new RavenclawStrudent("Padma Patil", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
    private static RavenclawStrudent belby =
            new RavenclawStrudent("Marcus Belby", rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));

    public static void main(String[] args) {
        System.out.println(granger.compare(weasley));
        System.out.println(diggory.compare(chang));
        System.out.println("================================");
        System.out.println(malfoy.compare(smith));
        System.out.println(malfoy.compare(goyle));
    }
}
