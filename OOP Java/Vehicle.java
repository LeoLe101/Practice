

public class Vehicle {

    private String name;
    private String model;
    private String manufacture;
    private int year;
    private static int currentAmount = 0;

    public Vehicle() {
        currentAmount++;
    }

    public Vehicle(String name, String model, String manufacture) {
        this.name = name;
        this.model = model;
        this.manufacture = manufacture;
        currentAmount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getModel() {
        return this.model;
    }

    public String getManufacture() {
        return this.manufacture;
    }

    public int getYear() {
        return this.year;
    }

    public String getInfo() {
        return "This is a Vehicle";
    }
}