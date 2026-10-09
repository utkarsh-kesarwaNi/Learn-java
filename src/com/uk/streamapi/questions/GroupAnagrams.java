package com.uk.streamapi.questions;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    /*
     *  Given an array of strings, write a program to group the anagrams together. You are required to implement the solution utilizing the Java 8 Streams API
     * Input: str = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    static void main() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagramsUsingStream(strs));
    }

    static List<List<String>> groupAnagramsUsingStream(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] charArray = s.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                })).values().stream().toList();
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = Arrays.toString(charArray);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /*
    * +-----------+-------------------------+
      | Key       | Value (List<String>)    |
      +-----------+-------------------------+
      | "aet"     | ["eat", "tea", "ate"]   |
      | "ant"     | ["tan", "nat"]          |
      | "abt"     | ["bat"]                 |
      +-----------+-------------------------+
      *
      * if 2 strings are anagrams of each other, their sorted versions will be equal
    */
}
