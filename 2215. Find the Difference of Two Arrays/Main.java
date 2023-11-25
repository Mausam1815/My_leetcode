class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> ans1 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for(int num2 : nums2) {
            set1.add(num2);
        }
        for(int num1 : nums1) {
            if(!set1.contains(num1)) {
                ans1.add(num1);
            }
            set1.add(num1);
        }

        List<Integer> ans2 = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num1 : nums1) {
            set2.add(num1);
        }
        for(int num2 : nums2) {
            if(!set2.contains(num2)) {
                ans2.add(num2);
            }
            set2.add(num2);
        }
        result.add(ans1);
        result.add(ans2);
        return result;
    }
}