package AugustChallenges;

/*
August 17

Question: Distribute Candies to People
We distribute some number of candies, to a row of n = num_people people in the following way:
We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
Return an array (of length num_people and sum candies) that represents the final distribution of candies.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3427/
*/

class August17 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];

        int count = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies == 0) break;
                if (count <= candies) {
                    arr[i] += count;
                    candies -= count;
                    count++;
                } else {
                    arr[i] += candies;
                    candies = 0;
                    break;
                }
            }
        }

        return arr;
    }
}
