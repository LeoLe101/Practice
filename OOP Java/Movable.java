/**
 * The abstract class can be extended/inherited by other children classes
 * However, it cannot be initialized by any class (no new Movable())
 * Children classes must override the methods with the abstract modifier.
 *
 * If this is just a normal class that is extended/inherited by another
 * children classes, the class itself can be initialized.
 * Children classes can override the parent class or leave it as is.
 */
public abstract class Movable {

    // Attributes/Properties in an Abstract class
    // May contain non-final variables
    private boolean isMovable;
    private String weight;

    public Movable(boolean isMovable, String weight) {
        this.isMovable = isMovable;
        this.weight = weight;
    }

    public void move() {
        System.out.println("Moving this movable object!");
    }

    public void fly() {
        System.out.println("Flying this movable object!");
    }

    // Because this is an abstract method, we
    // have to make the whole class abstract as well.
    public abstract void crash();
}