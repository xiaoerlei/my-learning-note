package zhulei.JavaNote.IO.读入写出一个文件;

import java.io.*;

/**
 * @Author: zl
 * @Date: 2019/5/13 14:54
 * @Description: 测试一个io对文件中的行 读写 的程序
 *              用的是BufferedReader和BufferedWriter来处理
 */
public class ReadWriteTest {

    public static void main(String[] args) {

        File file = new File("out.txt");
        String fileName = "E:/Idea/IdeaProject/myJavaNote/src/zhulei/JavaNote/IO/读入写出一个文件/input.txt";

        fileReader_read(file, fileName);

        inputStreamReader_read(file, fileName);

    }

    /*
        用FileReader，把文件转换为字符流读入
     */
    private static void fileReader_read(File file, String fileName) {
        // 这里使用了try-with-resources（JDK1.8的语法糖）来处理检查异常
        // 这样做的好处是让代码看起来更清晰简单，并且JVM会自动处理流关闭的操作
        try(
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            BufferedWriter out = new BufferedWriter(new FileWriter(file))
        ) {
            String line = null;
            while ((line = in.readLine()) != null) {
                if (line.contains("o"))
                    continue;

                out.write(line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        用FileInputStream读取字节流
        再用InputStreamReader将FileInputStream读取到的字节转换为字符
        另外，InputStreamReader的参数中可以自定义编码，这是个重要的特性。
     */
    private static void inputStreamReader_read(File file, String fileName) {
        try (
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), "GBK");
            BufferedReader in = new BufferedReader(reader);
            BufferedWriter out = new BufferedWriter(new FileWriter(file))
        ){

            String line = null;
            while ((line = in.readLine()) != null) {
                if (line.contains("o"))
                    continue;

                out.write(line + "\r\n");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
