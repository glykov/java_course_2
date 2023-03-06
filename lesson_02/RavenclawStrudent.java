public class RavenclawStrudent extends Student{
    private int midScore;
    private int wisdomScore;
    private int witScore;
    private int creativityScore;

    public RavenclawStrudent(String name, int magicScore, int transgressionScore, int midScore, int wisdomScore, int witScore, int creativityScore) {
        super(name, magicScore, transgressionScore);
        this.midScore = midScore;
        this.wisdomScore = wisdomScore;
        this.witScore = witScore;
        this.creativityScore = creativityScore;
    }

    public int getMidScore() {
        return midScore;
    }

    public void setMidScore(int midScore) {
        this.midScore = midScore;
    }

    public int getWisdomScore() {
        return wisdomScore;
    }

    public void setWisdomScore(int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }

    public int getWitScore() {
        return witScore;
    }

    public void setWitScore(int witScore) {
        this.witScore = witScore;
    }

    public int getCreativityScore() {
        return creativityScore;
    }

    public void setCreativityScore(int creativityScore) {
        this.creativityScore = creativityScore;
    }

    public int getFacultyScore() {
        return midScore + wisdomScore + witScore + creativityScore;
    }

    @Override
    public String compare(Student other) {
        if (this.getClass() != other.getClass()) {
            return super.compare(other);
        } else {
            RavenclawStrudent o = (RavenclawStrudent) other;
            return (this.getFacultyScore() > o.getFacultyScore() ? this.getName() : o.getName()) +
                    " is better Ravenclaw student than " +
                    (this.getFacultyScore() < o.getFacultyScore() ? this.getName() : o.getName());
        }
    }

    @Override
    public String toString() {
        return super.getName() +
                " has magic = " + super.getMagicScore() +
                ", transgression = " + super.getTransgressionScore() +
                ", mid = " + midScore +
                ", wisdom = " + wisdomScore +
                ", wit = " + witScore +
                ", creativity = " + creativityScore;
    }
}
