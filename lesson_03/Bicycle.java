// нарушен принцип инкапсуляции
// отсутсвует инициализация полей разумнвми значениями
public class Bicycle extends Vehicle{
    // перемещены в родительский класс 
    // private final String modelName;
    // private int wheelCount;

    public Bicycle(String modelName, int wheelCount) {
        super(modelName, wheelCount);
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