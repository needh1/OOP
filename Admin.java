import java.io.*;
/**
 * Represents an admin account in the system.
 * An admin has rights to edit certain records in the system.
 */
public class Admin implements Serializable
{
    /**
     * The username of the admin account.
     */
    private String username;
    /**
     * The password of the admin account.
     */
    private String password;

    /**
     * Creates a new admin account with the given username and password.
     * @param username Admin account's username.
     * @param password Admin account's password.
     */
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of this admin account.
     * @return this admin account's username.
     */
    public String getUsername(){
        return username;
    }

    /**
     * Gets the password of this admin account.
     * @return this admin account's password.
     */
    public String getPassword(){
        return password;
    }
}