package zhulei.JavaNote.IO.System标准输出;

/**
 * @Author: zl
 * @Date: 2019/4/20 12:47
 * @Description:
 */
public class Print {

    public static void main(String[] args) {
        int a = 65;
//        printMethod(a); // 控制台打印输出的几种方式

        comparePrintAndWrite(a);   // 对于println和write
    }

    // 控制台输出的四种方式
    private static void printMethod(int a) {
        // println当输出的是一个基本数据类型时，会自动转换成字符串，如果输出的是一个对象，会自动调用对象的toString();方法
        System.out.println(a);

        System.out.print(a);
        System.out.println();

        System.out.printf("%d\n", a);   // 这个方法延续了C语言的输出方式，通过格式化文本和参数列表输出。

        // write是写一个从流中读到的字节时可以显示为一个字符，此时放到缓冲区，但是无法输出 (write方法，本身不会写入换行符)
        System.out.write(a);
        System.out.println();
        // 因为写到缓存里了，再调用System.out.flush()，System.out.write("\n")，或者再增加一个打印语句，就可以输出了

//        System.out.flush();
    }
    /*
        read write 这个以char为核心 就是 unicode  16位 能解决编码问题
        input output 这个以byte为核心 就是ascII 处理英文数字方便  但无法处理编码问题
    */


    // 从流的方面来进行分系
    private static void comparePrintAndWrite(int a) {
        // println()方法是字节流
        System.out.println(a);

        // 由于读不到换行符，意味中读不到结束标记，然后由于IO流是阻塞式的，所以程序就是一直卡在那里不动了
        System.out.write(a);    // write()方法是字符流
        System.out.flush();   // 这里利用flush把缓冲区的内容输出，也可以达到输出的效果
    }
    // 关于flush
    /*
        flush()意思是把缓冲区的内容强制的写出。因为操作系统的某些机制，为了防止一直不停地磁盘读写，所以有了延迟写入的概念。

        主要用在IO中，即清空缓冲区数据，一般在读写流(stream)的时候，数据是先被读到了内存中，再把数据写到文件中，
        当数据读完的时候不代表你的数据已经写完了，因为还有一部分有可能会留在内存这个缓冲区中。
        这时候如果你调用了close()方法关闭了读写流，那么这部分数据就会丢失，所以应该在关闭读写流之前先flush()。
     */
}
