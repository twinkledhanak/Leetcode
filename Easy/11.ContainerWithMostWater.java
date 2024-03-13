class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int a = 0, b = n-1;
        long maxVal = Integer.MIN_VALUE;

        while(a<b){
            long area = (b-a) * Math.min(height[a],height[b]);
            maxVal = Math.max(maxVal,area);

            if(height[a]<height[b])
                a++;
            else
                b--;
               
        }

        return (int)maxVal;

    }
}
