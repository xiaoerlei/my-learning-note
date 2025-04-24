package zhulei.JianzhiOffer.No28_数组中出现次数超过一半的数字;

/**
 * @Author: zl
 * @Date: 2019/5/31 13:29
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *              例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *              由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }

    /*
        思路：
            要找的数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现的次数的和还要多

            因此，可以定义两个变量，分别保存数组中某个变量的值，以及它出现的次数
            然后，如果下一个数字和当前我们保存的数字相同，则次数加 1，如果和当前我们保存的数字不同，则次数减 1
            所以，这样就一定能得到，如果存在某个值出现的次数达到一大半，那么最终它的次数不会为负。count > length / 2，无论如何减都是大于0的

        注：当然可以考虑用HashMap或者Arrays.sort()的方法来做。
            HashMap的话，首先数据结构会复杂一些，并且还要逐个去统计出现次数，所以效率会比较低
            Arrays.sort()基于快排和归并，时间复杂度是ONlog N，相比上面的On 复杂度要高一些
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        int result = array[0];  // 取当前值为次数最大值
        int count = 1;      // 默认次数为1

        for(int i = 1; i < array.length; ++i) {
            if(array[i] == result)   // 相同则 +1
                count++;
            else if(count == 0){    // 如果次数变为0，则重置最大值
                result = array[i];
                count = 1;
            } else      // 不同则 -1
                count--;
        }

        // 最后将count置为0，计算当前result是的count是否大于长度的一半
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == result)
                count++;
        }

        return count > array.length / 2 ? result : 0;
    }
}
