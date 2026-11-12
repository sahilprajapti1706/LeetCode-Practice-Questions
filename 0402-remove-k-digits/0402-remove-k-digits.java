class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch:num.toCharArray()){

            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        ans.reverse();

        int idx = 0;
        while(idx<ans.length() && ans.charAt(idx)=='0'){
            idx++;
        }

        String result = ans.substring(idx);
        
        if(result==""){
            return "0";
        }else{
            return result;
        }
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna