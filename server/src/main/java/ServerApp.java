import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args )
    {
        try (ServerSocket s = new ServerSocket(8888))
        {
            while (true)
            {
                Socket incoming = s.accept();
                System.out.println("Ktoś podłączył sie z portu : " + incoming.getPort());
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable
{
    private Socket incoming;

    public ThreadedEchoHandler(Socket incomingSocket)
    {
        incoming = incomingSocket;
    }

    public void run()
    {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream())
        {
            Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, "UTF-8"),
                    true /* autoFlush */);

            out.println("Podłączyłeś się z portu: " +incoming.getRemoteSocketAddress().toString());
            out.println("Napisz co u Ciebie");

            boolean done = false;
            while (!done && in.hasNextLine())
            {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("q"))
                    done = true;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
