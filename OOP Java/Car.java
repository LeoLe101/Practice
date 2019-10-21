public class Car extends Vehicle {

    private int power;
    private String owner;
    private boolean isECar;

    public Car(String name, String model, String manufacture, String owner, int power, boolean isECar) {
        super(name, model, manufacture);
        this.power = power;
        this.owner = owner;
        this.isECar = isECar;
    }

    public String getInfo() {
        return "This is a Car";
    }

}