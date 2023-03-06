// для исправления нарушенного принципа полиморфизма
// перегрузим метод check
public class ServiceStation {
    // выполнить общие работы для всех транспортных средств 
    private void checkVehicle(Vehicle vehicle) {
        System.out.println("Обслуживаем " + vehicle.getModelName());
        for (int i = 0; i < vehicle.getWheelCount(); i++) {
            vehicle.updateTyre();
        }
    }

    public void check(Bicycle bicycle) {
        checkVehicle(bicycle);
    }

    public void check(Car car) {
        checkVehicle(car);
        car.checkEngine();
    }

    public void check(Truck truck) {
        checkVehicle(truck);
        truck.checkEngine();
        truck.checkTrailer();
    }
}
