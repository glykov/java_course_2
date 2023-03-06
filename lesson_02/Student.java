public class Student {
    private String name;
    private int magicScore;
    private int transgressionScore;

    public Student(String name, int magicScore, int transgressionScore) {
        this.name = name;
        this.magicScore = magicScore;
        this.transgressionScore = transgressionScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagicScore() {
        return magicScore;
    }

    public void setMagicScore(int magicScore) {
        this.magicScore = magicScore;
    }

    public int getTransgressionScore() {
        return transgressionScore;
    }

    public void setTransgressionScore(int transgressionScore) {
        this.transgressionScore = transgressionScore;
    }

    public int getStudentSocre() {
        return magicScore + transgressionScore;
    }

    public String compare(Student other) {
        return this.getName() + " has " +
                (this.getMagicScore() > other.getMagicScore() ? "higher" : "less") +
                " magic power and " +
                (this.getTransgressionScore() > other.getTransgressionScore() ? "longer" : "shorter") +
                " transgression distance than " + other.getName();
    }
}
