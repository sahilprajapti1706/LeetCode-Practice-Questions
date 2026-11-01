class Solution {
    public boolean isValid(String s) {

        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if (st.isEmpty()) {
                    return false;
                }

                if (ch == ')' && st.peek() == '(' ||
                    ch == '}' && st.peek() == '{' ||
                    ch == ']' && st.peek() == '[') {

                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna