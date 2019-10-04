import java.util.ArrayList;
import java.util.List;

public class Solution {

    // #region Reverse LL (Both Iter and Recur)
    public ListNode reverseLLIter(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (head != null) {
            head = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        head = prev;
        return head;
    }

    public ListNode reverseLLRec(ListNode head) {
        return reverseLLRecHelper(head, null);
    }

    public ListNode reverseLLRecHelper(ListNode head, ListNode currNode) {
        if (head == null)
            return currNode;
        ListNode next = head.next;
        head.next = currNode;
        return reverseLLRecHelper(next, head);
    }
    // #endregion

    // #region C = a * a + b * b
    // NOT OPTIMIZED --> given C, find whether or not there are 2 square
    // number that can be sum together to recreate C. (C = a * a + b * b)
    public boolean judgeSquareSumNO(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }

    // OPTIMIZED
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
    // #endregion

    // #region 125. Valid Palindrome -- Leetcode Easy --
    /**
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     * 
     * Note: For the purpose of this problem, we define empty string as valid
     * palindrome.
     * 
     * -----> this method might takes lots of time when the string is freaking big
     * (500 chars in a string)
     */
    public boolean isPalindrome(String str) {
        int size = str.length();
        List<Character> charact = new ArrayList<Character>();
        for (int i = 0; i < size; i++) {
            if (Character.isLetter(str.charAt(i))) {
                charact.add(str.toLowerCase().charAt(i));
            } else if (Character.isDigit(str.charAt(i))) {
                charact.add(str.toLowerCase().charAt(i));
            }
        }
        int arrSize = charact.size();
        for (int i = 0; i < arrSize; i++) {
            if (charact.get(i) != charact.get(arrSize - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Optimization with 2 pointers
     */
    public boolean isPalindromeOP(String s) {
        if (s.length() == 0 || s.equals(" ")) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));

            if (left != right) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    // #endregion

    // #region 2. Add Two Numbers -- Leetcode Medium --
    /**
     * Definition for singly-linked list.
     * 
     * public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;
        int val = 0;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            head.next = new ListNode(val);
            head = head.next;
        }
        while (l1 != null && l2 == null) {
            val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;

            l1 = l1.next;
            head.next = new ListNode(val);
            head = head.next;
        }
        while (l1 == null && l2 != null) {
            val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            head.next = new ListNode(val);
            head = head.next;
        }
        if (carry == 1 && l1 == null && l2 == null) {
            head.next = new ListNode(carry);
            head = head.next;
        }
        return res.next;
    }
    // #endregion

    // #region 46. Permutations -- Leetcode Medium --
    /**
     * https://leetcode.com/problems/permutations/ 
     * Given a collection of distinct
     * integers, return all possible permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
        return result;
    }
    // #endregion

    // #region 957. Prison Cells After N Days -- Leetcode Medium --
    /**
     * https://leetcode.com/problems/prison-cells-after-n-days/
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        while (N != 0) {
            int[] ncell = new int[cells.length];
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    ncell[0] = 0;
                    continue;
                }
                if (i == (cells.length - 1)) {
                    ncell[i] = 0;
                    continue;
                }
                if (i > 0) {
                    if (cells[i - 1] == cells[i + 1]) {
                        ncell[i] = 1;
                    } else {
                        ncell[i] = 0;
                    }
                }
            }
            cells = Arrays.copyOf(ncell, cells.length);
            N--;
        }
        return cells;
    }

    public int[] prisonAfterNDaysOptimized(int[] cells, int N) {
        int[] cellsCopy = new int[8];
        System.arraycopy(cells, 0, cellsCopy, 0, 8);

        // since everything repeats from 15th day (i.e day15 = day1). But also day14,
        // day28, etc does not equal day 0. So, did a little tweak on limit.
        int limit = (N != 0 && N % 14 == 0) ? 14 : (N % 14);

        for (int step = 0; step < limit; step++) {
            for (int i = 1; i <= 6; i++) {
                if (cells[i - 1] == cells[i + 1])
                    cellsCopy[i] = 1;
                else
                    cellsCopy[i] = 0;
            }
            if (step == 0) {
                cellsCopy[0] = cellsCopy[7] = 0;
            }
            System.arraycopy(cellsCopy, 0, cells, 0, 8);
        }
        return cellsCopy;
    }
    // #endregion

    // #region Two Sum and return the 2 indices of those to meet the Target
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                int val = nums[i] + nums[k];
                if (val == target) {
                    result[0] = i;
                    result[1] = k;
                    return result;
                }
            }
        }
        return result;
    }
    // #endregion

}

