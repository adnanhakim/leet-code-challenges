package AugustChallenges;

import java.util.ArrayList;
import java.util.List;

/*
August 26

Question: Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/
*/

class August26 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0)
                    result.add("FizzBuzz");
                else result.add("Fizz");
            } else if (i % 5 == 0)
                result.add("Buzz");
            else result.add(String.valueOf(i));
        }

        return result;
    }
}
