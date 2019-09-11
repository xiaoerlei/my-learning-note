package zhulei.CampusRecruitment.Examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/4 20:35
 * @Description:
 */
public class OtherTwo {

    public static void main(String[] args){
        String[] marks = {"abocde", "aoc", "actld"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < marks.length; i++) {
            list.add(marks[i]);
        }
        System.out.println(candidatesforExtraClasses(3,"aabacd",list));
    }

    static int candidatesforExtraClasses(int numTickets, String drawString, List<String> ticket){
        int count = 0;
        int allowError = 2;
        for (int i = 0; i < numTickets; i++) {
            int indexAim = 0, aIndex = 0, bIndex = 0;
            while (indexAim < drawString.length()) {
                if(drawString.charAt(aIndex) != ticket.get(i).charAt(bIndex))
                    allowError--;

                aIndex++;
                bIndex++;

                if(allowError == 0){
                    allowError = 2;
                    indexAim++;
                    aIndex = indexAim;
                    bIndex = 0;
                }

                if(bIndex + allowError == ticket.get(i).length()) {
                    count++;
                    break;
                }

                if(aIndex == drawString.length())
                    break;
            }
        }
        
        return count;
    }

}
