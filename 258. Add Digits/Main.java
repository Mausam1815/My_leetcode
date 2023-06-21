class Solution {
    public int addDigits(int num) {
        int singleDigitSum = num % 9;
        return (singleDigitSum == 0 && num != 0) ? 9 : singleDigitSum;
    }
}