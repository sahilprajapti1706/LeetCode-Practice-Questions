class Solution {

    static boolean isPossible(int[] weights, int days, int capacity) {

        int reqDays = 1;
        int totalWt = 0;
        
        for(int i =0;i<weights.length;i++){

            if(totalWt + weights[i]<= capacity){
                totalWt += weights[i];
            }else{
                reqDays++;
                totalWt = weights[i];
            }
        }
        if(reqDays<=days){
            return true;
        }
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;   
        int high = 0;  
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}