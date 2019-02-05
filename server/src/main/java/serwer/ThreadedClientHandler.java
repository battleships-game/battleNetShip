package serwer;

import sterowanie.Kontroler;
import kontrola.ObiektDoPrzesyłania;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class ThreadedClientHandler implements Runnable
{
    private Socket incoming;
    private Kontroler kontroler;
    private BlockingQueue<String> wiadomosci = new ArrayBlockingQueue(10);

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
                   kontroler.rozpakuj(obiektDoPrzesyłania);
//                   wiadomosci.add("Coś wpisać");//TODO
                }} catch (IOException | ClassNotFoundException e) {

            }
        }, "słuchacz_wątkowy_"+Thread.currentThread().getName()).start();

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

        }, "mówca_wątkowy_"+Thread.currentThread().getName()).start();
    }


}
