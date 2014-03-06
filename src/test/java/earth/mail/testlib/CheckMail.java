package earth.mail.testlib;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;

import com.sun.mail.imap.IMAPFolder;

public class CheckMail {

    private static final String SERVER_PROTOCOL_NAME = "mail.store.protocol";
    private static final String SERVER_PROTOCOL_VALUE = "imaps";
    
    public boolean mailExists(String sender) throws MessagingException {
        Store mailbox = connectMailbox();
        IMAPFolder folder = null;
        try {
            try {
                folder = openFolder(mailbox);
                for (Message message : getAllUnseenMessages(folder))
                    if (doesSenderEqual(sender, message))
                        return true;
            } finally {
                folder.close(false);
            }
        } finally {
            mailbox.close();
        }

        throw new RuntimeException();
    }

    private boolean doesSenderEqual(String sender, Message message)
            throws MessagingException {
        return ((InternetAddress) message.getFrom()[0]).getAddress().equals(sender);
    }

    private Message[] getAllUnseenMessages(IMAPFolder folder)
            throws MessagingException {
        Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
        Message message[] = folder.search(unseenFlagTerm);
        return message;
    }

    private IMAPFolder openFolder(Store store) throws MessagingException {
        IMAPFolder folder = (IMAPFolder) store.getFolder("inbox");
        folder.open(Folder.READ_ONLY);
        return folder;
    }

    private Store connectMailbox() throws NoSuchProviderException,
            MessagingException {
        Session session = Session.getDefaultInstance(createProtocolProps(),
                null);
        Store store = session.getStore(SERVER_PROTOCOL_VALUE);
        store.connect("imap.126.com", "iamnotman88@126.com", "csd1002");
        return store;
    }

    private Properties createProtocolProps() {
        Properties props = new Properties();
        props.put(SERVER_PROTOCOL_NAME, SERVER_PROTOCOL_VALUE);
        return props;
    }

}
