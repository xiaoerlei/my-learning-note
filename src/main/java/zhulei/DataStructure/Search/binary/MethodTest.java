package zhulei.DataStructure.Search.binary;


/**
 * @Author: zl
 * @Date: 2022/8/5 20:29
 * @Description:
 */
public class MethodTest {

    public static void main(String[] args) {
        int[] arr = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(BinarySearch.binarySearch(arr, 0, arr.length - 1, 22));
        System.out.println(BinarySearch.binarySearch(arr, 50));

        int[] dupArr = {1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 6, 6};
        System.out.println(BinarySearch.findFirstElement(dupArr, 2));
        System.out.println(BinarySearch.findLastElement(dupArr, 2));
    }
}
