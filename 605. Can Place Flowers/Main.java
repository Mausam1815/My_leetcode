class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        int i = 0;

        while(i < len) {
            if(flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i-1];
                int next = (i == len-1) ? 0 : flowerbed[i+1];

                if(prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            i++;
        }

        return count >= n;
    }
}