package tcp.echo;

import jdk.internal.util.xml.impl.Input;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 *
 *      TCP    短连接    echo 服务
 *      Socket：
 *          专为服务端使用的 Socket    ServerSocket
 *
 *          专为客户端使用的 Socket    Socket
 *
 *      读取/写入数据的时候， 使用 java 中的 Stream 抽象类 ( InputStream / OutputStream ) 之前 I/O
 *
 * @author: JasonYell
 * @create: 2020-09-15 16:35
 **/
public class Server {
    public static final int SERVER_PORT = 9260;


    public static void main(String[] args) throws IOException {
        // 1. 开店（创建 TCP 的服务端 socket -- ServerSocket）
        Logger.debug("准备创建 Sersocket ");
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            Logger.debug("创建 ServerSocket 成功，端口是" + SERVER_PORT);
            // 2. 等待客户订餐电话
            while (true) {
                // 3. 因为 TCP 是有连接的，所以,不能直接读取数据,应该先接电话
                // 这个 accept() 方法的调用，就是在接电话
                // 备注： 该方法是阻塞的  没人打电话过来前，一直不返回
                Logger.debug("等待获取建立好的连接(等待接电话)");
                Socket socket = serverSocket .accept();
                Logger.debug("获取建立好的连接成功（有人打电话，并成功接听）");
                // socket socket 代表就是连接的那个连接(已经接通电话)

                // 如果有兴趣知道对方是谁
                // 一个连接中， remote 代表对方， local 代表自己
                SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
                Logger.debug("对方的地址是： " + remoteSocketAddress);
                int port = socket.getPort();
                Logger.debug("对方的端口是: " + port);
                // 4. 从 socket 中 获取 InputStream 作为输入流， OutpuStream 作为输出流
                //    TCP 建立的连接时 全双工 的
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Logger.debug("获取连接中的 InputStream 和 OutputStream");

                // 5.按照 IO 中学过的套路，进行数据的读取和写入过程
                //  我们实现的是“短连接”的方式，所以，只需要读取一次请求，发送一次响应
                //  就可以挂电话了

                // 读取的套路（因为想以字符方式读取， 所以使用 Scanner 去读取）
                Scanner scanner = new Scanner(inputStream, "utf-8");

                // 写入的套路(OutputStream -> WriterStream -> PrintWriter）
                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(outputStream,"utf-8")
                );

                Logger.debug("使用 IO 学习的方式，封装输入 输出流");

                // 读取请求
                // 没有做任何的错误处理（对方没有发送正确格式的请求 等)
                // nextLine() 也是阻塞的，对方不说话，不会返回
                // 等待对方发送请求
                String request = scanner.nextLine();
                Logger.debug("对方发送的请求是："+request);
                String response = echoService(request);
                Logger.debug("回给对方的响应是："+response);

                // 写入发送相应
                Logger.debug("准备发送响应");
                writer.printf("%s\r\n", response);
                Logger.debug("调用 flush 操作， 把数据真正写入 socket ");
                writer.flush();
                Logger.debug("发送响应并成功");



                // 6. 调用 close 就好比 挂断电话
                // 主动挂电话的人， 不一定就是打电话的人
                Logger.debug("准备关闭连接");
                socket.close();
                Logger.debug("关闭连接成功");
            }
        }
    }

    private static String echoService(String request) {
        return request;
    }

}
