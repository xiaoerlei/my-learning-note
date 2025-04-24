package zhulei.JianZhiOffer.No44_反转单词顺序列;

/**
 * @Author: zl
 * @Date: 2019/6/11 11:05
 * @Description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *          同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 *          后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 *          Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(ReverseSentence("student. a am I"));
        System.out.println(ReverseSentence(" "));
    }

    public static String ReverseSentence(String str) {
        String[] strArr = str.split(" ");
        if(str.length() != 0 && strArr.length == 0)
            return str;
        // 用StringBuilder来反向拼接切分的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if(i != 0)
                sb.append(strArr[i]).append(" ");
            else
                sb.append(strArr[i]);
        }
        return sb.toString();
    }
}
