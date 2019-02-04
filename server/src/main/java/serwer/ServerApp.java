package serwer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class ServerApp {
    public static void main(String[] args )
    {
        int i =0;

        try (ServerSocket s = new ServerSocket(8888))
        {
            while (true)
            {
                Socket incoming = s.accept();
                System.out.println("Ktoś podłączył sie z portu : " + incoming.getPort());
                Runnable r = new ThreadedClientHandler(incoming);
                Thread t = new Thread(r);
                i++;
                System.out.println("tyle zalogowanych: " + i);
                t.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class ThreadedClientHandler implements Runnable
{
    private Socket incoming;
    private BlockingQueue<String> wiadomosci = new ArrayBlockingQueue<>(10);

    ThreadedClientHandler(Socket incomingSocket)
    {
        incoming = incomingSocket;
    }

    @Override
    public void run() {
        słuchaj();
        mów();
    }

    private void słuchaj() {
        new Thread(()-> {
            try (InputStream inStream = incoming.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(inStream)) {
                ObiektDoPrzesyłania obiektDoPrzesyłania;
                while ((obiektDoPrzesyłania = (ObiektDoPrzesyłania) ois.readObject())!= null) {
                    System.out.println(obiektDoPrzesyłania.polecenie);
                }} catch (IOException | ClassNotFoundException e) {

            }
        }, "słuchacz wątkowy").start();

    }

    private void mów() {

        new Thread(()->{
            try ( OutputStream outputStream = incoming.getOutputStream()) {
                String wiadomosc;
                while(( wiadomosc = wiadomosci.poll(10, TimeUnit.DAYS))!=null){
                    outputStream.write((wiadomosc + LocalDateTime.now().toString()+"\n").getBytes());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }, "mówca wątkowy").start();
    }


}
