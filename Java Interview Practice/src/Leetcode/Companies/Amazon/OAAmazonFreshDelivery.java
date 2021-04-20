import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class OAAmazonFreshDelivery {

  /**
   * Space (N) - Use PQ and Result list Time (N) - Loop through the array to put
   * in PQ and loop thru numDeliveries
   */
  public List<List<Integer>> deliveryPlan(List<List<Integer>> allLocations, int numDeliveries) {
    List<List<Integer>> result = new List<>();

    Comparator<List<Integer>> checkDistance = new Comparator<>() {
      @Override
      public int compare(List<Integer> x, List<Integer> y) {
        // Compare the distance between x and y to original location [0,0]
        int value = x.get(0) * x.get(0) + x.get(1) * x.get(1) - y.get(0) * y.get(0) - y.get(1) * y.get(1);

        // Distance both x and y is the same, return closest X coordinate
        if (value == 0) {
          value = x.get(0) - y.get(0);
       }
        return value;
      }
    };

    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(checkDistance);

    for (List<Integer> location : allLocations) {
      pq.add(location);
    }

    for (int i = 0; i < numDeliveries; i++) {
      result.add(pq.poll());
    }

    if (result.size() == 0) {
      result.add(new List<>());
    }
    return result;
  }
}
