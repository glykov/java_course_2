public class HufflepuffStudent extends Student{
    private int hardworkScore;
    private int loyaltyScore;
    private int honestyScore;

    public HufflepuffStudent(String name, int magicScore, int transgressionScore, int hardworkScore, int loyaltyScore, int honestyScore) {
        super(name, magicScore, transgressionScore);
        this.hardworkScore = hardworkScore;
        this.loyaltyScore = loyaltyScore;
        this.honestyScore = honestyScore;
    }

    public int getHardworkScore() {
        return hardworkScore;
    }

    public void setHardworkScore(int hardworkScore) {
        this.hardworkScore = hardworkScore;
    }

    public int getLoyaltyScore() {
        return loyaltyScore;
    }

    public void setLoyaltyScore(int loyaltyScore) {
        this.loyaltyScore = loyaltyScore;
    }

    public int getHonestyScore() {
        return honestyScore;
    }

    public void setHonestyScore(int honestyScore) {
        this.honestyScore = honestyScore;
    }

    public int getFacultyScore() {
        return hardworkScore + loyaltyScore + honestyScore;
    }

    @Override
    public String compare(Student other) {
        if (this.getClass() != other.getClass()) {
            return super.compare(other);
        } else {
            HufflepuffStudent o = (HufflepuffStudent) other;
            return (this.getFacultyScore() > o.getFacultyScore() ? this.getName() : o.getName()) +
                    " is better Hufflepuff student than " +
                    (this.getFacultyScore() < o.getFacultyScore() ? this.getName() : o.getName());
        }
    }

    @Override
    public String toString() {
        return super.getName() +
                " has magic = " + super.getMagicScore() +
                ", transgression = " + super.getTransgressionScore() +
                ", hardwork  = " + hardworkScore +
                ", loyalty = " + loyaltyScore +
                ", honesty = " + honestyScore;
    }
}
