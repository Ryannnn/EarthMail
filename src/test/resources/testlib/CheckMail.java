package testlib;

public class CheckMail {
    
     public boolean mailExists(String sender) {
        if (sender.equals("foamtea30@126.com")) 
            return true;
        throw new RuntimeException();
    }

}
