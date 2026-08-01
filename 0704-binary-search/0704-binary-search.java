class Solution {

    static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
           int mid = start + end-start/2;

           if(target == nums[mid]){
            return mid;
           }else if(target < nums[mid]){
            end = mid -1;
           }else{
            start = mid + 1;
           }
        }

        return -1;

    }

    static int binarySearchRecursive(int s, int e, int[] nums, int target){
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearchRecursive(s, mid - 1, nums, target);
        } else {
            return binarySearchRecursive(mid + 1, e, nums, target);
        }
    }
    
    public int search(int[] nums, int target) {
    //    return binarySearch(nums, target);
     return binarySearchRecursive(0, nums.length-1, nums, target);
    }
}