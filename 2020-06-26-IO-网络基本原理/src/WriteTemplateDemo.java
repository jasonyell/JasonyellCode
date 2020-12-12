import java.io.*;

/**
 * @program: 2020-06-26-IO-网络基本原理
 * @description
 * @author: JasonYell
 * @create: 2020-09-08 23:53
 **/
public class WriteTemplateDemo {

    public static void 字节数据() throws IOException {
        byte[] buffer = new byte[8192];
        // 把 buffer 填充了有效数据
        try (OutputStream os = new FileOutputStream("测试目录\\out.png")) {
            for (int i = 0; i < 8; i++) {
                os.write(buffer, i * 1024, 1024);
            }

            os.flush();
        }
    }

    public static void 字符数据() throws IOException {
        // buffer 中假设是有效数据
        char[] buffer = new char[8192];
        String s = "...";
        try (OutputStream os = new FileOutputStream("测试目录\\输出.txt")) {
            try (Writer writer = new OutputStreamWriter(os, "UTF-8")) {

                /*
                for (int i = 0; i < 8; i++) {
                    writer.write(buffer, i * 1024, 1024);
                }
                writer.flush();
                */

                try (PrintWriter printWriter = new PrintWriter(writer)) {
                    printWriter.println(s);
                    printWriter.printf("想写什么写什么");
                    // 刷新操作不要忘记
                    printWriter.flush();
                }
            }
        }
    }
}
