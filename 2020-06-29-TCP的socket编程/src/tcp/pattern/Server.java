package tcp.pattern;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 *
 *      备注：有两个 socket： 一个是 专门的 accept socket   一个是用于读写数据的 socket
 *           1. 创建 socket
 *           2. 为 socket 绑定 本地 ip 和 本地 port
 *           3. socket 开始监听（listen）
 *           4. 调用 accept() 等待有客户端连接上来，最终得到的是建好连接的 socket（什么叫做建好连接，以后解释）
 *           5. 通过 socket 进行读写数据
 *           6. 关闭 socket
 *
 * @author: JasonYell
 * @create: 2020-09-16 17:42
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        // 1. 创建 socket（ServerSocket）
        ServerSocket serverSocket = new ServerSocket();
        // 2. 绑定本地 ip + 本地 port
        //    0.0.0.0 代表：绑定机器上的所有 ip
        int SERVER_PORT = 8888;
        serverSocket.bind(new InetSocketAddress("0.0.0.0", SERVER_PORT));
        // 3. listen
        // 监听，开始等电话

        while (true) {
            // 4. 获取建立成功的连接
            Socket socket = serverSocket.accept();

            // 利用 socket 进行数据的读写

            socket.close();
        }
    }

}
