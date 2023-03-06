// для испоавления нарушенного принципа наследования
// классы велосипеда и машины унаследуем от общего предка
public class Vehicle {
    // наследники в своих собственных методах не используют данные поля
    private String modelName;
    private int wheelCount;

    public Vehicle(String modelName, int wheelCount) {
        this.modelName = modelName;
        this.wheelCount = wheelCount;
    }

    public String getModelName() {
        return modelName;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void updateTyre() {
        System.out.println("Меняем покрышку");
    }
}
