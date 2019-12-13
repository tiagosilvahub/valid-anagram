# valid-anagram
Given two strings s and t , write a function to determine if t is an anagram of s.

https://leetcode.com/problems/valid-anagram/

Example 1:
```
Input: s = "anagram", t = "nagaram"
Output: true
```
Example 2:
```
Input: s = "rat", t = "car"
Output: false
```
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

O(n) solution

```
boolean isAnagram(String s, String t) {
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
```
