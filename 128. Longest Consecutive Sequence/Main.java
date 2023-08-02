class Solution {
    public int longestConsecutive(int[] nums) {
        // if array is empty return 0
        if(nums.length == 0) {
            return 0;
        }
        // hashset for storing unique elements
        Set<Integer> set = new HashSet<>();
        // add all unique elements to set
        for(int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for(int num : nums) {
            // if the current element is starting element -> num-1 will not be present in set
            // then check the max length of the sequence
            if(!set.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;
                while(set.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }
                // update max length
                maxLen = Math.max(maxLen, currLen);
            }
        }
        // return max length
        return maxLen;
    }
}