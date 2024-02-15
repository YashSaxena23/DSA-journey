package arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */

/**
 in questions like these
 if i try iterating on list 2 times -> O(n2)
 sort and then check -> O(nlogn)
 hashing. use a hash map.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(checkDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(checkDuplicateUsingMap(new int[]{1,2,3,4,1,5,3}));
    }

    /**
     * the time c would be O(n).
     */
    public static boolean checkDuplicate(int[] input) {
        HashSet<Integer> h = new HashSet<>();
        for (int i : input){
            if(h.contains(i)){
                return true;
            }
            h.add(i);
        }
        return false;
    }

    /**
     * This wd also have T.C as O(n).
     * however this would provide more info like telling the frequency of repeated ints.
     */
    public static boolean checkDuplicateUsingMap(int[] input) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i : input) {
            if (h.containsKey(i) && h.get(i) > 1) {
                return true;
            }
            h.put(i, h.getOrDefault(i, 1) + 1);
        }
        return false;
    }
}
