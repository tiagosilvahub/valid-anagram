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

O(n * log(n)) solution. Sort the strings, iterate over them to confirm they are equal.

O(n) solution, iterate over each string. Count the occurance of each character on the first strings, check that there are the same number of occurances in the second strings. 

Exit earlier if the strings don't have the same size.

If there are only ASCII characters, we can use a vector and use the characters integer value. 

To support unicode, we can use an HashMap of Characters instead. The complexity is the same for either, with vectors being slight faster but still constant time. 


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
