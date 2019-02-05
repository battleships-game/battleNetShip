package serwer;

import kontrola.ObiektDoPrzesyłania;
import sterowanie.Kontroler;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class ThreadedClientHandler implements Runnable
{
    private Socket incoming;
    private BlockingQueue<ObiektDoPrzesyłania> wiadomosci = new ArrayBlockingQueue<>(10);
    private Kontroler kontroler;

    ThreadedClientHandler(Socket incomingSocket, Kontroler kontroler)
    {
        incoming = incomingSocket;
        this.kontroler = kontroler;
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
                    kontroler.rozpakuj(obiektDoPrzesyłania, this);
                }} catch (IOException | ClassNotFoundException e) {

            }
        }, "słuchacz wątkowy").start();

    }

    private void mów() {

        new Thread(()->{
            try ( OutputStream outputStream = incoming.getOutputStream();
                  ObjectOutputStream oos = new ObjectOutputStream(outputStream)
            ) {
                ObiektDoPrzesyłania wiadomosc;
                while(( wiadomosc = wiadomosci.poll(10, TimeUnit.DAYS))!=null){
                    oos.writeObject(wiadomosc);
                    System.out.println("wysłalem jako serwer polecenie: " + wiadomosc.getPolecenie());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }, "mówca wątkowy").start();
    }

    public void dodajDoWysłania(ObiektDoPrzesyłania obiektDoPrzesyłania){
        wiadomosci.add(obiektDoPrzesyłania);
    }

}
