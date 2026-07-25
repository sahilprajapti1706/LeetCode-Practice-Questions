class Solution {

    static boolean compareFreq(int[] count1, int[] count2){
        for(int i=0;i<26;i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int count1[] = new int[26];
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            int idx = ch - 'a';
            count1[idx]++;
        }

        int i = 0;
        int windowLength = s1.length();
        int count2[] = new int[26];

        for( i=0;i<windowLength;i++){
            char ch = s2.charAt(i);
            int idx = ch - 'a';
            count2[idx]++;
        }

        if(compareFreq(count1, count2)){
            return true;
        }else{
            while(i<s2.length()){
                char newChar = s2.charAt(i);
                int newCharIdx = newChar - 'a';
                count2[newCharIdx]++;

                int oldCharIdx = i - windowLength;
                char oldChar = s2.charAt(oldCharIdx);
                int idxOfOldChar = oldChar - 'a';
                count2[idxOfOldChar]--;

                 if(compareFreq(count1, count2)){
                        return true;
                }
                i++;
            }
        }
        return false;

    }
}