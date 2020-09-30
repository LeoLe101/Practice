import javax.xml.namespace.QName;

public class ReverseInteger7 {

    public int reverse(int x) {
        int result = 0;
        int ln = 0;
        while (x > 1) {
            ln = x % 10;
            x = x / 10;
        }
        result = ln;
        return result;
    }
    
}
