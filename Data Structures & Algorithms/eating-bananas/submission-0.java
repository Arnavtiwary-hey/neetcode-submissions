class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = piles[0];

        for(int i = 1;i<n;i++){
            right  = Math.max(right,piles[i]);
        }
        while(left <=right){
            int mid = left + (right-left)/2;
            long kokaeat = 0;
            for(int j = 0;j<n;j++){
                kokaeat += piles[j]/mid;
                if(piles[j] % mid !=0){
                    kokaeat++;
                }
            }
            if(kokaeat <= h){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
