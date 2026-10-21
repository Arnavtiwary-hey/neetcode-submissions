class Solution {
    public boolean isPalindrome(String s) {
       
        int i = 0;
        int j =s.length()-1;
        while(j >= i){
          char m = Character.toLowerCase(s.charAt(i));
          char n = Character.toLowerCase(s.charAt(j));
              if (!Character.isLetterOrDigit(m)) {
                i++;
                continue;
            }

          
            if (!Character.isLetterOrDigit(n)) {
                j--;
                continue;
            } if (m != n) {
                return false;
            }

            i++;
            j--;
        }
        return true;

    }
}
