package zhulei.CampusRecruitment.Examination;

import java.util.*;

public class TestOne {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            list.add(input);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] strArr = list.get(i).split(" ");
            if (isCorrect(strArr))
                System.out.println(isRight(strArr));
            else
                System.out.println("error");
        }

        sc.close();
    }

    private static boolean isCorrect(String[] strArr) {
        if(strArr.length % 2 != 1)
            return false;

        for (int i = 0; i < strArr.length; i++) {
            if(i % 2 == 0){
                if(!strArr[i].equals("true") && !strArr[i].equals("false"))
                    return false;
            }
            else {
                if(!strArr[i].equals("and") && !strArr[i].equals("or"))
                    return false;
            }
        }

        return true;
    }

    private static boolean isRight(String[] strArr) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strArr.length; i++) {
            stack.push(strArr[i]);
        }

        Stack<String> operate = new Stack<>();
        while (!stack.isEmpty()){

            if (stack.peek().equals("and")){
                stack.pop();
                operate.push(cal(stack.pop(), operate.pop()));
            }
            else {
                operate.push(stack.pop());
            }

        }

        return operate.contains("true");
    }

    private static String cal(String str1, String str2) {
        boolean b1 = str1.equals("true") ? true : false;
        boolean b2 = str2.equals("true") ? true : false;

        String res = "";
        if(b1 && b2)
            res = "true";
        else
            res = "false";

        return res;
    }


}



