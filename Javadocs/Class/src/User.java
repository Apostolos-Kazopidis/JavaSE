import java.io.Serializable;

/**
 * Data Class storing info for users
 */
public class User implements Serializable {
    private String fullName;
    private String username;
    private String password;
    private int role;

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
