package SeptemberChallenges;

/*
September 9

Question: Compare Version Numbers
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/
*/

class September9 {
    static class Version {
        String str;
        int pointer;

        Version(String str) {
            this.str = str;
            this.pointer = 0;
        }

        boolean hasNext() {
            return pointer < str.length();
        }

        int getNext() {
            StringBuilder sb = new StringBuilder();
            while ((pointer < str.length()) && (str.charAt(pointer) != '.')) {
                sb.append(str.charAt(pointer));
                pointer++;
            }
            pointer++;
            return Integer.parseInt(sb.toString());
        }
    }

    public int compareVersion(String version1, String version2) {
        Version v1 = new Version(version1);
        Version v2 = new Version(version2);

        while ((v1.hasNext()) && (v2.hasNext())) {
            int next1 = v1.getNext();
            int next2 = v2.getNext();
            if (next1 > next2)
                return 1;
            else if (next1 < next2)
                return -1;
        }
        while (v1.hasNext()) {
            if (v1.getNext() != 0)
                return 1;
        }
        while (v2.hasNext()) {
            if (v2.getNext() != 0)
                return -1;
        }

        return 0;
    }
}
