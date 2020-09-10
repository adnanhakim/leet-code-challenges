package SeptemberChallenges;

/*
September 10

Question: Bulls and Cows
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
Please note that both secret number and friend's guess may contain duplicate digits.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/
*/

class September10 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];

        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
