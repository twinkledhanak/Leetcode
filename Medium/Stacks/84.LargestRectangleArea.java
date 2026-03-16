class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // Monotonic stack, store indices [same as previous problems]
        // Monotnic increasing, min element at the start
        Stack<Integer> stack = new Stack<>(); 
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use 0 at the end to force pop all remaining bars
            //During the normal loop, we only pop bars from the stack when a lower bar comes. 
            //But what about the bars that never have a smaller bar after them?
            //	•	When i == n, we treat it as if there’s a bar of height 0 after the histogram.
	        //  •	This ensures that all remaining bars in the stack get popped at the end.
            //	•	Its only purpose is to trigger the final popping of all remaining bars in the stack.
	        //  •	It does not affect the real bars because height 0 will always be smaller than any real bar.

            int h = (i == n) ? 0 : heights[i]; // for last bar, use 0

            // some logic while popping
            while (!stack.isEmpty() && h < heights[stack.peek()]) {

                int height = heights[stack.pop()];
                // width = current index - index of previous smaller - 1
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;


                maxArea = Math.max(maxArea, height * width);
            }

            // Push
            stack.push(i);
        }

        return maxArea;
    }
}