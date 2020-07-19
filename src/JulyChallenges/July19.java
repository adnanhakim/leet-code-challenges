package JulyChallenges;

/*
July 19

Question: Add Binary
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
*/


class July19 {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty())
            return "";
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder builder = new StringBuilder();
        for (; i >= 0 && j >= 0; i--, j--) {
            int digitA = Character.getNumericValue(a.charAt(i));
            int digitB = Character.getNumericValue(b.charAt(j));

            if (digitA == 1 && digitB == 1) {
                if (carry == 1) builder.append(1);
                else builder.append(0);
                carry = 1;
            } else if ((digitA == 1 && digitB == 0) || (digitA == 0 && digitB == 1)) {
                if (carry == 1) {
                    builder.append(0);
                    carry = 1;
                } else {
                    builder.append(1);
                    carry = 0;
                }
            } else {
                builder.append(carry);
                carry = 0;
            }
        }

        while (i >= 0) {
            int digit = Character.getNumericValue(a.charAt(i));
            if (digit == 1 && carry == 1) {
                builder.append(0);
                carry = 1;
            } else if (digit == 1 || carry == 1) {
                builder.append(1);
                carry = 0;
            } else {
                builder.append(0);
                carry = 0;
            }
            i--;
        }

        while (j >= 0) {
            int digit = Character.getNumericValue(b.charAt(j));
            if (digit == 1 && carry == 1) {
                builder.append(0);
                carry = 1;
            } else if (digit == 1 || carry == 1) {
                builder.append(1);
                carry = 0;
            } else {
                builder.append(0);
                carry = 0;
            }
            j--;
        }

        if (carry == 1) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }
}
