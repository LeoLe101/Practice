package src.Leetcode.Companies.Amazon;

import java.util.List;

public class OAAmazonFreshDeliveries {

    /**
     * Given a list of N possible delivery destinations, implement an algo create
     * the delivery plan for the closest X destinations
     * 
     * Space ()
     * 
     * Time ()
     */
    public static List<List<Integer>> deliveryPlan(List<List<Integer>> allocations, int numDeliveries) {

    }

}

/**
 * In order to keep track of the Closest delivery location, we will need to use a Priority Queue (as a Min Heap).
 * The Priority Queue will use the Comparator to compare the distance between A to the origin and B to the origin coordinate.
 * The calculation in the comparator is a[0]^2 + a[1]^2 - b[0]^2 - b[1]^2 to find the difference between distance A and B:
 *  - value > 0 : A > B 
 *  - value < 0 : A < B 
 *  - value = 0 : A = B (return the closer coordinate according to X)
 * 
 * Once we have the Priority Queue, add all the locations from the list given into the Priority Queue to keep the distance to origin sorted.
 * 
 * The Heap is ordered by the distance between every coordinate to the distance by popping the number of deliveries N given
 * Check if the result is empty in case the Priority Queue is empty (because locations given is empty), return an empty array with an empty location.
 *  
 * Space: O(N) 
 * Time: O(N Log N) because adding a new location to the Priority Queue, it takes O(N Log N) to pop the closest distance to the top of the queue
 * 
 */