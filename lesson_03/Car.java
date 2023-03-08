// нарушен принцип инкапсуляции
// отсутсвует инициализация полей разумнвми значениями
public class Car extends Vehicle {
    public Car(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    public void checkEngine() {
        System.out.println("Проверяем двигатель");
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
}
