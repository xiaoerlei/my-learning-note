package zhulei.CampusRecruitment.Baidu.亨利回家;

/**
 * @Author: zl
 * @Date: 2019/4/2 20:23
 * @Description: 亨利下班回家。从公司到家有N公里，每行驶一公里要消耗一升油，途中有一定数量的加油站，每个加油站能加油的数量有限
 *              问亨利从公司到家可加油的最少次数为多少？
 */
public class Main {

    public static void main(String[] args) {
        int n = 3;
        int[] nn = {5,7,10};
        int[] xx = {2,3,5};
        int x = 15;
        int y = 5;
        int res = minGasStation(n,nn,xx,x,y);
        System.out.println(res);
    }

    /**
     *
     * @param numOfGS 加油站的数量
     * @param distOfGS 每个加油站离家的距离
     * @param allowedGasoline 每个加油站可加油的最大数量
     * @param distance 公司离家的距离
     * @param initialGasoline 初始汽油量
     * @return 如果成功回家，则返回最少加油次数
     *          否则，返回-1
     */
    public static int minGasStation(int numOfGS, int[] distOfGS,
                             int[] allowedGasoline, int distance,
                             int initialGasoline)
    {
        int count = 0;
        int hadSupply = 0;  // 上一次加油的位置
        int temp = 0;   // 零时保存上一次加油的位置
        int sum = initialGasoline;  // 统计整个过程最多可以加多少油
        for (int i = 0; i < distOfGS.length; i++) {
            sum += distOfGS[i];
        }

        if(sum < distance)  // 如果在每个加油站加油都无法回家，则回家失败
            return -1;

        while(distance > 0){
            int index = 0;
            for (int i = 0; i < numOfGS; i++) {
                distOfGS[i]--;
                if(distOfGS[i] <= 0)
                    index++;
            }            

            while (initialGasoline <= 0){
                temp = bigestGasine(allowedGasoline, hadSupply, index);
                initialGasoline += allowedGasoline[temp];   // 加油
                allowedGasoline[temp] = -1;  // 置为-1，防止在找最大容量油的时候再次被选中
            }
            hadSupply = temp;   // 移动下标

            initialGasoline--;
            distance--;
        }
        //  当加油站的油量为-1的时候，则表示在这个加油站加了油
        for (int i = 0; i < allowedGasoline.length; i++) {
            if(allowedGasoline[i] == -1)
                count++;
        }
        return count;
    }

    // 返回经过路段，最大的油量的下标
    private static int bigestGasine(int[] allowedGasoline, int hadSupply, int index) {
        int max = 0;
        int res = 0;
        for (int i = hadSupply; i < index; i++) {
            if(allowedGasoline[i] >= max) {
                max = allowedGasoline[i];
                res = i;
            }
        }
        return res;
    }

}
