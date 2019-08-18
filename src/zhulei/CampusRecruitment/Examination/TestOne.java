package zhulei.CampusRecruitment.Examination;

import java.util.*;

public class TestOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String numStr = findNumString(s);
            System.out.println(numStr);
        }
        sc.close();
    }

    private static String findNumString(String s) {
        List<Character> list = new ArrayList<>();
        char[] charStr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(charStr[i] >= '0' && charStr[i] <= '9')
                list.add(charStr[i]);
        }

        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        if(sb.length() == 0)
            return "-1";

        return sb.toString();
    }

}
