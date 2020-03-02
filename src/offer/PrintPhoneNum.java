package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JH
 **/
public class PrintPhoneNum {

    private static final char[][] MAP = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String str) {
        List<String> ret = new ArrayList<>();

        if (str == null || str.length() == 0) {
            return ret;
        }

        char[] tmp = new char[str.length()];
        letterCombinations(str, 0, tmp, ret);
        return ret;
    }

    private void letterCombinations(String str, int index, char[] tmp,
                                    List<String> ret) {
        if (index >= str.length()) {
            ret.add(new String(tmp));
            return;
        }

        char d = str.charAt(index);
        if (d < '2' || d > '9') {
            throw new IllegalArgumentException();
        }

        char[] arr = MAP[(int) (d - '2')];
        for (char c : arr) {
            tmp[index] = c;
            letterCombinations(str, index + 1, tmp, ret);
        }
    }
}
