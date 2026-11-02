class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch=='a' || ch=='b'){
                st.push(ch);
            }
            else{
                if(st.size()<2){
                    return false;
                }

                if(st.peek() !='b'){
                    return false;
                }
                st.pop();
                if(st.peek() !='a'){
                    return false;
                }
                st.pop();
            }
        }

        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna