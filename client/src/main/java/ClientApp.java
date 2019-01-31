import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

public class ClientApp
{

    public static void main(String[] args) throws IOException, InterruptedException {
        var scanner = new Scanner(System.in);
        var socket = new Socket(InetAddress.getLocalHost(), 8888);
        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        Thread.sleep(500);
        socket.getOutputStream().write("sacad\n".getBytes(Charset.defaultCharset()));


    }

}

