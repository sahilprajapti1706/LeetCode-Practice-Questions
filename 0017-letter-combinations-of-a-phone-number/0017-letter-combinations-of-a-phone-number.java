class Solution {

    static void solveLetterCombination(List<String> result, String digits,String[] mapping, StringBuilder output, int idx ){
        if(idx >= digits.length()){
            result.add(output.toString());
            return;
        }
        int digit = digits.charAt(idx) - '0';
        String mappedString = mapping[digit];

        for(int i = 0 ;i<mappedString.length();i++){
            output.append(mappedString.charAt(i));
            solveLetterCombination(result,digits, mapping, output, idx+1);
            output.deleteCharAt(output.length()-1);
        }

    }
    
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        int idx = 0;
        StringBuilder output = new StringBuilder();
        solveLetterCombination(result, digits, mapping, output, idx);
        return result;
    }
}