class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int totalCustomers = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                totalCustomers++;
            }
        }

        int currentPenalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') {
                currentPenalty++;
            }
        }

        int minPenalty = currentPenalty;
        int minClosingHour = 0;

        for (int closingHour = 1; closingHour <= n; closingHour++) {
            if (customers.charAt(closingHour - 1) == 'Y') {
                currentPenalty--;
            } else {
                currentPenalty++;
            }

            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                minClosingHour = closingHour;
            }
        }

        return minClosingHour;
    }
}