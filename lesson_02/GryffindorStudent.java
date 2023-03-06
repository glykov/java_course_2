public class GryffindorStudent extends Student {
    private int nobilityScore;
    private int honorScore;
    private int braveryScore;

    public GryffindorStudent(String name, int magicScore, int transgressionScore, int nobilityScore, int honorScore, int braveryScore) {
        super(name, magicScore, transgressionScore);
        this.nobilityScore = nobilityScore;
        this.honorScore = honorScore;
        this.braveryScore = braveryScore;
    }

    public int getNobilityScore() {
        return nobilityScore;
    }

    public void setNobilityScore(int nobilityScore) {
        this.nobilityScore = nobilityScore;
    }

    public int getHonorScore() {
        return honorScore;
    }

    public void setHonorScore(int honorScore) {
        this.honorScore = honorScore;
    }

    public int getBraveryScore() {
        return braveryScore;
    }

    public void setBraveryScore(int braveryScore) {
        this.braveryScore = braveryScore;
    }

    public int getFacultyScore() {
        return nobilityScore + honorScore + braveryScore;
    }

    public String compare(Student other) {
        if (this.getClass() != other.getClass()) {
            return super.compare(other);
        } else {
            GryffindorStudent o = (GryffindorStudent) other;
            return (this.getFacultyScore() > o.getFacultyScore() ? this.getName() : o.getName()) +
                    " is better Gryffindor student than " +
                    (this.getFacultyScore() < o.getFacultyScore() ? this.getName() : o.getName());
        }
    }

    @Override
    public String toString() {
        return super.getName() +
                " has magic = " + super.getMagicScore() +
                ", transgression = " + super.getTransgressionScore() +
                ", nobility = " + nobilityScore +
                ", honor = " + honorScore +
                ", bravery =" + braveryScore;
    }
}
