package klient;

import java.io.IOException;
import java.util.stream.IntStream;

public class Runner {

        public static void main(String[] args){
            IntStream.range(0,10000).forEach(i->{
                new Thread(()-> {
                    try {final int x =i;
                        String[] arr = {"nr "+i};
                        ClientApp.main(arr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, "Klient nr "+i).start();
            });
    }}
