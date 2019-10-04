#include <stdio.h>
#include <iostream>
#include <vector>
#include <iterator>
#include <map>
#include <set>
#include <stack>

#define FAILED -1
#define ERROR false
#define FOUND true

using namespace std;

typedef pair<int, int> Pair;
vector<int> twoSum1(vector<int> &nums, int target);
vector<int> twoSum2(vector<int> &nums, int target);
int maxProfit1(vector<int> &prices);
int maxProfit2(vector<int> &prices);
int findSSE(int arr[], int size);
bool containsDuplicate1(vector<int> &nums);
bool containsDuplicate2(vector<int> &nums);
vector<int> productExceptSelf1(vector<int> &nums);
vector<int> productExceptSelf2(vector<int> &nums);
int maxSubArray1(vector<int> &nums);
int maxSubArray2(vector<int> &nums);
string reverseStringInQuote(string str);
int maxProduct(vector<int> &nums);
int binarySearchRecursive(vector<int> &nums, int value, int lowerBound, int upperBound);
int binarySearchIterative(vector<int> &nums, int value);

int main()
{
    // cout << "-------Two Sum-------" << endl;
    // {
    //     vector<int> arr;
    //     arr.push_back(1);
    //     arr.push_back(6);
    //     arr.push_back(2);
    //     arr.push_back(8);
    //     arr.push_back(7);
    //     arr.push_back(3);
    //     vector<int> indices = twoSum1(arr, 5);
    //     int result = 0;
    //     for (int i = 0; i < indices.size(); i++)
    //     {
    //         result += arr[indices[i]];
    //         cout << "Index: " << indices[i] << endl;
    //     }
    //     cout << "Indices result: " << result << endl
    //          << endl;
    // }

    // cout << "-------Second Smallest Element-------" << endl;
    // {
    //     int arr1[5] = {9, 1, 23, 81, 111};
    //     cout << "Array1 [9, 19, 2, 10, 1]" << endl;
    //     cout << "Second smaller elm of arr1: " << findSSE(arr1, 5) << endl; // no array.length in c++ only: (sizeof(arr1)/sizeof(*arr1))

    //     int arr2[5] = {811, 1249, 312, 150, 21};
    //     cout << "Array2 [81, 129, 32, 10, 2]" << endl;
    //     cout << "Second smaller elm of arr2: " << findSSE(arr2, 5) << endl
    //          << endl;
    // }

    // cout << "-------Contains Duplicate-------" << endl;
    // {
    //     vector<int> arr3;
    //     arr3.push_back(9);
    //     arr3.push_back(1);
    //     arr3.push_back(23);
    //     arr3.push_back(81);
    //     arr3.push_back(1);
    //     arr3.push_back(9);
    //     cout << "Array3 [9, 1, 23, 81, 1, 9]" << endl;
    //     cout << "Does Array3 contains duplicate? " << containsDuplicate2(arr3) << endl;

    //     vector<int> arr4;
    //     arr4.push_back(9);
    //     arr4.push_back(15);
    //     arr4.push_back(23);
    //     arr4.push_back(81);
    //     arr4.push_back(1);
    //     arr4.push_back(62);
    //     cout << "Array4 [9, 15, 23, 81, 1, 62]" << endl;
    //     cout << "Does Array4 contains duplicate? " << containsDuplicate2(arr4) << endl
    //          << endl;
    // }

    // cout << "-------Maximum SubArray-------" << endl;
    // {
    //     vector<int> arr5;
    //     arr5.push_back(-2);
    //     arr5.push_back(1);
    //     arr5.push_back(-3);
    //     arr5.push_back(4);
    //     arr5.push_back(-1);
    //     arr5.push_back(2);
    //     arr5.push_back(1);
    //     arr5.push_back(-5);
    //     arr5.push_back(4);
    //     cout << "Array5 [-2,1,-3,4,-1,2,1,-5,4]" << endl;
    //     cout << "Greatest Sum of subarray: " << maxSubArray1(arr5) << endl
    //          << endl;
    // }

    // cout << "-------Maximum SubArray-------" << endl;
    // {
    //     string a = "AB(CDE)FGHIJK";
    //     reverseStringInQuote(a);
    // }

    cout << "-------Binary Search Iterative-------" << endl;
    {
        vector<int> bsi_array;
        bsi_array.push_back(1);
        bsi_array.push_back(2);
        bsi_array.push_back(3);
        bsi_array.push_back(4);
        bsi_array.push_back(5);
        bsi_array.push_back(6);
        bsi_array.push_back(7);
        bsi_array.push_back(8);
        cout << "Binary Search Iter for (6): " << binarySearchIterative(bsi_array, 6) << endl;
        cout << "Binary Search Iter for (88): " << binarySearchIterative(bsi_array, 88) << endl;
    }

    cout << "-------Binary Search Recursive-------" << endl;
    {
        vector<int> bsr_array;
        bsr_array.push_back(1);
        bsr_array.push_back(2);
        bsr_array.push_back(3);
        bsr_array.push_back(4);
        bsr_array.push_back(5);
        bsr_array.push_back(6);
        bsr_array.push_back(7);
        bsr_array.push_back(8);
        cout << "Binary Search Recur for (6): " << binarySearchRecursive(bsr_array, 6, 0, bsr_array.size() - 1) << endl;
        cout << "Binary Search Recur for (88): " << binarySearchRecursive(bsr_array, 88, 0, bsr_array.size() - 1) << endl;
    }
}

