class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a,b) -> a[1] - b[1]);

            int maxLen = 0;
            int currEnd = Integer.MIN_VALUE;
            for(int[] pair : pairs) {
                if(pair[0] > currEnd) {
                    currEnd = pair[1];
                    maxLen++;
                }
            }

            return maxLen;
        }
    }