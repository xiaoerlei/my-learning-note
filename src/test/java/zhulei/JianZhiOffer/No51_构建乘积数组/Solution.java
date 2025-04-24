package zhulei.JianZhiOffer.No51_构建乘积数组;

/**
 * @Author: zl
 * @Date: 2019/6/15 15:50
 * @Description: 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *              其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(multiply(arr).toString());
    }

    // 两次循环交错相乘
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        // 从左到右累乘（1, 1*A[0] ... 1*A[0]*...*A[n - 2]）
        for (int i = 0, temp = 1; i < A.length; temp *= A[i], i++)
            B[i] = temp;
        // 从右往左累乘
        //              1  *  A[2]*...*A[n - 1]*1
        //                  , ... ,
        //              1*A[0]*...*A[n - 3]  *  A[n - 1]*1 ,
        //              1*A[0]*...*A[n - 2]  *  1
        for (int i = A.length - 1, temp = 1; i >= 0; temp *= A[i], i--)
            B[i] *= temp;

        return B;
    }
}
