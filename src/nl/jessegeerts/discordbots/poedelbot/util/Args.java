package nl.jessegeerts.discordbots.poedelbot.util;

public class Args {

    private final String banandkick(String[] args){
        String msg = "";
        String[] arrayOfString;
        int j = (arrayOfString = args).length;
        for (int i = 1; i < j; i++) {
            String a = arrayOfString[i];
            msg = msg + " " + a;
        }
        return msg;
    }


    private final String regular(String[] args){
        String msg = "";
        String[] arrayOfString;
        int j = (arrayOfString = args).length;
        for (int i = 0; i < j; i++) {
            String a = arrayOfString[i];
            msg = msg + " " + a;
        }
        return msg;
    }
}
