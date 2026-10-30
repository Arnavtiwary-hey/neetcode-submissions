
class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];
        int[] windfreq = new int[128];

        // Step 1: Store frequency of T
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq[ch]++;
        }

        int left = 0;
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            windfreq[ch]++;

            // Step 3: Check if this character is required
            if (freq[ch] > 0 && windfreq[ch] <= freq[ch]) {
                matched++;
            }

            // Step 4: Window is valid
            while (matched == t.length()) {

                // Update minimum window
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                // Step 5: Shrink window
                char leftChar = s.charAt(left);

                windfreq[leftChar]--;

                if (freq[leftChar] > 0 &&
                    windfreq[leftChar] < freq[leftChar]) {
                    matched--;
                }

                left++;
            }
        }

        // Step 6: Return answer
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
