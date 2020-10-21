import java.util.*;

class ParkingPermit {

    // REQUIRED
    private String make;
    private String model;
    private String licensePlate;

    // OPTIONAL
    private String year;
    private String VIN;
    private String color;
    private String owner;

    public ParkingPermit(String make, String model, String lic, String year, String vin, String color, String owner) {
        this.make = isNullOrEmpty(make) ? make : null;
        this.model = isNullOrEmpty(model) ? model : null;
        this.licensePlate = isNullOrEmpty(lic) ? lic : null;
        this.year = isNullOrEmpty(year) ? year : null;
        this.VIN = isNullOrEmpty(vin) ? vin : null;
        this.color = isNullOrEmpty(color) ? color : null;
        this.owner = isNullOrEmpty(owner) ? owner : null;
    }

    private static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final ParkingPermit permit = (ParkingPermit) obj;

        if (this.make != permit.make)
            return false;
        if (this.mode != permit.model)
            return false;
        if (this.licensePlate != permit.licensePlate)
            return false;
        if (isNullOrEmpty(permit.year) && isNullOrEmpty(this.year) && this.year.equals(year))
            return false;
        if (isNullOrEmpty(permit.VIN) && isNullOrEmpty(this.VIN) && this.VIN.equals(permit.VIN))
            return false;
        if (isNullOrEmpty(permit.color) && isNullOrEmpty(this.color) && this.color.equals(permit.color))
            return false;
        if (isNullOrEmpty(permit.owner) && isNullOrEmpty(this.owner) && this.owner.equals(permit.owner))
            return false;

        //
        return true;
    }

}

public class Test {

    public static void main(String[] args) {
        ParkingPermit p = new ParkingPermit("make", "model", "lic", "year", "vin", "color", "owner");
        ParkingPermit p2 = new ParkingPermit("make", "model", "lic", "year", "vin", "color", "owner");
        ParkingPermit p3 = new ParkingPermit("make1", "model2", "lic", "year", "vin", "color", "owner");
        
        System.out.println("p == p2: " + p.equals(p2));
        System.out.println("p == p3: " + p.equals(p3));
    } 
}
