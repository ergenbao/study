package offer;

import java.util.Stack;

/**
 * @Author: JH
 * @Date: 2019/4/1 21:06
 * 调整数组顺序，使奇数位于偶数前
 */
public class ReOrderArray {

    public static void main(String[] args) {
       int [] array = {1,2,3,4,5,6,7,8};
       array = reOrderArray(array);
       for (int i = 0 ;i < array.length; i++){
           System.out.print(array[i]);
       }

    }
    public static int [] reOrderArray(int[] array) {
        Stack<Integer> odd = new Stack<Integer>();
        Stack<Integer> even = new Stack<Integer>();
        for(int i = array.length-1 ; i >= 0 ; i--) {
            if((array[i] & 1) == 1) {
                odd.push(array[i]);
            }else {
                even.push(array[i]);
            }

        }

        int i = 0;
        while (!odd.isEmpty()) {
            array[i++] = odd.pop();
        }
        while (!even.isEmpty()) {
            array[i++] = even.pop();
        }
        return array;
    }

}
