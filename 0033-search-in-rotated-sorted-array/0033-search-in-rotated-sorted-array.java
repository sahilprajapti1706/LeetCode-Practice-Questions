class Solution {

    static int pivotIndex(int[] nums){
        int s = 0;
        int e = nums.length -1;
        int n = nums.length -1;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(nums[mid] <= nums[n]){
                // yani mai right wale ascending part me hu, 
                // left part me chlo
                e = mid - 1;
            }else{
                // yani left part me hu
                // iss part me pivot mil skta hai
                // abhi ke liye possible ans mid hai 
                ans = mid;
                
                // but aage check krna pdega
                s = mid+1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = start +(end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivotIndex = pivotIndex(nums);
        int leftStart = 0;
        int leftEnd = pivotIndex;

        int rightStart = pivotIndex + 1;
        int rightEnd = nums.length-1;

        if(pivotIndex == -1){
            return binarySearch(nums, leftStart, rightEnd, target);
        }

        if(target >= nums[leftStart] && target <= nums[leftEnd]){

            return binarySearch(nums,leftStart, leftEnd,target);

        }else{

            return binarySearch(nums,rightStart, rightEnd,target);

        }
    }
}