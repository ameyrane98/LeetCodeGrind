import java.util.ArrayList;

class Solution {
    ArrayList<String> allSubstrings = new ArrayList<>();
    
    public int countSubstrings(String s) {
        generateSubstrings(s, 0);
        
        int count = 0;
        for (String sub : allSubstrings) {
            if (isPalindrome(sub)) {
                count++;
            }
        }
        return count;
    }

    // Generate all substrings recursively
    public void generateSubstrings(String s, int start) {
        if (start == s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            allSubstrings.add(substring);
        }

        generateSubstrings(s, start + 1);
    }

    // Check if a string is a palindrome
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
