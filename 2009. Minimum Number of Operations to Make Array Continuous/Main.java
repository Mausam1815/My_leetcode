class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int[] newNums = new int[set.size()];
        int idx = 0;
        for(int num : set) {
            newNums[idx++] = num;
        }

        Arrays.sort(newNums);
        
        int end = 0;
        int max = Integer.MIN_VALUE;
        for(int st = 0; st<newNums.length; st++) {
            while(end < newNums.length && newNums[end] < newNums[st] + n) {
                end++;
            }
            int count = end - st;
            max = Math.max(max, count);
        }
        return n - max;
    }
}