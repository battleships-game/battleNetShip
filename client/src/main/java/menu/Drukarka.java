package menu;

class Drukarka {
    void print(String... message){
        for(int i=0; i<message.length; i++){
            System.out.print(message[i]);
        }
    }
}
