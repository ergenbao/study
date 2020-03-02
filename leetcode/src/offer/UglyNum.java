package offer;

/**
 * @Author JH
 * 返回第n个丑数
 *
 **/
public class UglyNum {

    public static int getUgly(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int num2 = 0,num3 = 0,num5 = 0;
        for(int i = 1; i<n;i++) {
            int min = Math.min(arr[num2] * 2,Math.min(arr[num3] * 3,arr[num5] * 5));
            arr[i] = min;
            if(arr[num2] * 2 == min) {
                num2++;
            }else if(arr[num3] * 3 == min) {
                num3++;
            }else if(arr[num5] * 5 == min) {
                num5++;
            }
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println(getUgly(5));
    }


}
