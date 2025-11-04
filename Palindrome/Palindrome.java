public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }
            // Case insensitive comparison
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}