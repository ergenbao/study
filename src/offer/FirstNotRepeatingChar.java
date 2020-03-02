package offer;

import java.util.LinkedHashMap;

/**
 * @Author JH
 * 在一个字符串中，找出第一个只出现一次的字符，并返回他的位置
 **/
public class FirstNotRepeatingChar {


    public static int firstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) {
            return -1;
        }
        char[] arr = str.toCharArray();
        LinkedHashMap<Character,Integer> map  = new LinkedHashMap<Character,Integer>();
        for (char c :arr){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for (int i=0;i<arr.length;i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String s ="abcdefabcde";
        System.out.println(firstNotRepeatingChar(s));
    }


}
