package AugustChallenges;

/*
August 28

Question: Implement Rand10() Using Rand7()
Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
Do NOT use system's Math.random().

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3439/
*/

class August28 {
    public int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public int rand10() {
        int result = 40;
        while (result >= 40)
            result = 7 * (rand7() - 1) + (rand7() - 1);
        return result % 10 + 1;
    }
}
