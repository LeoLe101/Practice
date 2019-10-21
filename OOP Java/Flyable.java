/**
 * In Java, INTERFACE can be implemented multiple times! Classes or Abstract
 * classes can only be extended/inherited once!
 *
 * The Interface is just a list of blank/abstract methods that will required to
 * be implemented once it is implemented by other classes
 *
 * Methods in an interface will be abstract class by default, so there is no
 * reason to use the Abstract modifier
 */
public interface Flyable {

    /**
     * Attributes can be initialized in an interface class These can be anything
     * including final, public, static
     *
     * Cannot have a private here since interface does not have any method to get to
     * these private
     */
    public final int id = 0;
    public int test = 0;

    // This method itself is similar to the abstract method
    // in the abstract class and will required to be implemented.
    public void fly();

    public String getSomething();
}