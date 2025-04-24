package zhulei.JianZhiOffer.No46_孩子们的游戏;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/6/12 13:27
 * @Description: 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 *          HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 *              首先,让小朋友们围成一个大圈。
 *              然后,他随机指定一个数 m,让编号为0的小朋友开始报数。
 *              每次喊到 m - 1 的那个小朋友要出列唱首歌,
 *              然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 *              从他的下一个小朋友开始,继续 0 ... m - 1报数....
 *              这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 *          请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 2));
    }

    public static int LastRemaining_Solution(int n, int m) {
        int number = 1;
        if(n == 0)
            return -1;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            // 只剩一个孩子的时候跳出循环
            if(list.size() == 1)
                break;
            // 让叫到号码的孩子出去
            if(number % m == 0){
                list.remove(i);
                i--;
            }
            // 安全性检查，避免数组越界
            if(i == list.size() - 1)
                i = -1;

            number++;
        }
        
        return list.get(0);
    }
}
