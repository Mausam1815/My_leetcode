class Solution {
    public int[] sortArray(int[] nums) {
        sortArrayHelper(nums, 0, nums.length-1);
        return nums;
    }
    public void sortArrayHelper(int[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int mid = l+(r-l)/2;
        sortArrayHelper(arr, l, mid);
        sortArrayHelper(arr, mid+1, r);

        merge(arr, l, mid, r);
    }
    public void merge(int[] arr, int l, int mid, int r){
        int n = mid-l+1;
        int m = r-mid;

        int[] t1 = new int[n];
        int[] t2 = new int[m];
        for(int i=0;i<n;i++){
            t1[i] = arr[l+i];
        }
        for(int i=0;i<m;i++){
            t2[i] = arr[mid+1+i];
        }
        int i=0, j=0, k=l;
        while(i<n && j<m){
            if(t1[i] <= t2[j]){
                arr[k] = t1[i];
                i++;
            }else {
                arr[k] = t2[j];
                j++;
            }
            k++;
        }
        while(i < n){
            arr[k] = t1[i];
            i++;
            k++;
        }
        while(j < m){
            arr[k] = t2[j];
            j++;
            k++;
        }
    }
}