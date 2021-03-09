package src.Util;

public class FrequentElement {
    public int key;
    public int frequent;

    public FrequentElement() {
        key = Integer.MIN_VALUE;
        frequent = Integer.MIN_VALUE;
    }

    public FrequentElement(int key, int freq) {
        this.frequent = freq;
        this.key = key;
    }
}
