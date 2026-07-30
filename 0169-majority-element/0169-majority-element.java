class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}