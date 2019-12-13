package src;

import src.solutions.FrequencyHashMap;
import src.solutions.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] solutions =
                new Solution[]{
                        new FrequencyHashMap(),
                };

        // add test cases
        var input = new String[][]{
                new String[]{
                        "anagram", "nagaram"
                },
                new String[]{
                        "a", "a"
                },
                new String[]{
                        "", ""
                },
                new String[]{
                        "hydroxydeoxycorticosteroneshydroxydeoxycorticosteroneshydroxydeoxycorticosterones", "ydroxydeoxycorticosteroneshydroxydeoxycorticosteroneshydroxydeoxycorticosteronesh"
                },
                new String[]{
                        "aaaaa", "aaaa"
                },
                new String[]{
                        "rat", "car"
                },
                new String[]{
                        "anagrama", "nagaram"
                },
                new String[]{
                        "anagram", "nagarama"
                }
        };

        boolean result;
        int errors = 0;
        int nTestCases = input.length;
        var output = Arrays.asList(true, true, true, true, false, false, false, false);

        assert(output.size() == nTestCases);

        for (Solution s : solutions) {
            for (int i = 0; i < nTestCases; i++) {

                result = s.isAnagram(input[i][0], input[i][1]);

                if( !result == output.get(i)) {
                    System.out.println("Solution " + s.getClass().getCanonicalName() + " wrong for input " + Arrays.toString(input[i]));
                    System.out.println("Expected: " + output.get(i) + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(nTestCases - errors + " tests passed.");
        }
        System.out.println(errors + " tests failed.");
        System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
    }
}

