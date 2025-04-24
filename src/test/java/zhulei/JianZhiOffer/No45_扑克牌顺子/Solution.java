package zhulei.JianZhiOffer.No45_扑克牌顺子;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/6/11 11:21
 * @Description: LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 *          他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 *          “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 *          并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 *          现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 *          为了方便起见,你可以认为大小王是0。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0};
        System.out.println(isContinuous(arr));
    }

    /*
        满足条件 :
                 1 max - min < 5
                 2 除0外没有重复的数字(牌)
                 3 数组长度为 5
            所以，当排序后，两数差值大于 2，则必定不存在顺子
                 当相邻的两张牌一样（除了大小王），也必定不存在顺子
     */
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length != 5)
            return false;

        Arrays.sort(numbers);
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == 0){
                count++;
                continue;
            }

            if(numbers[i] - numbers[i + 1] < count)
                count -= numbers[i + 1] - numbers[i] - 1;
            else
                return false;

            if(count < 0 || numbers[i] == numbers[i + 1])
                return false;
        }
        return true;
    }
}
