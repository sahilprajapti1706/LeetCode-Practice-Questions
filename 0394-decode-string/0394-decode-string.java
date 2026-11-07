class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int number = 0;
        StringBuilder curr = new StringBuilder();

        for(char ch: s.toCharArray() ){
            if(Character.isDigit(ch)){
                number = number*10 + (ch-'0');
            }
            else if(ch == '['){
                countStack.push(number);
                stringStack.push(curr);
                number = 0;
                curr = new StringBuilder();
            }
            else if(ch == ']'){
                int repeatCount = countStack.peek();
                countStack.pop();
                StringBuilder prev = stringStack.pop();

                while(repeatCount >= 1){
                    prev.append(curr);
                    repeatCount--;
                }
                curr = prev;
            }else{
                curr.append(ch);
            }
        }

        return curr.toString();



        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna