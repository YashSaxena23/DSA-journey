package arrays;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S.
 * The task is to find the length of the longest substring without repeating characters.
 *  Input: S = “abcabcbb”
 * Output: abc
 * Input:  S = “pwwkew”
 * Output: wke
 */
public class NonRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstring("pwwkew"));
    }


    public static String longestSubstring(String s) {

        //Approaches->
        /*
        1. So a simple way of doing this is going through each index position,
        and inserting the characters in StringBuilder/Set, until a repeating character is encountered.

        Let result = "" hold the longest substring;
        iterate through the string and for each index position, update a new String containing unique elements.
        If the newString.length > result.length, update result and give the answer.

        Time complexity -> o(n^2) as it will have to iterate through each element twice. Two for loops
         */

        /*
        2. Other way would be,
        Initialize a map,
        for each character of the string, make a key in map, and update the most recent occurrence index
        maintain a start index and max length variable, to store the possible combinations
         */
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int maxLength = 0;
        int actualStartIndex = 0;

        for (int i = 0; i< s.length(); i++) {
            char curr = s.charAt(i);

            if(map.containsKey(curr)) {
                // Move the start pointer to the right of the previous occurrence of the character
                startIndex = Math.max(map.get(curr) +1, startIndex);
            }
            //update the most recent index position of the char
            map.put(curr, i);

            //when we get a longer substring length , we go inside this if block
            //i-startIndex shows the max length
            //if it is true, we update the actual start index.
            if (i - startIndex + 1 > maxLength) {
                maxLength = i - startIndex + 1;
                actualStartIndex = startIndex;
            }
        }
        return s.substring(actualStartIndex, (actualStartIndex+maxLength));
    }
}
