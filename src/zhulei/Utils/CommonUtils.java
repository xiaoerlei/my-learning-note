package zhulei.Utils;

public class CommonUtils {

    public static void swap(int[] arr, int indexA, int indexB) {
        if (indexA >= arr.length || indexB >= arr.length) {
            return;
        }
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
