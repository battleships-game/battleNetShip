package klient;

import java.io.IOException;
import java.util.stream.IntStream;

public class Runner {

        public static void main(String[] args) throws IOException, InterruptedException {
            IntStream.range(0,2500).forEach(i->{
                new Thread(()-> {
                    try {
                        ClientApp.main(args);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            });
    }}
