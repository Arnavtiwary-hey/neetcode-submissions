
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < k; i++) {
            char ch = s2.charAt(i);
            windowFreq[ch - 'a']++;
        }

        if (matches(freq, windowFreq)) {
            return true;
        }

        for (int i = k; i < s2.length(); i++) {
            windowFreq[s2.charAt(i - k) - 'a']--;
            windowFreq[s2.charAt(i) - 'a']++;

            if (matches(freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
