package zhulei.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ExamTest {

    public static void main(String[] args) {
        int[] nums = {9, 10, 4, 0, 9};
        System.out.println(isStraight(nums));
    }

    public static boolean isStraight(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }
        Integer[] numArr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numArr[i] = nums[i];
        }
        Arrays.sort(numArr, Comparator.comparingInt(x -> x));
        int count = 0;
        for(int i = 0; i < numArr.length; i++) {
            if(numArr[i] == 0) {
                count++;
                continue;
            }
            if(i != 0 && numArr[i] - numArr[i - 1] == 0) {
                return false;
            }
            if(i != 0 && numArr[i - 1] != 0 && numArr[i] - numArr[i - 1] > 1) {
                count -= numArr[i] - numArr[i - 1] - 1;
            }
        }
        return count >= 0;
    }

}
