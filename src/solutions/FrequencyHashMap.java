package src.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FrequencyHashMap implements Solution {
    @Override
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> occurrences = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length != tChars.length) {
            return false;
        }
        for(char c : sChars){
            if(occurrences.containsKey(c)){
                occurrences.replace(c, occurrences.get(c) + 1 );
            } else {
                occurrences.put(c, 1);
            }
        }
        for(char c : tChars){
            if(occurrences.containsKey(c)){
                occurrences.replace(c, occurrences.get(c) - 1 );
            } else {
                return false;
            }
        }
        return occurrences.values().stream().allMatch( i -> i == 0);
    }
}
