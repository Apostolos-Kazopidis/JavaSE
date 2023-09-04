import java.io.Serializable;
import java.util.logging.Logger;

public class User implements Serializable {
    private String fullName;
    private String username;
    private String password;
    private int role;

    public static final Logger logger = Logger.getLogger(User.class.getName());

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
        return fullName + '[' +
                "username='" + username + "', " +
                "password='" + password + "', " +
                "role=" + (role==1? "'admin'" : "'user'" ) + "]";
    }
}
