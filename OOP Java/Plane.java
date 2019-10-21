

public class Plane extends Vehicle {

    private int power;
    private boolean isFlyable;

    public Plane(String name, String model, String manufacture, int power, boolean isFlyable) {
        super(name, model, manufacture);
        this.power = power;
        this.isFlyable = isFlyable;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setIsECar(boolean isFlyable) {
        this.isFlyable = isFlyable;
    }

    public int getPower() {
        return this.power;
    }

    public boolean isFlyable() {
        return this.isFlyable;
    }

    public String getInfo() {
        return "This is Plane";
    }
}