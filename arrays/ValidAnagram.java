package arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isValidAnagram("anagram", "namaarg"));
        System.out.println(isValidAnagram("India","IIndia"));
        System.out.println(isValidAnagram("India","india"));
        System.out.println(isValidAnagram("India","indii"));
    }

    /*
    1.s = yash, t = ashy
    step 1 -> put all the values of  s in a hash set.
    step 2 -> check t.contains().
    problem.
    s = yaash, t = ashy
    the frequency sd also match.
    s -> populate map
    t -> de-populate map
     */
    private static boolean isValidAnagram(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toLowerCase().toCharArray()) {
            //if the key is not present, or the value of key is equal to zero, because if value is zero,
            // then further reduction in frequency means not anagram
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
