class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int element : batteries) {
            sum += element;
        }
        long stTime = 0;
        long endTime = sum;
        long ans = 0;

        while(stTime <= endTime) {
            long avgTime = (stTime + endTime) / 2;
            if(isPossible(n, batteries, avgTime)) {
                ans = avgTime;
                stTime = avgTime + 1;
            }else {
                endTime = avgTime - 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int n, int[] batteries, long avgTime) {
        long dur = 0;
        for(int element : batteries) {
            if(element < avgTime) {
                dur += element;
            }else {
                dur += avgTime;
            }
        }
        return dur >= avgTime * n;
    }
}