/**
 * -- TWO SUM --- LET CODE
 * -- https://leetcode.com/problems/two-sum/
 * This is not a good way to do this problem as it is using 2 nested loops
 */
vector<int> twoSum1(vector<int> &nums, int target)
{
    vector<int> indices;
    vector<int> res;
    for (int i = 0; i < nums.size(); ++i)
    {
        res.push_back(target - nums[i]);
    }

    for (int i = 0; i < res.size(); ++i)
    {
        for (int j = 0; j < nums.size(); ++j)
        {
            if ((nums[j] == res[i]) && (i != j))
            {
                indices.push_back(i);
                indices.push_back(j);
                return indices;
            }
        }
    }
    return indices;
}

/**
 * -- TWO SUM --- LET CODE
 * -- https://leetcode.com/problems/two-sum/
 * This is a good one. 1 loop O(n) using map or pair
 */
vector<int> twoSum2(vector<int> &nums, int target)
{
    vector<int> indices;
    map<int, int> pair;

    for (int i = 0; i < nums.size(); i++)
    {
        pair.insert(Pair(i, nums[i]));
        if (pair.find(target - nums[i]) != pair.end())
        {
            indices.push_back(pair.at(target - nums[i]));
            indices.push_back(i);
        }
    }
    return indices;
}

/**
 * -- BEST TIME TO BUY AND SELL STOCK
 * -- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * This solution will work for [7, 1, 3, 2, 6, 5] but won't for [2, 4, 1]
 * as the minBuy is 1, there will be no higher price to sell after that.
 * Still, the answer for this is 2 which is minBuy = 2 and maxSell = 4.
 */
int maxProfit1(vector<int> &prices)
{
    int maxSell = -9999999;
    int minBuy = 99999999;
    int buyIndex = 0;
    if (prices.size() == 0)
        return 0;

    for (int i = 0; i < prices.size(); i++)
    {
        if (minBuy < prices[i])
        {
            minBuy = prices[i];
            buyIndex = i;
        }
    }

    for (int i = buyIndex; i < prices.size(); i++)
    {
        if (maxSell > prices[i])
        {
            maxSell = prices[i];
        }
    }

    int profit = maxSell - minBuy;
    return profit;
}

/**
 * -- BEST TIME TO BUY AND SELL STOCK
 * -- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * This is the correct version which iterate backward and check if there are
 * any big sell point first, and find the low buy point later
 */
