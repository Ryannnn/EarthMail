package earth.mail.testlib;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;

import com.sun.mail.imap.IMAPFolder;

public class CheckMail {

    public boolean mailExists(String sender) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session;

        session = Session.getDefaultInstance(props, null);
        Store store;
        store = session.getStore("imaps");
        store.connect("imap.126.com", "iamnotman88@126.com", "csd1002");
        IMAPFolder folder = (IMAPFolder) store.getFolder("inbox");
        folder.open(Folder.READ_ONLY);

        Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
        Message message[] = folder.search(unseenFlagTerm);

        try {
            int j = message.length - 1;
            for (int i = j; i >= 0; i--) {
                if (((InternetAddress)message[i].getFrom()[0]).getAddress().equals(sender))
                    return true;

            }
        }

        finally {
            folder.close(false);
            store.close();
        }

        throw new RuntimeException();

    }

}
