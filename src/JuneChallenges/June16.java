package JuneChallenges;

/*
June 15

Question: Validate IP Address
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
Note: You may assume there is no extra space or special characters in the input string.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
*/

import java.util.regex.Pattern;

class June16 {
    // Solution 1 - Regex (Time - 7ms)
    public String validIPAddressRegex(String IP) {
        Pattern IPv4Pattern = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$");
        Pattern IPv6Pattern = Pattern.compile("^(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})$");

        if (IPv4Pattern.matcher(IP).matches()) return "IPv4";
        return (IPv6Pattern.matcher(IP).matches()) ? "IPv6" : "Neither";
    }

    // Solution 2 - If/Else Checks (Time - 1ms)
    public String validIPAddress(String IP) {
        int count = 0;

        if (!IP.contains(":")) {    // Check for IPv4
            for (String p : IP.split("\\.")) {
                count++;
                if (count > 4 || p.isEmpty() || p.length() > 3 || (p.length() > 1 && p.charAt(0) == '0'))
                    return "Neither";

                for (char c : p.toCharArray())
                    if (!Character.isDigit(c))
                        return "Neither";

                int val = Integer.parseInt(p);

                if (val < 0 || val > 255)
                    return "Neither";
            }

            return count == 4 && IP.charAt(IP.length() - 1) != '.' ? "IPv4" : "Neither";
        } else {    // Check for IPv6
            for (String p : IP.split(":")) {
                count++;
                if (count > 8 || p.isEmpty() || p.length() > 4)
                    return "Neither";

                for (char c : p.toCharArray())
                    if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F'))
                        return "Neither";
            }

            return count == 8 && IP.charAt(IP.length() - 1) != ':' ? "IPv6" : "Neither";
        }
    }
}
