class Solution {

    public int canEatInTime(int piles[], int h) {
        int start = 1;
        int end = findmax(piles);

        while (start < end) {
            int mid = start + (end - start) / 2;
            int totalh = calculatetotalhour(piles, mid);

            if (totalh <= h) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    int calculatetotalhour(int piles[], int h) {
        int totalh = 0;
        int n = piles.length;

        for (int i = 0; i < n; i++) {
            totalh += Math.ceil((double) piles[i] / (double) h);
        }

        return totalh;
    }

    int findmax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }

        return maxi;
    }

    public int minEatingSpeed(int[] piles, int h) {
        return canEatInTime(piles, h);
    }
}
