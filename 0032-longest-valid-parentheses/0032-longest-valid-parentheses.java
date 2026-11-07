class Solution {
    public int longestValidParentheses(String s) {

        Deque<Integer> st = new ArrayDeque<>();

        st.push(-1);
        int maxLen = 0;

        for(int i=0;i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();

                if(st.isEmpty()){
                    st.push(i);
                }else{
                    int currLen = i - st.peek();
                    maxLen = Math.max(maxLen, currLen);
                }
            }
        }
         return maxLen;
    }
   
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna