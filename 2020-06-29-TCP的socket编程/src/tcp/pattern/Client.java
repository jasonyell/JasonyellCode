package tcp.pattern;

import java.io.IOException;
import java.net.Socket;

/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 * @author: JasonYell
 * @create: 2020-09-16 17:47
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 创建 socket
        Socket socket = new Socket();
        // 2. 绑定本地 ip + 本地 port
        // 如果不调用这个绑定，则 OS 会分配一个合适的 ip 和 port
        // socket.bind(本地 ip + 本地 port);
        // 3. 提供服务端(远端) 的 ip 和 port，进行连接
        // socket.connect(远端 ip + 远端 port);

        // 4. 连接建立成功后，通过 socket 进行数据的读写

        // 5. 在合适的时候，调用 close 关闭连接
        socket.close();
    }

}
