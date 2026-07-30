class Solution {
    public int compress(char[] chars) {
        int readIdx = 0;
        int writeIdx = 0;
        

        while(readIdx<chars.length){
            char ch = chars[readIdx];
            readIdx++;
            int count = 1;

            while(readIdx<chars.length && chars[readIdx] == ch){
                readIdx++;
                count++;
            }

            chars[writeIdx] = ch;
            writeIdx++;

            if(count>1){
                String countStr = String.valueOf(count);
                
                for(char digit: countStr.toCharArray()){
                    chars[writeIdx] = digit;
                    writeIdx++;
                }
            }
        }
        return writeIdx;
    }
}