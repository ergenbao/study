package offer;


import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author JH
 * 输入一个字符串，按字典顺序打印出该字符串中字符的所有排列顺序
 * 将当前位置的字符和前一个字符位置交换，递归。
 **/
public class Permutation {
    public static void permutation(String str) {
        char[] charArray = str.toCharArray();
        TreeSet<String> set = new TreeSet<String>();
        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        permutation(charArray,set,index);
        list.addAll(set);
    }
    public static void permutation(char[] charArray,TreeSet<String> set ,int index) {
        if(charArray == null || charArray.length==0) {
            return;
        }
        if(charArray.length < 0 || index > charArray.length -1) {
            return;
        }
        if(index == charArray.length -1) {
            set.add(String.valueOf(charArray));
        }else {
            for (int i = index;i<charArray.length;i++) {
                swap(charArray,index,i);
                permutation(charArray,set,index+1);
                swap(charArray,index,i);
            }
        }

    }
    public static void swap(char[] arr,int a,int b) {
        if(a == b){
            return;
        }
        char temp = arr[a];
        arr[a]  = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
    String str  = "abcd";
    permutation(str);
    }


}
