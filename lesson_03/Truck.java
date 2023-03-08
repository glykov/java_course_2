// наследуем уже от класса Car
public class Truck extends Car{
    // перемещены в родительский класс 
    // public String modelName;
    // public int wheelsCount;

    public Truck(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    public void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }

    // перемещены в родительский класс
    // public String getModelName() {
    //     return modelName;
    // }

    // public int getWheelCount() {
    //     return wheelCount;
    // }

    // public void setWheelCount(int wheelCount) {
    //     this.wheelCount = wheelCount;
    // }

    // public void setModelName(String modelName) {
    //     this.modelName = modelName;
    // }

    // public void updateTyre() {
    //     System.out.println("Меняем покрышку");
    // }

    // public void checkEngine() {
    //     System.out.println("Проверяем двигатель");
    // }

}