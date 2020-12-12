import java.io.*;

/**
 * @program: 2020-06-26-IO-网络基本原理
 * @description
 *
 *      字节流与字符流二者之间的转换，因为这是两种不同的流
 *      所以，在进行转换的时候我们需要用到 OutputStreamWriter 和 InputStreamReader 。
 *
 *      Reader 输入字符流    InputStreamReader  是 Reader 的子类，将输入的字节流转换成字符流
 *      Writer 输出字符流    OutputStreamWriter 是 Writer 的子类，将输出的字符流转换成字节流
 *
 * @author: JasonYell
 * @create: 2020-09-08 22:31
 **/
public class FileStreamDemo {
    public static void main(String[] args) throws IOException {
        // 1. 还是需要，先有字节流
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            // 2. 利用 字节流 作为构造方法构造出 字符流
            try (Reader reader = new InputStreamReader(is, "utf-8")) {
                // 读取的单位变成了 字符 char
                // 已经完成了字符集解析的工作了
                // 单字符读取 vs 批量读取

                //int c = reader.read();  // -1 代表 EOS

                char[] buf = new char[1024];
                int n;
                while ((n = reader.read(buf)) != -1) {
                    for (int i = 0; i < n; i++) {
                        System.out.println(buf[i]);
                    }
                }

            }
        }
        // 批量打印
        // 不能自定义字符集 字符集默认按照项目的字符集编码来(utf-8)
        try (Reader reader = new FileReader("测试目录\\中文.txt")) {
            char[] buf = new char[1024];
            int n;
            while ((n = reader.read(buf)) != -1) {
                for (int i = 0; i < n; i++) {
                    System.out.println(buf[i]);
                }
            }
        }
    }


    /**
     *  关于  中文的内容
     *      ASCII(0x00 - 0x7F)范围  有部分字在词表查不到
     *      一个汉字的字节长度不确定 但一般来说是 3 个字节
     *
     * @param args
     * @throws IOException
     */
    public static void main2 (String[]args) throws IOException {
        // 带有中文字符的读写
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            byte[] buf = new byte[1024];
            int n;
            // 效果和上面完全一样
            // 无法直接根据数据，100% 的确定编码类型
            while ((n = is.read(buf)) != -1) {
                /*
                for (int i = 0; i < n; i++) {
                    // 十进制 和 十六进制输出
                    System.out.printf("|%d|%02x|%n", buf[i], buf[i]);
                }
                */
                // 假设 buf 中读取的中文，没有出现被拆短的形式
                String s = new String(buf, 0, n, "utf8");
                System.out.println(s);
            }


        }
    }


    public static void main1 (String[]args){
        try (InputStream is = new FileInputStream("测试目录\\hello.txt")) {
            byte[] buf = new byte[1024];
            while (true) {
                int n = is.read(buf);
                if (n == -1) {
                    break;
                }
                // 有效数据保存在 buf[0,n)
                for (int i = 0; i < n; i++) {
                    byte b = buf[i];
                    System.out.printf("%c%n", b);
                }
            }
        } catch (IOException IO) {
            IO.printStackTrace();
        }

        /**
         *    1. 如果文件不存在，会进行文件的创建（失败的条件等同于创建文件失败的条件）
         *    2. 如果文件存在，会进行 “覆盖” 式写入
         */
        try (OutputStream os = new FileOutputStream("测试目录\\world.txt")) {
            // 1. 单字节的写入
            os.write('H');
            os.write('\r');
            os.write('\n');
            os.write('W');

            // 2. 批量的写入
            byte[] buf = new byte[1024];

            buf[0] = '\r';
            buf[1] = 'a';
            buf[2] = 'c';
            buf[3] = 'd';

            os.write(buf);


            /**
             * /3. 无论是那种写入方式，一定需要做 flush() 操作
             *          强制要求吧系统（软件部分 JVM/OS) 中缓冲的数据，刷新到真正的硬件中
             *          为了提升速度，很多 OutPut 的类实现中，都会包含缓冲区
             */
            os.flush();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

}
