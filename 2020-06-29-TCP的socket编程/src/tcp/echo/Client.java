package tcp.echo;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


/**
 * @program: 2020-06-29-TCP的socket编程
 * @description
 * @author: JasonYell
 * @create: 2020-09-16 02:41
 **/
public class Client {
    private static final int SERVER_PORT = Server.SERVER_PORT;
    private static final String SERVER_HOST = "127.0.0.1";


    public static void main(String[] args) throws IOException {
        Scanner stdinScanner = new Scanner(System.in);

        Logger.debug("准备连接服务端(" + SERVER_HOST + ":" + SERVER_PORT + ")");

        while (true) {
            try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
                Logger.debug("连接已建立");

                SocketAddress localSocketAddress = socket.getLocalSocketAddress();
                Logger.debug("连接中，本地地址是: " + localSocketAddress);
                int localPort = socket.getLocalPort();
                Logger.debug("连接中，本地端口是: " + localPort);
                SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
                Logger.debug("连接中，对方地址是: " + remoteSocketAddress);
                int port = socket.getPort();
                Logger.debug("连接中，对方端口是: " + port);

                System.out.print("请填写请求> ");
                String request = stdinScanner.nextLine();


                OutputStream outputStream = socket.getOutputStream();

                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(outputStream, "UTF-8")
                );
                Logger.debug("准备发送请求: " + request);
                writer.printf("%s\r\n", request);
                Logger.debug("发送调用成功，记得 flush");
                writer.flush();
                Logger.debug("请求发送成功");

                InputStream inputStream = socket.getInputStream();

                Scanner scanner = new Scanner(inputStream, "UTF-8");
                Logger.debug("准备接收响应");
                String response = scanner.nextLine();
                Logger.debug("接收到的响应是: " + response);
                System.out.println(response);

            }
        }

    }
}
