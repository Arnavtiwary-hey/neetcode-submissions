class Solution {
    public int[] twoSum(int[] numbers, int target) {
          int i =0;
        int j = numbers.length-1;
    while(i<j){
        int m = numbers[i]+numbers[j];
        if(m > target){
            j--;
        }else if(m <  target){
            i++;
        }else{
            return new int[]{i+1,j+1};
        }
    }
    return new int[]{-1,-1};
    }
}
