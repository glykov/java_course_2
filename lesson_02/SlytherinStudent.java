public class SlytherinStudent extends Student{
    private int cunningScore;
    private int determinationScore;
    private int ambitionScore;
    private int resourcefulnessScore;
    private int lustForPowerScore;

    public SlytherinStudent(String name, int magicScore, int transgressionScore, int cunningScore,
                            int determinationScore, int ambitionScore, int resourcefulnessScore, int lustForPowerScore) {
        super(name, magicScore, transgressionScore);
        this.cunningScore = cunningScore;
        this.determinationScore = determinationScore;
        this.ambitionScore = ambitionScore;
        this.resourcefulnessScore = resourcefulnessScore;
        this.lustForPowerScore = lustForPowerScore;
    }

    public int getCunningScore() {
        return cunningScore;
    }

    public void setCunningScore(int cunningScore) {
        this.cunningScore = cunningScore;
    }

    public int getDeterminationScore() {
        return determinationScore;
    }

    public void setDeterminationScore(int determinationScore) {
        this.determinationScore = determinationScore;
    }

    public int getAmbitionScore() {
        return ambitionScore;
    }

    public void setAmbitionScore(int ambitionScore) {
        this.ambitionScore = ambitionScore;
    }

    public int getResourcefulnessScore() {
        return resourcefulnessScore;
    }

    public void setResourcefulnessScore(int resourcefulnessScore) {
        this.resourcefulnessScore = resourcefulnessScore;
    }

    public int getLustForPowerScore() {
        return lustForPowerScore;
    }

    public void setLustForPowerScore(int lustForPowerScore) {
        this.lustForPowerScore = lustForPowerScore;
    }

    public int getFacultyScore() {
        return cunningScore + determinationScore + ambitionScore + resourcefulnessScore + lustForPowerScore;
    }

    @Override
    public String toString() {
        return super.getName() +
                " has magic = " + super.getMagicScore() +
                ", transgression = " + super.getTransgressionScore() +
                ", cunning = " + cunningScore +
                ", determination = " + determinationScore +
                ", ambition = " + ambitionScore +
                ", resourcefulness = " + resourcefulnessScore +
                ", lust for power = " + lustForPowerScore +
                '}';
    }
}
