import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.*;

public class User implements Serializable {
    private String fullName;
    private String username;
    private String password;
    private int role;

    public static final Logger logger = Logger.getLogger(User.class.getName());

    static {
        try {
            LogManager logManager = LogManager.getLogManager();
            logManager.readConfiguration(new FileInputStream("logging.properties"));

            FileHandler handler = new FileHandler("logs.log");
            handler.setFormatter(new SimpleFormatter());

            FileHandler handler2 = new FileHandler("logs.xml");
            handler2.setFormatter(new XMLFormatter());

            logger.addHandler(handler);
            logger.addHandler(handler2);
            logger.setLevel(Level.FINEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User(String fullName, String username, String password, int role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        LogRecord record = new LogRecord(Level.FINE, "");
        record.setMessage(record.getSequenceNumber() + ": User " + fullName + " accessed");
        logger.log(record);

        return fullName + '[' +
                "username='" + username + "', " +
                "password='" + password + "', " +
                "role=" + (role==1? "'admin'" : "'user'" ) + "]";
    }
}
