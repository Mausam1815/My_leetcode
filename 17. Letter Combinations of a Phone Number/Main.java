class Solution {
        String[] letters = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        generateCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }
    public void generateCombinations(String digits, int idx, StringBuilder sb, List<String> result) {
        if(idx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String lettersCombinations = letters[digit - '0'];

        for(int i=0; i<lettersCombinations.length(); i++) {
            sb.append(lettersCombinations.charAt(i));
            generateCombinations(digits, idx+1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}