int maxProfit2(vector<int> &prices)
{
    int maxSell = 0;
    int minBuy = 0;
    int buyIndex = prices.size() - 2;
    int sellIndex = prices.size() - 1;
    int profit = 0;
    int result = 0;

    if (prices.size() == 0)
        return 0;

    while (sellIndex >= 1 && buyIndex >= 0)
    {
        maxSell = prices[sellIndex];
        minBuy = prices[buyIndex];
        result = maxSell - minBuy;
        // only move index when the buy index val is bigger then current sell
        // (which mean a prospective higher selling point)
        if (result < 0)
        {
            sellIndex = buyIndex;
        }
        // Only get the best profit
        else if (result > profit)
        {
            profit = result;
        }
        buyIndex--;
    }
    return profit;
}

/**
 * -- FIND THE SECOND SMALLEST VALUE IN THE ARRAY
 */
int findSSE(int arr[], int size)
{
    if (size == 0)
    {
        return -1;
    }

    int smallest = INT16_MAX;
    int smaller = INT16_MAX;
    for (int i = 0; i < size; i++)
    {
        if (arr[i] < smallest)
        {
            smaller = smallest;
            smallest = arr[i];
        }

        if (arr[i] > smallest && arr[i] < smaller)
        {
            smaller = arr[i];
        }
    }
    return smaller;
}

/**
 * -- CONTAINS DUPLICATE
 * -- https://leetcode.com/problems/contains-duplicate/
 * This solution is not good, but it does work.
 * Time complexity too much
 */
bool containsDuplicate1(vector<int> &nums)
{
    int size = nums.size();
    if (size == 0)
    {
        return ERROR;
    }

    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            if (nums[i] == nums[j])
            {
                return FOUND;
            }
        }
    }
    return ERROR;
}

/**
 * -- CONTAINS DUPLICATE
 * -- https://leetcode.com/problems/contains-duplicate/
 * This is a better solution with better time complexity
 * The Set and Map are 2 different things!
 */
bool containsDuplicate2(vector<int> &nums)
{
    int size = nums.size();
    set<int> curr; // we use set here to not involve with cases like [3, 3] or [3, 1]
    if (size == 0)
    {
        return ERROR;
    }

    for (int i = 0; i < size; i++)
    {
        if (curr.find(nums[i]) != curr.end())
        {
            return FOUND;
        }
        curr.insert(nums[i]);
    }
    return ERROR;
}

/**
 * -- PRODUCT EXCEPT SELF
 * -- https://leetcode.com/problems/product-of-array-except-self/
 */
// vector<int> productExceptSelf1(vector<int> &nums)
// {
//     // NOT IMPLEMENTED YET!
// }

/**
 * -- MAXIMUM SUBARRAY
 * -- https://leetcode.com/problems/maximum-subarray/
 * This is usable, but not very effecient.
 * This will help with memory distribution, not run-time
 */
int maxSubArray1(vector<int> &nums)
{
    int result = INT16_MIN;
    int currIndex = 0;
    int size = nums.size();

    if (size == 1)
    {
        return nums[0];
    }
    else if (size == 0)
    {
        return 0;
    }
    for (int i = 0; i < size; i++)
    {
        int sol = nums[i];
        for (int j = i + 1; j < size; j++)
        {
            if (sol > result)
            {
                result = sol;
            }
            sol += nums[j];
        }
        if (sol > result)
        {
            result = sol;
        }
    }
    return result;
}

/**
 * -- MAXIMUM SUBARRAY
 * -- https://leetcode.com/problems/maximum-subarray/
 * This is usable, but not very effecient.
 * This will help with memory distribution, not run-time
 * ----**** See Kadene's Algorithm ****----
 */
int maxSubArray2(vector<int> &nums)
{
    int result = INT16_MIN;
    int sol = nums[0];
    int currIndex = 0;
    int size = nums.size();

    if (size == 1)
    {
        return nums[0];
    }
    else if (size == 0)
    {
        return 0;
    }
    for (int i = 1; i < size; i++)
    {
        if (sol > 0)
        {
            sol += nums[i];
        }
        else
        {
            sol = nums[i];
        }

        if (result < sol)
        {
            result = sol;
        }
    }
    return result;
}

