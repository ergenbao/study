package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author JH
 * 输入一个整数数组，把数组里的数进行排序，打印能拼接出最小的数
 **/
public class PrintMinNumber {

    public static String printMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] ar = {"4","2","3","4","1","6","9"};
        Arrays.sort(ar,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c2.compareTo(c1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s :ar) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }


}
