package arrays;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("eat","tea","tan","ate","nat","bat"));
        System.out.println(groupOfAnagrams(list));
    }

    /*
    One approach is, use a map to store the words as values and keys would be a sorted word.
     */
    public static List<List<String>> groupOfAnagrams(List<String> list) {

        HashMap<String, List<String>> anagramsMap = new HashMap<>();

        //now iterate over the list, sort the value, and then put the sorted value as key
        //if key already present, append to the list which is the value of that key.

        for (String word : list) {

            //sorting ways
            char[] charArray = word.toLowerCase().toCharArray();
            Arrays.sort(charArray);
            String sortedWord = String.valueOf(charArray);

            if(!anagramsMap.containsKey(sortedWord)) {
                anagramsMap.put(sortedWord, new ArrayList<>());
            }

            anagramsMap.get(sortedWord).add(word);
        }
        return new ArrayList<>(anagramsMap.values());

    }
}
