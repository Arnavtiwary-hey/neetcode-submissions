class Solution {
    public int maxArea(int[] heights) {
          int i = 0;
        int n = heights.length;
        int j = n-1;
        int maxArea = 0;

        while(i < j){
            int width = j - i;
            int minHeight = Math.min(heights[i],heights[j]);
            int waterlevel = width*minHeight;

            maxArea = Math.max(maxArea,waterlevel);
            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
