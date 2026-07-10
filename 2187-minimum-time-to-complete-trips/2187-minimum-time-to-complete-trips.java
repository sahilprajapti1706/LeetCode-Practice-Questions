class Solution {

    static boolean isValidTime(int[] time, int totalTrips, long tripTime){
        long tripMade = 0;
        for(int t : time){
            if(t<=tripTime){
                tripMade += tripTime/t;
            }
        }
        if(tripMade>=totalTrips){
            return true;
        }
        return false;
    }
    
    public long minimumTime(int[] time, int totalTrips) {
        // slowest speed bus (time[i] jika max hai)
        int minSpeed = 0;
        for(int t: time){
            minSpeed = Math.max(minSpeed, t);
        }

        long low = 1;
        long high = (long)minSpeed * totalTrips;
        long ans = -1;

        while(low<=high){
            long mid = low + (high-low)/2;

            if(isValidTime(time, totalTrips, mid)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
}