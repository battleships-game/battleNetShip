package io;

import java.util.List;

public class Drukarka {
    public void print(String... message){
        for(int i=0; i<message.length; i++){
            System.out.print(message[i]);
        }
    }
    public void println(List<String> messageList){
        for(int i=0; i<messageList.size(); i++){
            System.out.println(messageList.get(i));
        }
    }

}
