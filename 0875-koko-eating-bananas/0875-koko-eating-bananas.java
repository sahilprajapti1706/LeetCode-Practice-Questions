class Solution {

    static boolean isValidEatingSpeed(int[] piles, int h, int speed){
        int hours = 0;
        for(int pile: piles){
            // hours += (pile + speed -1)/speed;
            hours += Math.ceil((double) pile/speed);
        }

        if(hours<= h){
            return true;
        }
        return false;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        // We need the slowest speed
        // Slowest speed tb hogi max. no of banana wale pile ko 1 hrs pe khmt kre
        int slowestSpeed = 0;
        for(int pile: piles){
            slowestSpeed = Math.max(slowestSpeed, pile);
        }
        
        // Slowest speed: 1 banana/hr isliye
        // ans range : total banana present
        int s = 1;
        int e = slowestSpeed;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;
           

            if(isValidEatingSpeed(piles, h, mid)){
                ans = mid;
                e = mid -1;

            }else{
                s = mid +1;
            }
        }

        return ans;
    }
}