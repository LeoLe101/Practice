public class MoveZeroes283 {

    private int[] _dutchArr = new int[] { 0, 1, 2, 1, 2, 0, 1, 0, 2, 1, 1, 2, 2 };

    // Addtional Dutch National Flag problem:
    // http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
    public void DutchNationFlag(int[] nums) {
        /**
         * 
         */ 
        
    }

    // 2 pointers move from left to right
    // Space (1) Time (N)
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            // Move right and left forward if both != 0
            if (nums[left] == nums[right] && nums[left] != 0) {
                right++;
                left++;
            }
            // Move right when both = 0
            else if (nums[left] == nums[right] && nums[left] == 0) {
                right++;
            }
            // Swap if left = 0 and right != 0
            else if (nums[left] != nums[right] && nums[left] == 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right++;
            }
            // Move both if both != 0
            else if (nums[left] != nums[right] && nums[left] == 0) {
                right++;
                left++;
            } else {
                right++;
            }
        }
    }

}
