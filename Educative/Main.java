import java.util.*;

public class Main {

   public static void main(String[] args) {
    // System.out.println("hello Worlds~!!!");
       SlidingWindow sw = new SlidingWindow();
       System.out.print("Ans: " + sw.OPT_AverageContigousSubArr(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}));
   } 

}