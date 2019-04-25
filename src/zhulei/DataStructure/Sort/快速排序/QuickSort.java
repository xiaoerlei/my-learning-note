package zhulei.DataStructure.Sort.快速排序;

/**
 * @Author: zl
 * @Date: 2019/4/24 18:39
 * @Description: 快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。
 *              每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
 *              这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。
 *              因此总的比较和交换次数就少了，速度自然就提高了。
 *              当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
 *              因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 7};
        quickSort_base(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort_base(int[] arr, int low, int high) {
        int i, j, temp;
        if(low > high)
            return;

        i = low;
        j = high;
        temp = arr[low];   // 将第一个数作为基数

        // 这里先从右边找，再从左边找，但是如果顺序相反则不对，这是为什么？
        /*
            其实快排没有一定要从右边开始，只是取决于基数的位置，如果基数选的是最左边的，就一定要确保，交换基数的时候，被交换的数要小于基数。但是如果右边开始，就无法保证了
            比如：
                2 1 4 9           首先左边left 会到4这里，这样9也会到4.然后进行交换。显然就出错了。肯定不可能 4 1 2 9 所以为什么不能左边开始。
                                  当从右边开始的时候，就一定是可以保证，因为那个数一定是小于等于基数的，比如上面就会找到 1 就会 1 2 4 9 这样2归位。
            或者说最不济的情况， 找不到小于基数的。比如：
                2 3 4 9           右边开始，这样也会定位到2的本身，顶多这次交换是 2 和 2 的交换， 2 3 4 9，否则就是 9 2 3 4

            所以，从左边开始，是不能保证最后交换的那个数，是小于等于左边的
         */
        while (i < j){

            // 先从右边开始找，找到一个大于等于基准数的数
            while (arr[j] >= temp && i < j){
                j--;
            }

            // 再从左边开始找，找到一个小于等于基准数的数
            while (arr[i] <= temp && i < j){
                i++;
            }

            // 交换左边小于和右边大于基准数的两个数
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // 交换第一个数与基数
        arr[low] = arr[i];
        arr[i] = temp;

        quickSort_base(arr, low, i - 1);    // 递归左边
        quickSort_base(arr, i + 1, high);   // 递归右边
    }


}
