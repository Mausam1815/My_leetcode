/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeak(mountainArr, 0, n - 1, n);

        int ascendingResult = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (ascendingResult != -1) {
            return ascendingResult;
        }

        int descendingResult = binarySearch(mountainArr, target, peakIndex, n - 1, false);
        return descendingResult;
    }
    public int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                if (isAscending) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (isAscending) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public int findPeak(MountainArray mountainArr, int left, int right, int n) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid + 1);
            if (midVal < nextVal) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}