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

    public static String compareStudents(Student first, Student second) {
        return first.getName() + " has " +
                (first.getMagicScore() > second.getMagicScore() ? "higher" : "less") +
                " magic power and " +
                (first.getTransgressionScore() > second.getTransgressionScore() ? "longer" : "shorter") +
                " transgression distance than " + second.getName();
    }

    public static String compareStudents(GryffindorStudent first, GryffindorStudent second) {
        return (first.getFacultyScore() > second.getFacultyScore() ? first.getName() : second.getName()) +
                " is better Gryffindor student than " +
                (first.getFacultyScore() < second.getFacultyScore() ? first.getName() : second.getName());
    }

    public static String compareStudents(RavenclawStrudent first, RavenclawStrudent second) {
        return (first.getFacultyScore() > second.getFacultyScore() ? first.getName() : second.getName()) +
                " is better Ravenclaw student than " +
                (first.getFacultyScore() < second.getFacultyScore() ? first.getName() : second.getName());
    }

    public static String compareStudents(HufflepuffStudent first, HufflepuffStudent second) {
        return (first.getFacultyScore() > second.getFacultyScore() ? first.getName() : second.getName()) +
                " is better Hufflepuff student than " +
                (first.getFacultyScore() < second.getFacultyScore() ? first.getName() : second.getName());
    }

    public static String compareStudents(SlytherinStudent first, SlytherinStudent second) {
        return (first.getFacultyScore() > second.getFacultyScore() ? first.getName() : second.getName()) +
                " is better Slytherin student than " +
                (first.getFacultyScore() < second.getFacultyScore() ? first.getName() : second.getName());
    }

    public static void main(String[] args) {
        System.out.println(compareStudents(granger, weasley));
        System.out.println(compareStudents(malfoy, smith));
    }
}
