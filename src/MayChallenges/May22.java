package MayChallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
May 22

Question: Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
*/

class May22 {
    static class Alphabet {
        char letter;
        int count;

        Alphabet(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayList<Alphabet> alphabets = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (hashMap.containsKey(letter)) hashMap.put(letter, hashMap.get(letter) + 1);
            else hashMap.put(letter, 1);
        }

        for(Map.Entry element: hashMap.entrySet())
            alphabets.add(new Alphabet((char) element.getKey(), (int) element.getValue()));

        alphabets.sort((o1, o2) -> {
            if (o1.count != o2.count) return o2.count - o1.count;
            else return Character.toString(o1.letter).compareTo(Character.toString(o2.letter));
        });

        for (Alphabet alphabet : alphabets) {
            for (int i = 0; i < alphabet.count; i++)
                builder.append(alphabet.letter);
        }

        return builder.toString();
    }
}