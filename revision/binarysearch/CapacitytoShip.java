package revision.binarysearch;

public class CapacitytoShip {
    public int shipWithinDays(int[] weights, int days) {
        long l = 0, r = 0;
        int n = weights.length;

        for (int i = 0; i < n; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }

        long ans = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (canShip(mid, weights, days)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return (int) ans;
    }

    private boolean canShip(long capacity, int[] weights, int days) {
        int day = 1;
        long sum = 0;

        for (int w : weights) {
            if (sum + w > capacity) {
                day++;
                sum = w;
            } else {
                sum += w;
            }
        }

        return day <= days;
    }
}
