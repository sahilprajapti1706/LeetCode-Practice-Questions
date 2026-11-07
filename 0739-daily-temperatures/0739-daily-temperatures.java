class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] ans = new int[n];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){

                int prevDay = st.pop();
                ans[prevDay] = i - prevDay;
            }
            st.push(i);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna