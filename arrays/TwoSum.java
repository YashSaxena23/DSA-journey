package arrays;

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

import java.util.*;

/*
Example:
Input: nums = [2,7,11,15], target = 13
Output: [0,2]
Explanation: Because nums[0] + nums[2] == 13, we return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 11, 18));
        System.out.println(Arrays.toString(targetSum(list, 13)));
    }

    private static int[] targetSum(List<Integer> nums, Integer target) {
        //two pointer will iterate thru the array 2 times
        //o(n2) not appropriate.
        //if set.contains(target - i) return [i, set.indexOf(target-i)
        for (int i = 0 ; i<nums.size() ; i++) {
            int valueToCheck = target - nums.get(i);
            if(nums.contains(valueToCheck)) {
                return new int[]{i, nums.indexOf(valueToCheck)};
            }
        }
        return new int[]{0,0};
    }

    //One way would be using Hashmap again.
    //key = the integer values in the list
    //value = the index at which they are present.
}
