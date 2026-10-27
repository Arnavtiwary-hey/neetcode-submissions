
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'A']++;

            while (true) {
                int maxFreq = 0;

                for (int count : freq) {
                    maxFreq = Math.max(maxFreq, count);
                }

                int windowLen = right - left + 1;
                int replacements = windowLen - maxFreq;

                if (replacements <= k) {
                    break;
                }

                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
