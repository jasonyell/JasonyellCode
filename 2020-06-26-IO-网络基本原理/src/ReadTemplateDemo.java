import java.io.*;
import java.util.Scanner;

/**
 * @program: 2020-06-26-IO-网络基本原理
 * @description
 *
 * @author: JasonYell
 * @create: 2020-09-08 23:31
 **/
public class ReadTemplateDemo {

    public static void 字符数据() throws IOException {
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                }
            }
        }

    }

    /**
     * 以后常用
     */
    public static void 字符数据2() throws IOException {
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            // 代码到达此处时 已将字节流 -> 字符流 操作完成
            try (Scanner scanner = new Scanner(is, "UTF-8")) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        }
    }

    public static void 字节数据() throws IOException {
        try (InputStream is = new FileInputStream("测试目录\\logo.png")) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = is.read(buffer)) != -1) {
                // 使用 buf[0:n)
            }
        }
    }
}