/**
 * -- MAXIMUM SUBARRAY
 * -- https://leetcode.com/problems/maximum-subarray/
 * Given a string of word. If there is a quote "(__)"
 * The character in the middle will be reversed
 * Ex: ABXG(AWE)GADIFN ----> ABXG_EWA_GADIFN
 * Ex: ABXG(AWASFE)GADIFN ----> ABXG_EFSAWA_GADIFN
 * Ex: AB(AWA(SFE))GADIFN ----> ABXG_SFEAWA_GADIFN .. Swap twice
 * Use stack to reverse the string in quote.
 */
// string reverseStringInQuote(string str)
// {
//     stack<char> reverseString;
//     string result = "";
//     bool flag = ERROR;
//     for (int i = 0; i < str.length(); i++)
//     {
//         if (str[i] == '(')
//         {
//             flag = FOUND;
//         }
//         if (flag)
//         {
//             reverseString.push(str[i]);
//             cout << "char: " << str[i] << endl;
//         }
//     }
// }

/**
 * -- MAXIMUM PRODUCT OF SUBARRAY
 * -- https://leetcode.com/problems/maximum-product-subarray/
 */
int maxProduct(vector<int> &nums)
{
    int size = nums.size();
    if (size == 1)
    {
        return nums[0];
    }
    if (size == 0)
    {
        return 0;
    }

    int result = 0;
    int sol = nums[0];
    for (int i = 1; i < size; i++)
    {
        if (sol < 0)
            sol = nums[i];
        else
            sol *= nums[i];
        if (result < sol)
        {
            result = sol;
        }
    }
    return result;
}

/**
 * -- BINARY SEARCH RECURSIVELY
 * -- https://rosettacode.org/wiki/Binary_search
 * The algorithm will keep on splitting the array at the middle
 * and compare whether or not it is smaller or larger than the 
 * value to be found. If it is larger, shift the LOWER_BOUND up
 * to the right side of current middle value. Else, do the opposite.
 * Repeat these steps until the value to be found is the middle value.
 * If not, return not found.
 */
int binarySearchRecursive(vector<int> &nums, int value, int lower_bound, int upper_bound)
{
    if (lower_bound > upper_bound)
    {
        return FAILED;
    }

    int mid = (lower_bound + upper_bound) / 2;
    if (nums[mid] < value)
    {
        lower_bound = mid + 1;
        return binarySearchRecursive(nums, value, lower_bound, upper_bound);
    }
    if (nums[mid] > value)
    {
        upper_bound = mid - 1;
        return binarySearchRecursive(nums, value, lower_bound, upper_bound);
    }
    return mid;
}

/**
 * -- BINARY SEARCH ITERATIVELY
 * -- https://rosettacode.org/wiki/Binary_search
 * The algorithm will keep on splitting the array at the middle
 * and compare whether or not it is smaller or larger than the 
 * value to be found. If it is larger, shift the LOWER_BOUND up
 * to the right side of current middle value. Else, do the opposite.
 * Repeat these steps until the value to be found is the middle value.
 * If not, return not found.
 */
int binarySearchIterative(vector<int> &nums, int value)
{
    if (nums.size() == 0)
    {
        return FAILED;
    }

    int mid = 0;
    int lower_bound = 0;
    int upper_bound = nums.size() - 1;
    while (lower_bound <= upper_bound)
    {
        // mid = (lower_bound + upper_bound) / 2; // Might cause overflow for some programming language
        // mid = lower_bound + (upper_bound - lower_bound) / 2; // One way to fix the problem above using math
        mid = (lower_bound + upper_bound) >> 1;               // another way to fix the problem above using logical right shift operator. This will work for both unsigned and signed number

        if (nums[mid] < value)
        {
            lower_bound = mid + 1;
        }
        else if (nums[mid] > value)
        {
            upper_bound = mid - 1;
        }
        else
        {
            return mid;
        }
    }
    return FAILED;
}