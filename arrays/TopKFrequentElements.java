package arrays;
/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order
 */

import java.util.*;

/*
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Top 2 most frequent elements
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequentElements(new int[]{4, 4, 4,3, 2, 2}, 2)));
    }

    //map -> [number, frequency]
    //k -> sort the map based on the values, and then return top k values.

    public static int[] frequentElements(int[] nums, int k){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();


        //map -> [number, frequency]
//        for (int i : nums) {
//            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) +1);
//        }

        //merge -> if key (i) is not present, puts value(1) as default
        // if key(i) is present, Integer::sum adds 1 to the value.
        for (int i : nums) {
            frequencyMap.merge(i , 1, Integer::sum);
        }

        //Create a List and put the number in desc order of their frequency
        List<Integer> sortedIntegers = new ArrayList<>(frequencyMap.keySet());
        sortedIntegers.sort(Comparator.comparingInt(frequencyMap::get).reversed()); // same as
        //sortedIntegers.sort((a,b) -> (frequencyMap.get(b) - frequencyMap.get(a))
        System.out.println(sortedIntegers);

        int[] result = new int[k];
        for (int i = 0; i< k; i++) {
            result[i] = sortedIntegers.get(i);
        }
        return  result;
    }
}
