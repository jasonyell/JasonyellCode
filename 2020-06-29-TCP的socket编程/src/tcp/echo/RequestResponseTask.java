package tcp.echo;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 *
 *      封装线程内的任务：
 *
 *
 * @author: JasonYell
 * @create: 2020-09-16 16:29
 **/
public class RequestResponseTask implements Runnable {

    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 如果有兴趣，知道对方是谁（host + port）
            // 一个连接中，remote 代表对方    local 代表自己
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            Logger.debug("对方的地址是: " + remoteSocketAddress);
            int port = socket.getPort();
            Logger.debug("对方的端口是: " + port);

            // 4. 从 Socket 中获取 InputStream 作为输入流，获取 OutputStream 作为输出流
            //    TCP 建立的连接是 全双工 的
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Logger.debug("获取连接中的 InputStream 和 OutputStream");

            // 5. 按照 IO 中学过的套路，进行数据的读取和写入过程
            //    我们实现的是“短连接”的方式，所以，只需要读取一次请求，发送一次响应
            //    就可以挂电话了

            // 读取的套路（因为想以字符方式读取，所以使用 Scanner 去读取
            // 写入的套路（OutputStream -> Writer -> PrintWriter）
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(outputStream, "UTF-8")
            );
            Logger.debug("使用 IO 中学习的方式，封装 输入流和输出流");

            // 读取请求
            // 没有做任何的错误处理（对方没有发送正确格式的请求 等）
            // nextLine 也是阻塞的，对方不发送数据，不会返回
            Logger.debug("等待对方发送请求");
            String request = scanner.nextLine();
            Logger.debug("对方发送的请求是: " + request);

            String response = echoService(request);
            Logger.debug("回给对方的响应是: " + response);
            // 发送响应
            Logger.debug("准备发送响应");
            writer.printf("%s\r\n", response);
            Logger.debug("调用 flush 操作，把数据真正写入 socket 中");
            writer.flush();
            Logger.debug("发送响应成功");

            // 6. 调用 close 就好比 挂掉电话
            //    主动挂电话的人，不一定就是主动拨电话的人
            Logger.debug("准备关闭连接（挂断电话）");
            socket.close();
            Logger.debug("成功关闭连接");
        } catch (IOException e) {
            Logger.error(e.toString());
        }
    }

    private static String echoService(String request) {
        return request;
    }
}
