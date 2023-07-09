class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
// another approach
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sts = new Stack<>();
        Stack<Character> stt = new Stack<>();
        sts = backspaceHelper(s, sts);
        stt = backspaceHelper(t, stt);

        if(sts.size() != stt.size()){
            return false;
        }
        while(!sts.isEmpty()){
            char c1 = sts.pop();
            char c2 = stt.pop();
            if(c1 != c2){
                return false;
            }
        }
        return true;
    }
    public Stack<Character> backspaceHelper(String str, Stack<Character> st){
        for(char c : str.toCharArray()){
            if(Character.isLetter(c)){
                st.push(c);
            }else if(c == '#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        return st;
    }
}