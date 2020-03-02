package offer;

import java.util.ArrayList;

/**
 * @Author JH
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * 定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是最先出现的两个数乘积最小
 **/
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length<2) {
            return list;
        }
        int left = 0 ;
        int right = array.length -1;
        while (left < right) {
            int curSum = array[left] + array[right] ;
            if(curSum == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }else if(curSum > sum){
                right--;
            }else {
                left++;
            }
        }
        return list;

    }

}
