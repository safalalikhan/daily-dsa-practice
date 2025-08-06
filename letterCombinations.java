import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(res, new StringBuilder(), digits, 0, map);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, String digits, int idx, String[] map) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            backtrack(res, sb, digits, idx + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
