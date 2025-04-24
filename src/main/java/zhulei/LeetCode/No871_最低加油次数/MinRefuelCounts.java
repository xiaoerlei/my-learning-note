package zhulei.LeetCode.No871_最低加油次数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/4/29 21:05
 * @Description: 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 *          沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 *          假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 *          当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 *          为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 *
 *          注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 */
public class MinRefuelCounts {

    public static void main(String[] args) {
        int target = 1000000000;
        int startFuel = 1000000000;
//        int[][] stations = {{10, 1000000000} ,{200, 1000000000}, {300, 1000000000}, {600, 1000000000}};
        int[][] stations = {{40, 50}};
        System.out.println(minRefuelStops(target, startFuel, stations));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int times = 0;
        // 使用优先队列，这样就每次可以在队列中取出最大的油量来进行补充
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });

        int stationCount = stations.length;
        int[] stationDistance = new int[stationCount];  // 加油站距离数组
        int[] stationFuel = new int[stationCount];  // 加油站油量数组
        for (int i = 0; i < stationCount; i++) {
            stationDistance[i] = stations[i][0];
            stationFuel[i] = stations[i][1];
        }

        int currentFuel = startFuel;    // 汽车当前存储的油量
        int currentPosition = 0;    // 当前时第几个加油站

        while(currentFuel < target){
            // 如果路过当前加油站，则将油放入队列中，油不足的话可以取出
            while (currentPosition < stationCount && stationDistance[currentPosition] <= currentFuel){
                priorityQueue.add(stationFuel[currentPosition]);
                currentPosition++;  // 当前加油站的油拿走了，指针后往移动
            }
            // 如果队列里的备用油都用完了，则无法到达终点
            if(priorityQueue.isEmpty())
                return -1;
            // 加油
            currentFuel += priorityQueue.poll();
            times++;
        }
        return times;
    }
}
