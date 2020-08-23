import java.util.Map;

public class Easy198 {
   
    public static void main(String[] args) {
        
    }    

    public static int houserRobber(int[] nums) {

        if (nums.length <= 0) return 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result += nums[i];
            }
        }

        return result;
    }

    public int rob(int[] nums) {
        if (nums.length <= 0) 
            return 0;
        int result = 0;
        boolean isMore = true;
        int tempMax = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < nums.length; i++) {
           map.put(i, nums[i]); 
        }
        
        while (isMore) {
            tempMax = findMax(nums);
            map.put(map.get)
            if () {
                
            } else {
                map.put();
            }
            
        }

        return result;
    }
    
    public int findMax(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int num: nums) {
            result = Math.max(result, num);    
        }
        return result;
    }
}