package tcp.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 *
 *      Server 端
 *          将传入的连接 放入线程中
 *
 * @author: JasonYell
 * @create: 2020-09-16 16:25
 **/
public class ServerThreadPool {
    public static final int SERVER_PORT = 9260;

    public static void main(String[] args) throws IOException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(8);

        // 1. 开店（创建 TCP 的服务端 socket -- ServerSocket）
        Logger.debug("准备创建 serverSocket ");
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            Logger.debug("创建 ServerSocket 成功，端口是" + SERVER_PORT);
            // 2. 等待客户订餐电话
            while (true) {
                // 3. 因为 TCP 是有连接的，所以,不能直接读取数据,应该先接电话
                // 这个 accept() 方法的调用，就是在接电话
                // 备注： 该方法是阻塞的  没人打电话过来前，一直不返回
                Logger.debug("等待获取建立好的连接(等待接电话)");
                Socket socket = serverSocket.accept();
                Logger.debug("获取建立好的连接成功（有人打电话，并成功接听）");
                // socket socket 代表就是连接的那个连接(已经接通电话)

                Runnable task = new RequestResponseTask(socket);
                threadPool.execute(task);

            }
        }
    }

    private static String echoService(String request) {
        return request;
    }
}
