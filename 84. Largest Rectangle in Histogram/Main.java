class Solution {
    public int largestRectangleArea(int[] heights) {
        // next smaller element left
        // array to store left boundary
        int[] lb = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        // leftmost element dont have nsel so default is -1
        st.push(0);
        lb[0] = -1;
        for(int i=1; i<heights.length; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                lb[i] = -1;
            }else {
                lb[i] = st.peek();
            }
            st.push(i);
        }
        
        // next smaller element right
        // array to store right boundary
        int[] rb = new int[heights.length];
        st = new Stack<>();
        // rightmost element dont have nser so default is length of heights
        st.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        for(int i=heights.length - 2; i>=0; i--) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                rb[i] = heights.length;
            }else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
    
        // area
        int maxArea = 0;
        for(int i=0; i<heights.length; i++) {
            int width = rb[i] - lb[i] -1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area) ;
        }
        return maxArea;
    }
}