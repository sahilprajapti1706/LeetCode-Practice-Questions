class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(s==e){
                return nums[s];
            }

            int currVal = nums[mid];
            int prevVal = -1;
            int nextVal = -1;

            if(mid-1 >= 0){
                prevVal = nums[mid-1];
            }

            if(mid+1 <= n){
                nextVal = nums[mid+1];
            }

            if(currVal != prevVal && currVal != nextVal){
                return currVal;
            }

            if(currVal != prevVal && currVal == nextVal){
                int startingIdxOfPair = mid;
                
                // If odd
                if((startingIdxOfPair & 1) ==1){
                    e = mid -1;
                }
                else{
                    // even
                    s = mid + 1;
                }
            }
            else if(currVal == prevVal && currVal != nextVal){
                int endingIdxOfPair = mid;
                
                // If odd
                if((endingIdxOfPair & 1) ==1){
                    s = mid + 1;
                }
                else{
                    // even
                    e = mid - 1;
                }
            }

        }
        return -1;
    }
}