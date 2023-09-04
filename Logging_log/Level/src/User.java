import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class User implements Serializable {
    private String fullName;
    private String username;
    private String password;
    private int role;

    public static final Logger logger = Logger.getLogger(User.class.getName());

    // Block-Static - It runs only once
    static {
        try {
            FileHandler handler = new FileHandler("logs.log");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
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

        logger.log(Level.FINE, "User " + fullName + " initialized.");
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        logger.log(Level.FINEST, "User " + fullName +  " accessed.");

        return fullName + '[' +
                "username='" + username + "', " +
                "password='" + password + "', " +
                "role=" + (role==1? "'admin'" : "'user'" ) + "]";
    }
}
